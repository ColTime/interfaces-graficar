package Vistas;

import Controlador.Proyecto;
import com.itextpdf.text.Image;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sql.rowset.CachedRowSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import paneles.CambiaPanel;

public class Producciones extends javax.swing.JFrame implements ActionListener {

    public Producciones() {
        initComponents();
        this.setLocationRelativeTo(null);
//        new CambiaPanel(Contenido, new ProduccionFE());
//        generarLabel("28400");
    }
    int posX = 0;
    int posY = 0;
    int panel = 0;
    CachedRowSet crs = null;
    int x = 0, y = 0, cantidad = 0, filas = 1, unidad = 11, conta = 5;
    static int negocio = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        rSButtonMetro1 = new rsbuttom.RSButtonMetro();
        rSButtonMetro2 = new rsbuttom.RSButtonMetro();
        rSButtonMetro3 = new rsbuttom.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        textFieldRoundBackground2 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        textFieldRoundBackground3 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        textFieldRoundBackground4 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxRound1 = new elaprendiz.gui.comboBox.ComboBoxRound();
        Contenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(63, 179, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusPainted(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus1.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusPainted(false);
        jButton10.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        rSButtonMetro1.setBackground(new java.awt.Color(63, 179, 255));
        rSButtonMetro1.setText("Formato estandar");
        rSButtonMetro1.setBorderPainted(false);
        rSButtonMetro1.setColorNormal(new java.awt.Color(63, 179, 255));
        rSButtonMetro1.setFocusPainted(false);
        rSButtonMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro1ActionPerformed(evt);
            }
        });

        rSButtonMetro2.setBackground(new java.awt.Color(63, 179, 255));
        rSButtonMetro2.setText("Teclados");
        rSButtonMetro2.setBorderPainted(false);
        rSButtonMetro2.setColorNormal(new java.awt.Color(63, 179, 255));
        rSButtonMetro2.setFocusPainted(false);
        rSButtonMetro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro2ActionPerformed(evt);
            }
        });

        rSButtonMetro3.setBackground(new java.awt.Color(63, 179, 255));
        rSButtonMetro3.setText("Ensamble");
        rSButtonMetro3.setBorderPainted(false);
        rSButtonMetro3.setColorNormal(new java.awt.Color(63, 179, 255));
        rSButtonMetro3.setFocusPainted(false);
        rSButtonMetro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonMetro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButtonMetro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSButtonMetro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSButtonMetro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSButtonMetro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton10)
                    .addComponent(jButton9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204)), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        textFieldRoundBackground2.setColorDeBorde(new java.awt.Color(204, 204, 204));
        textFieldRoundBackground2.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");

        textFieldRoundBackground3.setColorDeBorde(new java.awt.Color(204, 204, 204));
        textFieldRoundBackground3.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");

        textFieldRoundBackground4.setColorDeBorde(new java.awt.Color(204, 204, 204));
        textFieldRoundBackground4.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setText("Tipo de proyecto:");

        comboBoxRound1.setForeground(new java.awt.Color(102, 102, 102));
        comboBoxRound1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Normal", "RQT", "Quick" }));
        comboBoxRound1.setColorDeBorde(new java.awt.Color(204, 204, 204));
        comboBoxRound1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldRoundBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldRoundBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(textFieldRoundBackground4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldRoundBackground4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldRoundBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldRoundBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setName("contenido"); // NOI18N
        Contenido.setLayout(new javax.swing.BoxLayout(Contenido, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1124, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        Contenido.add(jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void rSButtonMetro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro2ActionPerformed
        new CambiaPanel(Contenido, new ProduccionTE());
        reinicializarVariables();
        negocio = 2;
        agregarProyectoEnTabla(2);
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        new CambiaPanel(Contenido, new ProduccionFE());
        reinicializarVariables();
        negocio = 1;
        agregarProyectoEnTabla(1);
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        new CambiaPanel(Contenido, new ProduccionEN());
        reinicializarVariables();
        negocio = 3;
        agregarProyectoEnTabla(3);
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

//Metodos
    public void agregarProyectoEnTabla(int negocio) {
        try {
            //Se realiza la consulta para traer en numero de orden de todos los proyectos registrados
            Proyecto obj = new Proyecto();
            crs = obj.proyectosNegocio(negocio);
            while (crs.next()) {
                JButton jp = new JButton(String.valueOf(crs.getInt(1)));
                jp.setBounds(0 + x, 0 + y, 98, 98);
                jp.addActionListener(this);
                jp.setFont(new Font("Tahoma", 1, 15));
                jp.setFocusPainted(false);
                //Icono del boton
                ImageIcon icon = new ImageIcon("src\\img\\proyect.png");
                Icon image = new ImageIcon(icon.getImage().getScaledInstance(jp.getWidth(), jp.getHeight(), Image.SECTION));
                jp.setIcon(image);
                this.repaint();
                //Texto del boton
                jp.setText(String.valueOf(crs.getInt(1)));
                jp.setHorizontalTextPosition(JButton.CENTER);
                jp.setContentAreaFilled(false);
                jp.setForeground(Color.BLACK);
                jp.setActionCommand(String.valueOf(crs.getInt(1)));
                jp.setCursor(Cursor.getPredefinedCursor(12));
                x += 99;
                cantidad++;
                if (cantidad == unidad * filas) {
                    y += 100;
                    x = 0;
                    filas++;
                    if (cantidad == unidad * conta) {
                        switch (negocio) {
                            case 1:
                                ProduccionFE.contenidoFE.setPreferredSize(new Dimension(1128, ProduccionFE.contenidoFE.getHeight() + 496));
                                break;
                            case 2:
                                ProduccionTE.contenidoTE.setPreferredSize(new Dimension(1128, ProduccionTE.contenidoTE.getHeight() + 496));
                                break;
                            case 3:
                                ProduccionEN.contenidoEN.setPreferredSize(new Dimension(1128, ProduccionEN.contenidoEN.getHeight() + 496));
                                break;
                        }
                        conta += 5;
                    }
                    this.Contenido.updateUI();
                }
                jp.setBackground(Color.WHITE);
                switch (negocio) {
                    case 1:
                        ProduccionFE.contenidoFE.add(jp);
                        ProduccionFE.contenidoFE.updateUI();
                        break;
                    case 2:
                        ProduccionTE.contenidoTE.add(jp);
                        ProduccionTE.contenidoTE.updateUI();
                        break;
                    case 3:
                        ProduccionEN.contenidoEN.add(jp);
                        ProduccionEN.contenidoEN.updateUI();
                        break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!!! " + e);
        }
    }

    private void reinicializarVariables() {
        x = 0;
        y = 0;
        cantidad = 0;
        filas = 1;
        unidad = 11;
        conta = 5;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int orden = Integer.parseInt(e.getActionCommand());
        detalleProduccion obj = new detalleProduccion(this, true, orden, negocio);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        obj.dispose();
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
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Producciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Producciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private elaprendiz.gui.comboBox.ComboBoxRound comboBoxRound1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rsbuttom.RSButtonMetro rSButtonMetro1;
    private rsbuttom.RSButtonMetro rSButtonMetro2;
    private rsbuttom.RSButtonMetro rSButtonMetro3;
    private elaprendiz.gui.textField.TextFieldRoundBackground textFieldRoundBackground2;
    private elaprendiz.gui.textField.TextFieldRoundBackground textFieldRoundBackground3;
    private elaprendiz.gui.textField.TextFieldRoundBackground textFieldRoundBackground4;
    // End of variables declaration//GEN-END:variables

}
