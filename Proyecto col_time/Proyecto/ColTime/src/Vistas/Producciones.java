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
        jTOrden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jTNombre = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        jTProyecto = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbTipo = new elaprendiz.gui.comboBox.ComboBoxRound();
        jButton1 = new javax.swing.JButton();
        Contenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(63, 179, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204)), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTOrden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTOrden.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTOrdenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTOrdenKeyTyped(evt);
            }
        });
        jPanel3.add(jTOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 51, 90, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 30, 71, -1));

        jTNombre.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombre.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreKeyTyped(evt);
            }
        });
        jPanel3.add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 51, 239, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 30, 225, -1));

        jTProyecto.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTProyecto.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProyectoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProyectoKeyTyped(evt);
            }
        });
        jPanel3.add(jTProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 51, 223, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setText("Tipo de proyecto:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 119, -1));

        cbTipo.setForeground(new java.awt.Color(102, 102, 102));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Normal", "RQT", "Quick" }));
        cbTipo.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });
        jPanel3.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 51, 162, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retro.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1062, 9, 30, 20));

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setName("contenido"); // NOI18N
        Contenido.setLayout(new javax.swing.BoxLayout(Contenido, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setName("inicio"); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setName("inicio"); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEmpresa/logo1.png"))); // NOI18N
        jLabel1.setName("logo"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jLabel1)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Contenido.add(jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        cambiarPanel(2);
    }//GEN-LAST:event_rSButtonMetro2ActionPerformed

    private void rSButtonMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro1ActionPerformed
        cambiarPanel(1);
    }//GEN-LAST:event_rSButtonMetro1ActionPerformed

    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro3ActionPerformed
        cambiarPanel(3);
    }//GEN-LAST:event_rSButtonMetro3ActionPerformed

    public void cambiarPanel(int op) {
        switch (op) {
            case 1:
                if (!Contenido.getComponent(0).getName().equals("FE")) {
                    new CambiaPanel(Contenido, new ProduccionFE());
                }
                reinicializarVariables();
                negocio = 1;
                agregarProyectoEnTabla(1, "", "", "", "");
                break;
            case 2:
                if (!Contenido.getComponent(0).getName().equals("TE")) {
                    new CambiaPanel(Contenido, new ProduccionTE());
                }
                reinicializarVariables();
                negocio = 2;
                agregarProyectoEnTabla(2, "", "", "", "");
                break;
            case 3:
                if (!Contenido.getComponent(0).getName().equals("IN")) {
                    new CambiaPanel(Contenido, new ProduccionEN());
                }
                reinicializarVariables();
                negocio = 3;
                agregarProyectoEnTabla(3, "", "", "", "");
                break;
        }
        jTNombre.setText("");
        jTOrden.setText("");
        jTProyecto.setText("");
        cbTipo.setSelectedIndex(0);
    }

    private void jTOrdenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTOrdenKeyReleased
        busqueda();
    }//GEN-LAST:event_jTOrdenKeyReleased

    private void jTOrdenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTOrdenKeyTyped
        char letra = evt.getKeyChar();
        if (Character.isLetter(letra) || evt.getKeyChar() == '|' || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '@') {
            evt.consume();
        }
    }//GEN-LAST:event_jTOrdenKeyTyped

    private void jTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyTyped
        char letra = evt.getKeyChar();
        if (Character.isDigit(letra) || evt.getKeyChar() == '|' || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '@') {
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreKeyTyped

    private void jTProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProyectoKeyTyped
        char letra = evt.getKeyChar();
        if (Character.isDigit(letra) || evt.getKeyChar() == '|' || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '@') {
            evt.consume();
        }
    }//GEN-LAST:event_jTProyectoKeyTyped

    private void jTNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreKeyReleased
        busqueda();
    }//GEN-LAST:event_jTNombreKeyReleased

    private void jTProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProyectoKeyReleased
        busqueda();
    }//GEN-LAST:event_jTProyectoKeyReleased

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        busqueda();
    }//GEN-LAST:event_cbTipoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = Contenido.getComponent(0).getName();
        switch (nombre) {
            case "FE":
                cambiarPanel(1);
                break;
            case "TE":
                cambiarPanel(2);
                break;
            case "IN":
                cambiarPanel(3);
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

//Metodos
    private void busqueda() {
        agregarProyectoEnTabla(negocio, jTOrden.getText(), jTNombre.getText(), jTProyecto.getText(), cbTipo.getSelectedItem().toString());
    }

    public void agregarProyectoEnTabla(int negocio, String orden, String cliente, String proyecto, String tipo) {
        try {
            //Se realiza la consulta para traer en numero de orden de todos los proyectos registrados
            Proyecto obj = new Proyecto();
            crs = obj.proyectosNegocio(negocio, orden, cliente, proyecto, tipo);
            reinicializarVariables();
            //Se valida cual de los tres contenedores se valida primero
            switch (negocio) {
                case 1:
                    ProduccionFE.contenidoFE.removeAll();
                    ProduccionFE.contenidoFE.updateUI();
                    break;
                case 2:
                    ProduccionTE.contenidoTE.removeAll();
                    ProduccionTE.contenidoTE.updateUI();
                    break;
                case 3:
                    ProduccionEN.contenidoEN.removeAll();
                    ProduccionEN.contenidoEN.updateUI();
                    break;
            }
            while (crs.next()) {
                JButton jp = new JButton(String.valueOf(crs.getInt(1)));
                jp.setBounds(0 + x, 0 + y, 98, 98);
                jp.addActionListener(this);
                jp.setFont(new Font("Tahoma", 1, 15));
                jp.setFocusPainted(false);
                //Icono del boton
                ImageIcon icon = null;
                switch (crs.getInt(2)) {
                    case 1:
                        //Por iniciar
                        switch (crs.getString(3)) {
                            case "Normal":
                                //Proyecto normal
                                icon = new ImageIcon("src\\produccion\\ProyectBegin.png");
                                break;
                            case "Quick":
                                //Proyecto Quick
                                icon = new ImageIcon("src\\produccion\\ProyectBeginQuick.png");
                                break;
                            case "RQT":
                                //Proyecto RQT
                                icon = new ImageIcon("src\\produccion\\ProyectBeginRQT.png");
                                break;
                        }
                        break;
                    case 2:
                        //Pausado
                        switch (crs.getString(3)) {
                            case "Normal":
                                //Proyecto normal
                                icon = new ImageIcon("src\\produccion\\ProyectPause.png");
                                break;
                            case "Quick":
                                //Proyecto Quick
                                icon = new ImageIcon("src\\produccion\\ProyectPauseQuick.png");
                                break;
                            case "RQT":
                                //Proyecto RQT
                                icon = new ImageIcon("src\\produccion\\ProyectPauseRQT.png");
                                break;
                        }
                        break;
                    case 3:
                        //Terminado
                        switch (crs.getString(3)) {
                            case "Normal":
                                //Proyecto normal
                                icon = new ImageIcon("src\\produccion\\ProyectCheck.png");
                                break;
                            case "Quick":
                                //Proyecto Quick
                                icon = new ImageIcon("src\\produccion\\ProyectCheckQuick.png");
                                break;
                            case "RQT":
                                //Proyecto RQT
                                icon = new ImageIcon("src\\produccion\\ProyectCheckRQT.png");
                                break;
                        }
                        break;
                    case 4:
                        //Ejecucion
                        switch (crs.getString(3)) {
                            case "Normal":
                                //Proyecto normal
                                icon = new ImageIcon("src\\produccion\\ProyectTime.png");
                                break;
                            case "Quick":
                                //Proyecto Quick
                                icon = new ImageIcon("src\\produccion\\ProyectTimeQuick.png");
                                break;
                            case "RQT":
                                //Proyecto RQT
                                icon = new ImageIcon("src\\produccion\\ProyectTimeRQT.png");
                                break;
                        }
                        break;
                }
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
            System.gc();//Garabage collector
            crs.close();
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
    public void actionPerformed(ActionEvent e) {//Estas lines me van a mostrar todos los detalles del proyecto sin importar se estan en ejecucion o no "1"
        int orden = Integer.parseInt(e.getActionCommand());
        detalleProduccion obj = new detalleProduccion(this, true, orden, negocio, 1);
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
    private elaprendiz.gui.comboBox.ComboBoxRound cbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombre;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTOrden;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTProyecto;
    private rsbuttom.RSButtonMetro rSButtonMetro1;
    private rsbuttom.RSButtonMetro rSButtonMetro2;
    private rsbuttom.RSButtonMetro rSButtonMetro3;
    // End of variables declaration//GEN-END:variables
@Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
