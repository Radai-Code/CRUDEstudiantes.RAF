package vista;

import controlador.ControladorCRUDEstudiantes;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class FrmModificarEstudiante extends javax.swing.JFrame {
   ControladorCRUDEstudiantes objControladorCRUDEst; 
   private ButtonGroup grupoRadio;
    public FrmModificarEstudiante(ControladorCRUDEstudiantes objCtrlCRUDEst) {
        initComponents();
        this.objControladorCRUDEst= objCtrlCRUDEst; 
        this.des_habilitaComponentes(false);
        grupoRadio = new ButtonGroup();
        grupoRadio.add(rdbtnGrupoA);
        grupoRadio.add(rdbtnGrupoB);
        grupoRadio.add(rdbtnGrupoC);
    }
     private void des_habilitaComponentes(boolean valor){
        this.txtNombre.setEnabled(valor);
        this.txtApellidos.setEnabled(valor);
        this.cboSemestre.setEnabled(valor);
        this.rdbtnGrupoA.setEnabled(valor);
        this.rdbtnGrupoB.setEnabled(valor);
        this.rdbtnGrupoC.setEnabled(valor);
        this.cboCarrera.setEnabled(valor);
        this.btnActualizar.setEnabled(valor);
    }
    private void limpiarCampos() {
        txtNumControl.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        cboSemestre.setSelectedIndex(0);
        cboCarrera.setSelectedIndex(0);
        grupoRadio.clearSelection(); // Desselecciona todos
        rdbtnGrupoA.setSelected(true); // Seleccionar grupo A por defecto
        des_habilitaComponentes(false); // Deshabilitar campos después de limpiar
        btnActualizar.setEnabled(false);
        txtNumControl.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        rdbtnGrupoB = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboSemestre = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        rdbtnGrupoA = new javax.swing.JRadioButton();
        rdbtnGrupoC = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumControl = new javax.swing.JTextField();
        cboCarrera = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();

        jLabel8.setText("Carrera");

        rdbtnGrupoB.setText("B");
        rdbtnGrupoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbtnGrupoBKeyPressed(evt);
            }
        });

        jLabel4.setText("Nombre");

        jLabel6.setText("Semestre");

        cboSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        cboSemestre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboSemestreKeyPressed(evt);
            }
        });

        jLabel1.setText("Num Control");

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar48px.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        btnActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnActualizarKeyPressed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar232px.png"))); // NOI18N
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        rdbtnGrupoA.setSelected(true);
        rdbtnGrupoA.setText("A");
        rdbtnGrupoA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbtnGrupoAKeyPressed(evt);
            }
        });

        rdbtnGrupoC.setText("C");
        rdbtnGrupoC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdbtnGrupoCKeyPressed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        jLabel5.setText("Apellidos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tecnológico del Valle de Oaxaca");

        txtNumControl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumControlKeyPressed(evt);
            }
        });

        cboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ing. Informática", "Ing. en TIC", "Ing. en Ciencia de Datos", "Ing. en Gestión Empresarial", "Ing. Forestal", "Ing. en Agronomía", "Lic. en Biología" }));
        cboCarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboCarreraKeyPressed(evt);
            }
        });

        jLabel7.setText("Grupo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Modificar Estudiante");

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbtnGrupoA)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbtnGrupoB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbtnGrupoC))
                                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnActualizar)
                .addGap(25, 127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnBuscar)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbtnGrupoA)
                        .addComponent(rdbtnGrupoB)
                        .addComponent(rdbtnGrupoC))
                    .addComponent(jLabel7))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbtnGrupoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbtnGrupoBKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.cboCarrera.requestFocus();
    }//GEN-LAST:event_rdbtnGrupoBKeyPressed

    private void cboSemestreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboSemestreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.rdbtnGrupoA.requestFocus();
    }//GEN-LAST:event_cboSemestreKeyPressed

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        String numControl = txtNumControl.getText();
    String nuevoNombre = txtNombre.getText();
    String nuevoApellido = txtApellidos.getText();
    String nuevoSemestre = cboSemestre.getSelectedItem().toString();
    String nuevoGrupo = "";
    if (rdbtnGrupoA.isSelected()) {
        nuevoGrupo = "A";
    } else if (rdbtnGrupoB.isSelected()) {
        nuevoGrupo = "B";
    } else if (rdbtnGrupoC.isSelected()) {
        nuevoGrupo = "C";
    }
    String nuevaCarrera = cboCarrera.getSelectedItem().toString();
    // Llamar al controlador para editar el registro
    objControladorCRUDEst.editarRegistro(numControl, nuevoNombre, nuevoApellido, nuevoSemestre, nuevoGrupo, nuevaCarrera);
    objControladorCRUDEst.llenarTabla();
    limpiarCampos();
    
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnActualizarKeyPressed
    String numControl = txtNumControl.getText();
    String nuevoNombre = txtNombre.getText();
    String nuevoApellido = txtApellidos.getText();
    String nuevoSemestre = cboSemestre.getSelectedItem().toString();
    String nuevoGrupo = "";
    if (rdbtnGrupoA.isSelected()) {
        nuevoGrupo = "A";
    } else if (rdbtnGrupoB.isSelected()) {
        nuevoGrupo = "B";
    } else if (rdbtnGrupoC.isSelected()) {
        nuevoGrupo = "C";
    }
    String nuevaCarrera = cboCarrera.getSelectedItem().toString();
    
    // Llamar al controlador para editar el registro
    objControladorCRUDEst.editarRegistro(numControl, nuevoNombre, nuevoApellido, nuevoSemestre, nuevoGrupo, nuevaCarrera);
     objControladorCRUDEst.llenarTabla();
    limpiarCampos();  
    
    }//GEN-LAST:event_btnActualizarKeyPressed

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here: 
        this.buscar();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:  
        this.buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
          this.buscar();
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void rdbtnGrupoAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbtnGrupoAKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.cboCarrera.requestFocus();
    }//GEN-LAST:event_rdbtnGrupoAKeyPressed

    private void rdbtnGrupoCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdbtnGrupoCKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.cboCarrera.requestFocus();
    }//GEN-LAST:event_rdbtnGrupoCKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.txtApellidos.requestFocus();
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNumControlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumControlKeyPressed
   if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.buscar();
        }    
    }//GEN-LAST:event_txtNumControlKeyPressed

    private void cboCarreraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboCarreraKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.btnActualizar.requestFocus();
    }//GEN-LAST:event_cboCarreraKeyPressed

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        this.cboSemestre.requestFocus();
    }//GEN-LAST:event_txtApellidosKeyPressed
   
  private void buscar() {
    String numControl = this.txtNumControl.getText();
    String[] registro = this.objControladorCRUDEst.buscarRegistro(numControl);

    if (registro != null && registro.length >= 6) {
        System.out.println("Registro: " + String.join(" | ", registro));

        this.txtNombre.setText(registro[1]);
        this.txtApellidos.setText(registro[2]);

        // Validar y asignar semestre
        String semestreStr = registro[3].trim();
        if (!semestreStr.isEmpty()) {
            this.cboSemestre.setSelectedItem(semestreStr); // Asegúrate que los valores del ComboBox sean tipo String: "1", "2", "3", etc.
        } else {
            System.err.println("⚠ Semestre vacío para el registro: " + numControl);
        }

        // Limpiar y asignar grupo
        this.rdbtnGrupoA.setSelected(false);
        this.rdbtnGrupoB.setSelected(false);
        this.rdbtnGrupoC.setSelected(false);

        String grupo = registro[4].trim();
        switch (grupo) {
            case "A":
                this.rdbtnGrupoA.setSelected(true);
                break;
            case "B":
                this.rdbtnGrupoB.setSelected(true);
                break;
            case "C":
                this.rdbtnGrupoC.setSelected(true);
                break;
            default:
                System.err.println("⚠ Grupo no reconocido: " + grupo);
        }

        // Carrera
        String carrera = registro[5].trim();
        if (!carrera.isEmpty()) {
            this.cboCarrera.setSelectedItem(carrera);
        } else {
            System.err.println("⚠ Carrera vacía para el registro: " + numControl);
        }

        this.btnActualizar.setEnabled(true);
        this.txtNumControl.setEnabled(false);
        this.des_habilitaComponentes(true);
    } else {
        JOptionPane.showMessageDialog(this, "El registro no existe o está incompleto");
        limpiarCampos();
    }
}


   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cboCarrera;
    private javax.swing.JComboBox<String> cboSemestre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton rdbtnGrupoA;
    private javax.swing.JRadioButton rdbtnGrupoB;
    private javax.swing.JRadioButton rdbtnGrupoC;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumControl;
    // End of variables declaration//GEN-END:variables
}
