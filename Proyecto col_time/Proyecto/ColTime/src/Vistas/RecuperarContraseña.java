package Vistas;

import Atxy2k.CustomTextField.RestrictedTextField;
import Controlador.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

public class RecuperarContraseña extends javax.swing.JDialog {

    public RecuperarContraseña(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Recuperación de contraseña");
        RestrictedTextField obj = new RestrictedTextField(jTRecuperacion);
        obj.setLimit(10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTRecuperacion = new elaprendiz.gui.textField.TextFieldRoundBackground();
        btnIniciar = new elaprendiz.gui.button.ButtonColoredAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(148, 177, 64));
        jLabel1.setText("Para recuperar la contraseña debe ingresas el código de recuperación que");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(148, 177, 64));
        jLabel2.setText("se generó al ser ingresado en el sistema de información por el administrador.");

        jTRecuperacion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTRecuperacion.setColorDeBorde(new java.awt.Color(172, 172, 172));
        jTRecuperacion.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTRecuperacion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTRecuperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTRecuperacionActionPerformed(evt);
            }
        });
        jTRecuperacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTRecuperacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTRecuperacionKeyTyped(evt);
            }
        });

        btnIniciar.setText("Recuperar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTRecuperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTRecuperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTRecuperacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRecuperacionKeyPressed

    }//GEN-LAST:event_jTRecuperacionKeyPressed

    private void jTRecuperacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRecuperacionKeyTyped

    }//GEN-LAST:event_jTRecuperacionKeyTyped

    private void jTRecuperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTRecuperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTRecuperacionActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Usuario obj = new Usuario();
        //El codigo de recuperación obligarotiamente tiene que ser de 10 caractres.
        if (jTRecuperacion.getText().length() == 10) {
            try {
                //Se consulta si el código de recuperación es valido o no lo es para poder brindar la información correspondiente al usuario. 
                CachedRowSet crs = obj.recuperacionContraseña(jTRecuperacion.getText());
                if (crs.next()) {
                    //Se encontro el código y retornara la información correspondiente a la cuenta de usuario y contraseña.
                    new rojerusan.RSNotifyAnimated("Listo!", "Proceso terminado.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    this.dispose();
                    //Datos...
                    int op = JOptionPane.showOptionDialog(null, "Su usuario y contraseña son: \n \n" + "Usuario: " + crs.getString(1) + "\n" + "Contraseña: " + crs.getString(2) + "\n \n" + "¿Guardar datos?",
                            "Código de recuperación", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                            new Object[]{"SI", "NO"}, "SI");
                    //Más código...
                    if (op == 0) {
                        //Se generar un archivo plano donde se guardara la información.
                        JFileChooser Chocer = new JFileChooser();
                        Chocer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        Chocer.setLocation(500, 500);
                        Chocer.showOpenDialog(this);
                        File ruta = Chocer.getSelectedFile();

                        String archi = String.valueOf(ruta);
                        File archivo = new File(archi + "\\Datos.txt");

                        if (archivo.exists()) {
                            archivo.delete();
                            generarArchivoPlano(archivo, crs);
                        } else {
                            generarArchivoPlano(archivo, crs);
                        }
                    }
                } else {
                    //El código ingresado no es valido... intento otra vez.
                    new rojerusan.RSNotifyAnimated("Error!!", "El código ingresado no es válido. Ingrese un código de recuperación válido o contacte al administrador del sistema.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            } catch (Exception e) {
                //Mensaje de erro en la recuperación de contraseña.
                JOptionPane.showMessageDialog(null, "Error! " + e);
            }
        } else {
            //Mensaje del código de recuperación no cumple con la longitud establecida para el ingreso del código de recuperación.
            new rojerusan.RSNotifyAnimated("Alerta!!", "El Código debe contener 10 digitos", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed
    public boolean generarArchivoPlano(File ruta, CachedRowSet crs) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
            bw.write("Datos de la cuenta de usuario:");
            bw.newLine();
            bw.newLine();
            bw.write("Usuario: " + crs.getString(1));
            bw.newLine();
            bw.write("Contraseña: " + crs.getString(2));
            bw.close();
        } catch (Exception e) {
            //Mensaje de erro al crear el archivo plano
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecuperarContraseña dialog = new RecuperarContraseña(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private elaprendiz.gui.button.ButtonColoredAction btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTRecuperacion;
    // End of variables declaration//GEN-END:variables
}
