package controlador;
import java.awt.Color;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArchivoOrgnDir;
import vista.VistaCRUDEstudiantes;

public class ControladorCRUDEstudiantes {
    
    public VistaCRUDEstudiantes objVistaCRUDEst;
    ArchivoOrgnDir objArchivo;
    DefaultTableModel modelo;
    public ControladorCRUDEstudiantes(VistaCRUDEstudiantes aThis, ArchivoOrgnDir objArchivo) {
        this.objVistaCRUDEst=aThis;
        this.objArchivo=objArchivo;
        this.modelo=null;
    }
    
    
    public void llenarTabla() {
    String[] columnas = {"Num.Control", "Nombre", "Apellidos", "Semestre", "Grupo", "Carrera"};
    this.objArchivo.abrirArchivoRAF("estudiantes.dat");
    
    // Supongamos que este método devuelve una lista de arreglos de Strings
    java.util.List<String[]> registros = this.objArchivo.obtenerRegistrosRAF();
    
    String[][] filas = new String[registros.size()][6];
    for (int i = 0; i < registros.size(); i++) {
        filas[i] = registros.get(i);
    }

    this.objArchivo.cerrarArchivo();

    modelo = new DefaultTableModel(filas, columnas);
    this.objVistaCRUDEst.jtblEstudiantes.setModel(modelo);
}

    
    public void guardarRegistro(String nc, String nom, String ape, int sem, char gpo, String carrera){
        //String linea= nc + "," + nom + ","+ ape + ","+ sem + ","+ gpo + ","+ carrera;
        this.objArchivo = new ArchivoOrgnDir();
        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        //this.objArchivo.crearLinea(linea);
        this.objArchivo.escribirRegistro(nc, nom, ape, sem, gpo, carrera);
        this.objArchivo.cerrarArchivo();
        this.llenarTabla();
    }
    
public String[] buscarRegistro(String numControl) {
    try (RandomAccessFile raf = new RandomAccessFile("Estudiantes.dat", "r")) {
        final int tamReg = 81;
        long totalRegs = raf.length() / tamReg;

        //System.out.println("Total registros: " + totalRegs);

        for (int i = 0; i < totalRegs; i++) {
            raf.seek(i * tamReg);
            String nc = leerCampo(raf, 8);
            String nombre = leerCampo(raf, 20);
            String apellido = leerCampo(raf, 20);
            String semestre = leerCampo(raf, 2).trim();
            String grupo = leerCampo(raf, 1).trim();
            String carrera = leerCampo(raf, 30).trim();

            // Aquí imprimes lo que leíste del registro i
            //System.out.printf("Registro %d: %s, %s, %s, %s, %s, %s\n",
                              //i, nc, nombre, apellido, semestre, grupo, carrera);

            if (nc.trim().equals(numControl.trim())) {
                return new String[] { nc.trim(), nombre, apellido, semestre, grupo, carrera };
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}

  
    public void eliminarRegistro(String numControl) {
    this.objArchivo.abrirArchivoRAF("estudiantes.dat");

    boolean eliminado = this.objArchivo.eliminarRegistroRAF(numControl);

    this.objArchivo.cerrarArchivo();

    if (eliminado) {
        JOptionPane.showMessageDialog(objVistaCRUDEst, "Registro eliminado correctamente.");
    } else {
        JOptionPane.showMessageDialog(objVistaCRUDEst, "No se encontró el registro.");
    }

    llenarTabla();  
}
public boolean editarRegistro(String numControl, String nuevoNombre, String nuevoApellido, String nuevoSemestre, String nuevoGrupo, String nuevaCarrera) {
    final int NUMCONTROL_LEN = 8;
    final int NOMBRE_LEN = 20;
    final int APELLIDOS_LEN = 20;
    final int SEMESTRE_LEN = 2;
    final int GRUPO_LEN = 1;
    final int CARRERA_LEN = 30;
    final int TAMREG = NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN + CARRERA_LEN;

    try (RandomAccessFile raf = new RandomAccessFile("Estudiantes.dat", "rw")) {
        long totalRegs = raf.length() / TAMREG;

        for (int i = 0; i < totalRegs; i++) {
            raf.seek(i * TAMREG);
            String nc = leerCampo(raf, NUMCONTROL_LEN).trim();

            if (nc.equals(numControl.trim())) {
                // Volver a la posición del inicio del nombre
                raf.seek(i * TAMREG + NUMCONTROL_LEN);

                escribirCampo(raf, nuevoNombre, NOMBRE_LEN);
                escribirCampo(raf, nuevoApellido, APELLIDOS_LEN);
                escribirCampo(raf, nuevoSemestre, SEMESTRE_LEN);
                escribirCampo(raf, nuevoGrupo, GRUPO_LEN);
                escribirCampo(raf, nuevaCarrera, CARRERA_LEN);

                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}
    public boolean validaNumControl(String numControl) {
        this.objArchivo = new ArchivoOrgnDir();
        return this.objArchivo.validaControl(numControl);
    }  
 
// Leer un campo de longitud fija
private String leerCampo(RandomAccessFile raf, int longitud) throws IOException {
    byte[] buffer = new byte[longitud];
    raf.readFully(buffer);
    return new String(buffer, "ISO-8859-1").trim();
}


private void escribirCampo(RandomAccessFile raf, String dato, int longitud) throws IOException {
    byte[] buffer = new byte[longitud];
    byte[] datos = dato.getBytes("ISO-8859-1");
    System.arraycopy(datos, 0, buffer, 0, Math.min(datos.length, longitud));
    raf.write(buffer);
}





}


