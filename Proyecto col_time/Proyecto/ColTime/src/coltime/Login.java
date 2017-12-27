/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coltime;

import Atxy2k.CustomTextField.RestrictedTextField;
import Vistas.RecuperarContraseña;
import com.sun.awt.AWTUtilities;
import com.sun.glass.events.KeyEvent;
import java.awt.KeyboardFocusManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Aprendiz
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        AWTUtilities.setWindowOpaque(this, false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
        jTUser.requestFocus();
        RestrictedTextField obj = new RestrictedTextField(jTUser);
        obj.setLimit(13);
        RestrictedTextField obj1 = new RestrictedTextField(jTPassword);
        obj1.setLimit(20);
    }
    private int posX = 0;
    private int posY = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTUser = new elaprendiz.gui.textField.TextFieldRoundBackground();
        btnMin = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jTPassword = new elaprendiz.gui.passwordField.PasswordFieldRoundImage();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        clockFace1 = new elaprendiz.gui.varios.ClockFace();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnIniciar = new elaprendiz.gui.button.ButtonColoredAction();
        btnRecuperar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTUser.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTUser.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTUserKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTUserKeyTyped(evt);
            }
        });
        getContentPane().add(jTUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 260, 25));

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus1.png"))); // NOI18N
        btnMin.setBorderPainted(false);
        btnMin.setContentAreaFilled(false);
        btnMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMin.setFocusPainted(false);
        btnMin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });
        getContentPane().add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 30, -1));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setFocusPainted(false);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 30, -1));

        jTPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTPassword.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(jTPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 260, 25));

        jLabel2.setFont(new java.awt.Font("FrankRuehl", 1, 71)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(148, 177, 64));
        jLabel2.setText("Col");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 140, -1));

        jLabel3.setFont(new java.awt.Font("FrankRuehl", 0, 71)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(148, 177, 64));
        jLabel3.setText("-");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, -1, 50));

        jLabel4.setFont(new java.awt.Font("FrankRuehl", 0, 71)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(148, 177, 64));
        jLabel4.setText("TIME");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 190, -1, -1));
        getContentPane().add(clockFace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 110, 110));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmonstr-password-10-32.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmonstr-user-20-32.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, -1, 40));

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        btnRecuperar.setForeground(new java.awt.Color(120, 198, 230));
        btnRecuperar.setText("¿Olvidaste tú contraseña?");
        btnRecuperar.setBorderPainted(false);
        btnRecuperar.setContentAreaFilled(false);
        btnRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecuperar.setFocusPainted(false);
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 210, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEmpresa/logoT1.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmonstr-user-20-32.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 283, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int ex = evt.getXOnScreen();
        int ey = evt.getYOnScreen();
        this.setLocation(ex - posX, ey - posY);

    }//GEN-LAST:event_jLabel1MouseDragged

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if (!(jTUser.getText().equals("") && jTPassword.getText().equals(""))) {
            int car = iniciarSesion(jTUser.getText(), jTPassword.getText());
            if (car != 0) {
                sesion(1, jTUser.getText());
                screen sc = new screen();
                sc.setVisible(true);
                sc.setLocationRelativeTo(null);
                sc.jDocumento.setText(jTUser.getText());
                sc.jDocumento.setVisible(false);
                sc.jLCargo.setText(String.valueOf(car));
                this.dispose();
            } else {
                new rojerusan.RSNotifyAnimated("¡Error!", "El usuario o la contraseña es incorrecto, por favor intentelo nuevamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        } else {
            new rojerusan.RSNotifyAnimated("Alerta!!", "debes llenar los dos campos que son obligatorios.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            jTUser.requestFocus();
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        RecuperarContraseña obj = new RecuperarContraseña(this, true);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void jTUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUserKeyTyped
        char cara = evt.getKeyChar();
        if (Character.isLetter(cara) || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '_' || evt.getKeyChar() == ',' || evt.getKeyChar() == '@' || evt.getKeyChar() == '|') {
            evt.consume();
        }
    }//GEN-LAST:event_jTUserKeyTyped

    private void jTUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciar.doClick();
        }
        jTUser.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            jTPassword.requestFocus();
        }
    }//GEN-LAST:event_jTUserKeyPressed

    private void jTPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnIniciar.doClick();
        }
        jTPassword.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            jTUser.requestFocus();
        }
    }//GEN-LAST:event_jTPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private elaprendiz.gui.button.ButtonColoredAction btnIniciar;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnRecuperar;
    private elaprendiz.gui.varios.ClockFace clockFace1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private elaprendiz.gui.passwordField.PasswordFieldRoundImage jTPassword;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTUser;
    // End of variables declaration//GEN-END:variables

//Metodos----------------------------------------------------------------------->
    public int iniciarSesion(String user, String pasw) {
        Controlador.Usuario obj = new Controlador.Usuario();
        return obj.iniciarSesion(user, pasw);
    }

    public void sesion(int sec, String doc) {
        Controlador.Usuario obj = new Controlador.Usuario();
        obj.sesion(sec, doc);
    }
}

//Notificaciones 
//       new rojerusan.RSNotifyFade("¡ERROR!", "Este es un mensaje de errordel sistema.", 7, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.ERROR).setVisible(true);
//       new rojerusan.RSNotifyAnimated("Bien Hecho", "Ádios lokita", 7, RSNotifyAnimated.PositionNotify.BottomLeft, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
//       new rojerusan.RSNotifyShadowAnimated("Error", "What so you doing?", 7, RSNotifyShadowAnimated.PositionNotify.TopLef, RSNotifyShadowAnimated.AnimationNotify.UpBottom, RSNotifyShadowAnimated.TypeNotify.ERROR).setVisible(true);
//       new rojerusan.RSNotifyShadowFade("Error", "Holamundo", 7, RSNotifyShadowFade.PositionNotify.TopRight, RSNotifyShadowFade.TypeNotify.ERROR).setVisible(true);
