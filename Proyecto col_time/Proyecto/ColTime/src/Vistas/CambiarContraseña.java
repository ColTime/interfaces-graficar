/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Atxy2k.CustomTextField.RestrictedTextField;
import Controlador.Usuario;
import coltime.Menu;
import java.awt.Color;
import javax.swing.ImageIcon;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Admin
 */
public class CambiarContraseña extends javax.swing.JFrame {

    /**
     * Creates new form CambiarContraseña
     */
    public CambiarContraseña() {
        initComponents();
        this.setLocationRelativeTo(null);
        RestrictedTextField obj = new RestrictedTextField(jTpaswward1);
        obj.setLimit(20);
        RestrictedTextField obj1 = new RestrictedTextField(jTpaswward2);
        obj1.setLimit(20);
        RestrictedTextField obj2 = new RestrictedTextField(jTpaswward3);
        obj2.setLimit(20);
        jTpaswward2.setEnabled(false);
        jTpaswward3.setEnabled(false);
        Notificacion1.setText("");
        Notificacion2.setText("");
        btnGuardar.setEnabled(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
    }

    private int posX = 0;
    private int posy = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTdocumento = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnGuardar = new elaprendiz.gui.button.ButtonColoredAction();
        btnClose = new javax.swing.JButton();
        Notificacion2 = new javax.swing.JLabel();
        Notificacion1 = new javax.swing.JLabel();
        jTpaswward1 = new elaprendiz.gui.passwordField.PasswordFieldRoundImage();
        jTpaswward2 = new elaprendiz.gui.passwordField.PasswordFieldRoundImage();
        jTpaswward3 = new elaprendiz.gui.passwordField.PasswordFieldRoundImage();

        jTdocumento.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTdocumento.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTdocumento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTdocumentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTdocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTdocumentoKeyTyped(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(63, 179, 255), 1, true));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText("Contraseña antigua:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nueva contraseña:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Repetir nueva contraseñna:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("*");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setFocusPainted(false);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        Notificacion2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Notificacion2.setForeground(new java.awt.Color(128, 128, 131));
        Notificacion2.setText("Estado");

        Notificacion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Notificacion1.setForeground(new java.awt.Color(128, 128, 131));
        Notificacion1.setText("Estado");

        jTpaswward1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTpaswward1.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTpaswward1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTpaswward1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTpaswward1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTpaswward1KeyReleased(evt);
            }
        });

        jTpaswward2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTpaswward2.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTpaswward2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTpaswward2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTpaswward2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTpaswward2KeyReleased(evt);
            }
        });

        jTpaswward3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTpaswward3.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTpaswward3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTpaswward3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTpaswward3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTpaswward3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5))
                            .addComponent(jTpaswward1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTpaswward2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTpaswward3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Notificacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Notificacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTpaswward1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(Notificacion2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Notificacion1)
                            .addComponent(jTpaswward2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTpaswward3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTdocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoKeyPressed

    }//GEN-LAST:event_jTdocumentoKeyPressed

    private void jTdocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoKeyReleased

    }//GEN-LAST:event_jTdocumentoKeyReleased

    private void jTdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTdocumentoKeyTyped

    }//GEN-LAST:event_jTdocumentoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Controlador.Usuario obj = new Usuario();
        obj.setDocumento(Menu.jDocumento.getText());
        obj.setContraseña(jTpaswward2.getText());
        if (obj.CambiarContraseña(jTpaswward1.getText())) {
            new rojerusan.RSNotifyAnimated("Listo!!", "La contraseña fue cambiada correctamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            this.dispose();
        } else {
            new rojerusan.RSNotifyAnimated("Alerta!!", "La contraseña antigua es incorrecta, por favor intentalo nuevamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        posX = evt.getX();
        posy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation((evt.getXOnScreen() - posX), (evt.getYOnScreen() - posy));
    }//GEN-LAST:event_formMouseDragged

    private void jTpaswward1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpaswward1KeyPressed

    }//GEN-LAST:event_jTpaswward1KeyPressed

    private void jTpaswward2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpaswward2KeyPressed

    }//GEN-LAST:event_jTpaswward2KeyPressed

    private void jTpaswward3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpaswward3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTpaswward3KeyPressed

    private void jTpaswward2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpaswward2KeyReleased
        if (jTpaswward2.getText().length() > 7) {
            if (jTpaswward2.getText().length() >= 8 && jTpaswward2.getText().length() <= 10) {
                Notificacion1.setText("Bajo");
                Notificacion1.setForeground(Color.RED);
                jTpaswward3.setEnabled(true);
            } else if (jTpaswward2.getText().length() >= 11 && jTpaswward2.getText().length() <= 15) {
                Notificacion1.setText("Medio");
                Notificacion1.setForeground(Color.ORANGE);
                jTpaswward3.setEnabled(true);
            } else if (jTpaswward2.getText().length() >= 16 && jTpaswward2.getText().length() <= 20) {
                Notificacion1.setText("Alto");
                Notificacion1.setForeground(Color.GREEN);
                jTpaswward3.setEnabled(true);
            }
        } else {
            btnGuardar.setEnabled(false);
            Notificacion1.setText("");
            jTpaswward3.setEnabled(false);
        }
    }//GEN-LAST:event_jTpaswward2KeyReleased

    private void jTpaswward3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpaswward3KeyReleased
        if (!jTpaswward3.getText().equals("")) {
            if (jTpaswward2.getText().equals(jTpaswward3.getText())) {
                btnGuardar.setEnabled(true);
                Notificacion2.setText("Las contraseñans coinsiden");
                Notificacion2.setForeground(Color.GREEN);
            } else {
                btnGuardar.setEnabled(false);
                Notificacion2.setText("Las contraseñans  no coinsiden");
                Notificacion2.setForeground(Color.RED);
            }
        } else {
            Notificacion2.setText("");
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTpaswward3KeyReleased

    private void jTpaswward1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTpaswward1KeyReleased
        if (!jTpaswward1.getText().equals("")) {
            btnGuardar.setEnabled(true);
            if (jTpaswward1.getText().length() >= 8) {
                jTpaswward2.setEnabled(true);
            } else {
                jTpaswward2.setEnabled(false);
            }
        } else {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTpaswward1KeyReleased

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
            java.util.logging.Logger.getLogger(CambiarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambiarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambiarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambiarContraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Notificacion1;
    private javax.swing.JLabel Notificacion2;
    public javax.swing.JButton btnClose;
    private elaprendiz.gui.button.ButtonColoredAction btnGuardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTdocumento;
    private elaprendiz.gui.passwordField.PasswordFieldRoundImage jTpaswward1;
    private elaprendiz.gui.passwordField.PasswordFieldRoundImage jTpaswward2;
    private elaprendiz.gui.passwordField.PasswordFieldRoundImage jTpaswward3;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
