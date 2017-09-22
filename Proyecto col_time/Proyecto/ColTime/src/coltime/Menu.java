package coltime;

import Vistas.Producciones;
import Vistas.Inicio;
import Vistas.Usuarios1;
import Vistas.proyecto;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import paneles.CambiaPanel;
import rojerusan.RSNotifyAnimated;

public class Menu extends javax.swing.JFrame {

    private Color cor = new Color(189, 189, 189);
    private Color corF = new Color(219, 219, 219);
    Producciones bp = null;

    public Menu() {
        initComponents();
        if (!jPContenido.getComponent(0).getName().equals("Usuario")) {
            new CambiaPanel(jPContenido, new Usuarios1());
        }
        Animacion.Animacion.mover_derecha(935, 1135, 0, 2, jPanel3);
        new CambiaPanel(jPContenido, new Inicio());
        btn1.setColorHover(cor);
        btn1.setColorNormal(cor);
        btn1.setColorPressed(cor);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
        this.setLocationRelativeTo(null);
        new rojerusan.RSNotifyAnimated("Bienvenido", "Tienes 5 nuevas notificaciones", 6, RSNotifyAnimated.PositionNotify.BottomLeft, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
    }
    private int posX = 0;
    private int posY = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPSuperior = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rSFotoCircle2 = new rojerusan.RSFotoCircle();
        btn2 = new rsbuttom.RSButtonMetro();
        btn1 = new rsbuttom.RSButtonMetro();
        btn4 = new rsbuttom.RSButtonMetro();
        btn3 = new rsbuttom.RSButtonMetro();
        jPContenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMinimumSize(new java.awt.Dimension(1140, 700));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPSuperior.setBackground(new java.awt.Color(63, 179, 255));
        jPSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPSuperiorMouseDragged(evt);
            }
        });
        jPSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPSuperiorMousePressed(evt);
            }
        });

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setFocusPainted(false);
        btnMenu.setRequestFocusEnabled(false);
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus1.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minus.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPSuperiorLayout = new javax.swing.GroupLayout(jPSuperior);
        jPSuperior.setLayout(jPSuperiorLayout);
        jPSuperiorLayout.setHorizontalGroup(
            jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSuperiorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        jPSuperiorLayout.setVerticalGroup(
            jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSuperiorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPMenu.setBackground(new java.awt.Color(219, 219, 219));
        jPMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(219, 219, 219));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSFotoCircle2.setColorBordePopu(new java.awt.Color(204, 204, 204));
        rSFotoCircle2.setColorButtonOptions(new java.awt.Color(128, 128, 131));
        jPanel4.add(rSFotoCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 110, 100));

        jPMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 110));

        btn2.setForeground(new java.awt.Color(128, 128, 131));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/market.png"))); // NOI18N
        btn2.setText("PROYECTOS");
        btn2.setBorderPainted(false);
        btn2.setColorHover(new java.awt.Color(189, 189, 189));
        btn2.setColorNormal(new java.awt.Color(219, 219, 219));
        btn2.setColorPressed(new java.awt.Color(189, 189, 189));
        btn2.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn2.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn2.setFocusable(false);
        btn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPMenu.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 152, 190, 42));

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N
        btn1.setText(" INICIO");
        btn1.setAutoscrolls(true);
        btn1.setBorderPainted(false);
        btn1.setColorHover(new java.awt.Color(189, 189, 189));
        btn1.setColorNormal(new java.awt.Color(219, 219, 219));
        btn1.setColorPressed(new java.awt.Color(189, 189, 189));
        btn1.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn1.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn1.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn1.setDefaultCapable(false);
        btn1.setFocusable(false);
        btn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPMenu.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, 42));

        btn4.setForeground(new java.awt.Color(128, 128, 131));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/collection.png"))); // NOI18N
        btn4.setText("PRODUCCIÓN");
        btn4.setBorderPainted(false);
        btn4.setColorHover(new java.awt.Color(189, 189, 189));
        btn4.setColorNormal(new java.awt.Color(219, 219, 219));
        btn4.setColorPressed(new java.awt.Color(189, 189, 189));
        btn4.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn4.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn4.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn4.setFocusable(false);
        btn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPMenu.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 236, 190, 42));

        btn3.setForeground(new java.awt.Color(128, 128, 131));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconmonstr-user-8-32.png"))); // NOI18N
        btn3.setText("USUARIOS");
        btn3.setBorderPainted(false);
        btn3.setColorHover(new java.awt.Color(189, 189, 189));
        btn3.setColorNormal(new java.awt.Color(219, 219, 219));
        btn3.setColorPressed(new java.awt.Color(189, 189, 189));
        btn3.setColorTextHover(new java.awt.Color(128, 128, 131));
        btn3.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btn3.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btn3.setFocusable(false);
        btn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPMenu.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 194, 190, 42));

        jPContenido.setLayout(new javax.swing.BoxLayout(jPContenido, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setName("holaa"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );

        jPContenido.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(219, 219, 219));

        jPanel5.setBackground(new java.awt.Color(63, 179, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setText("Información pro área.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, "card2");

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(153, 153, 153));

        jMenu1.setText("Cuenta");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (!btn2.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(cor);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);
        } else {
            btn2.setColorHover(cor);
            btn2.setColorNormal(cor);
            btn2.setColorPressed(cor);
        }
        if (!jPContenido.getComponent(0).getName().equals("proyectos")) {
            new CambiaPanel(jPContenido, new proyecto());
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (!btn4.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(cor);
            btn4.setColorPressed(cor);
        } else {
            btn3.setColorHover(cor);
            btn3.setColorNormal(cor);
            btn3.setColorPressed(cor);
        }
        if (bp == null) {
            bp = new Producciones();
            bp.setVisible(true);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        int posicionX = jPMenu.getX();
        if (posicionX > -1) {
            Animacion.Animacion.mover_izquierda(0, -542, 1, 2, jPMenu);
            Animacion.Animacion.mover_izquierda(202, 10, 1, 2, jPContenido);
            Animacion.Animacion.mover_izquierda(1135, 935, 1, 2, jPanel3);
        } else {
            Animacion.Animacion.mover_derecha(-542, 0, 1, 2, jPMenu);
            Animacion.Animacion.mover_derecha(10, 202, 1, 2, jPContenido);
            Animacion.Animacion.mover_derecha(935, 1135, 1, 2, jPanel3);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (!btn1.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(cor);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(corF);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);
        } else {
            btn1.setColorHover(cor);
            btn1.setColorNormal(cor);
            btn1.setColorPressed(cor);
        }
        if (!jPContenido.getComponent(0).getName().equals("inicio")) {
            new CambiaPanel(jPContenido, new Inicio());
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (!btn3.isSelected()) {
            btn1.setColorHover(cor);
            btn1.setColorNormal(corF);
            btn1.setColorPressed(cor);

            btn2.setColorHover(cor);
            btn2.setColorNormal(corF);
            btn2.setColorPressed(cor);

            btn3.setColorHover(cor);
            btn3.setColorNormal(cor);
            btn3.setColorPressed(cor);

            btn4.setColorHover(cor);
            btn4.setColorNormal(corF);
            btn4.setColorPressed(cor);
        } else {
            btn3.setColorHover(cor);
            btn3.setColorNormal(cor);
            btn3.setColorPressed(cor);
        }
        if (!jPContenido.getComponent(0).getName().equals("usuarios")) {
            new CambiaPanel(jPContenido, new Usuarios1());
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
//            System.out.print("Hola");
    }//GEN-LAST:event_formWindowDeactivated

    private void jPSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPSuperiorMousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPSuperiorMousePressed

    private void jPSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPSuperiorMouseDragged
        this.setLocation((evt.getXOnScreen() - posX), (evt.getYOnScreen() - posY - 25));
    }//GEN-LAST:event_jPSuperiorMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
//                try {
//                    UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btn1;
    private rsbuttom.RSButtonMetro btn2;
    private rsbuttom.RSButtonMetro btn3;
    private rsbuttom.RSButtonMetro btn4;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPContenido;
    private javax.swing.JPanel jPMenu;
    private javax.swing.JPanel jPSuperior;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private rojerusan.RSFotoCircle rSFotoCircle2;
    // End of variables declaration//GEN-END:variables
}
