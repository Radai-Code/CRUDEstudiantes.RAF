package modelo;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivoOrgnDir {
    File fichero;
    RandomAccessFile raf;

    final int NUMCONTROL_LEN = 8;
    final int NOMBRE_LEN = 20;
    final int APELLIDOS_LEN = 20;
    final int SEMESTRE_LEN = 2;
    final int GRUPO_LEN = 1;
    final int CARRERA_LEN = 30;
    final int TAMREG = NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN + CARRERA_LEN;

    public ArchivoOrgnDir() {
        this.fichero = null;
        this.raf = null;
    }

    public boolean abrirArchivoRAF(String nombreArchivo) {
        try {
            this.raf = new RandomAccessFile(nombreArchivo, "rw");
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static String ajustar(String s, int longitud) {
        if (s.length() > longitud) {
            return s.substring(0, longitud);
        } else {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < longitud) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    private long establecerPosicionByte(String numeroControl) {
        int numero = Integer.parseInt(numeroControl.substring(5));
        return (long) (numero - 1) * TAMREG;
    }

    public boolean escribirRegistro(String numControl, String nombre, String apellidos, int semestre, char grupo, String carrera) {
        if (!validarCampos(numControl, nombre, apellidos, semestre, grupo, carrera)) {
            return false;
        }

        // Verificar que no exista antes de escribir
        if (buscarRegistro(numControl) != null) {
            return false; // Ya existe
        }

        long pos = establecerPosicionByte(numControl);
        try {
            raf.seek(pos);
            raf.write(ajustar(numControl, NUMCONTROL_LEN).getBytes("ISO-8859-1"));
            raf.write(ajustar(nombre, NOMBRE_LEN).getBytes("ISO-8859-1"));
            raf.write(ajustar(apellidos, APELLIDOS_LEN).getBytes("ISO-8859-1"));

            DecimalFormat df = new DecimalFormat("00");
            raf.write(df.format(semestre).getBytes("ISO-8859-1"));
            raf.write(String.valueOf(grupo).getBytes("ISO-8859-1"));
            raf.write(ajustar(carrera, CARRERA_LEN).getBytes("ISO-8859-1"));
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean editarRegistro(String numControl, String nuevoNombre, String nuevosApellidos, int nuevoSemestre, char nuevoGrupo, String nuevaCarrera) {
        if (!validarCampos(numControl, nuevoNombre, nuevosApellidos, nuevoSemestre, nuevoGrupo, nuevaCarrera)) {
            return false;
        }

        String[] existente = buscarRegistro(numControl);
        if (existente == null) {
            return false; // No existe
        }

        long pos = establecerPosicionByte(numControl);
        try {
            raf.seek(pos);
            raf.write(ajustar(numControl, NUMCONTROL_LEN).getBytes("ISO-8859-1"));
            raf.write(ajustar(nuevoNombre, NOMBRE_LEN).getBytes("ISO-8859-1"));
            raf.write(ajustar(nuevosApellidos, APELLIDOS_LEN).getBytes("ISO-8859-1"));

            DecimalFormat df = new DecimalFormat("00");
            raf.write(df.format(nuevoSemestre).getBytes("ISO-8859-1"));
            raf.write(String.valueOf(nuevoGrupo).getBytes("ISO-8859-1"));
            raf.write(ajustar(nuevaCarrera, CARRERA_LEN).getBytes("ISO-8859-1"));
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String[] buscarRegistro(String nc) {
        try {
            long pos = establecerPosicionByte(nc);
            raf.seek(pos);
            byte[] buffer = new byte[TAMREG];
            raf.readFully(buffer);

            String nControl = new String(buffer, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();
            if (!nControl.equals(nc) || nControl.startsWith("*")) {
                return null;
            }

            String nombre = new String(buffer, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
            String apellidos = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
            String semestre = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN, "ISO-8859-1").trim();
            String grupo = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN, GRUPO_LEN, "ISO-8859-1").trim();
            String carrera = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN, CARRERA_LEN, "ISO-8859-1").trim();

            return new String[]{nControl, nombre, apellidos, semestre, grupo, carrera};
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String[]> obtenerRegistrosRAF() {
        List<String[]> lista = new ArrayList<>();
        try {
            long numRegistros = raf.length() / TAMREG;
            for (int i = 0; i < numRegistros; i++) {
                raf.seek(i * TAMREG);
                byte[] buffer = new byte[TAMREG];
                raf.readFully(buffer);

                String nControl = new String(buffer, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();
                if (nControl.isEmpty() || nControl.startsWith("*")) {
                    continue;
                }

                String nombre = new String(buffer, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
                String apellidos = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
                String semestre = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN, "ISO-8859-1").trim();
                String grupo = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN, GRUPO_LEN, "ISO-8859-1").trim();
                String carrera = new String(buffer, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN, CARRERA_LEN, "ISO-8859-1").trim();

                lista.add(new String[]{nControl, nombre, apellidos, semestre, grupo, carrera});
            }
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean eliminarRegistroRAF(String numControl) {
        try {
            long pos = establecerPosicionByte(numControl);
            raf.seek(pos);

            byte[] buffer = new byte[NUMCONTROL_LEN];
            raf.readFully(buffer);
            String nControlActual = new String(buffer, "ISO-8859-1").trim();

            if (!nControlActual.equals(numControl)) {
                return false;
            }

            raf.seek(pos);
            raf.writeByte('*');
            for (int i = 1; i < NUMCONTROL_LEN; i++) {
                raf.writeByte(' ');
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean validaControl(String numControl) {
        return numControl.matches("^[0-9]{8}$");
    }

    private boolean validarCampos(String numControl, String nombre, String apellidos, int semestre, char grupo, String carrera) {
        return validaControl(numControl)
                && !nombre.isBlank()
                && !apellidos.isBlank()
                && semestre >= 1 && semestre <= 12
                && Character.isLetter(grupo)
                && !carrera.isBlank();
    }

    public void cerrarArchivo() {
        try {
            if (raf != null) raf.close();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoOrgnDir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
