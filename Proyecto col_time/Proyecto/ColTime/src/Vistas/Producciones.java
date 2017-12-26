package Vistas;

import Controlador.Proyecto;
import coltime.Menu;
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
        EstadoDelMenu(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
//        new CambiaPanel(Contenido, new ProduccionFE());
//        generarLabel("28400");
    }
    int posX = 0;
    int posY = 0;
    int panel = 0;
    CachedRowSet crs = null;
    int x = 0, y = 0, cantidad = 0, filas = 1, unidad = 11, conta = 5;
    static int negocio = 0;
    public Color cor = new Color(17, 161, 255);
    public Color corF = new Color(63, 179, 255);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBSalir = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btn1 = new rsbuttom.RSButtonMetro();
        btn2 = new rsbuttom.RSButtonMetro();
        btn3 = new rsbuttom.RSButtonMetro();
        btn4 = new rsbuttom.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        jPMenu = new javax.swing.JPanel();
        jTOrden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jTNombre = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        jTProyecto = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbTipo = new elaprendiz.gui.comboBox.ComboBoxRound();
        jBActualizar = new javax.swing.JButton();
        Contenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jBSalir.setBorderPainted(false);
        jBSalir.setContentAreaFilled(false);
        jBSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSalir.setFocusPainted(false);
        jBSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jBSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1098, 12, 23, -1));

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
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1069, 12, 23, -1));

        btn1.setBackground(new java.awt.Color(63, 179, 255));
        btn1.setText("Formato estandar");
        btn1.setBorderPainted(false);
        btn1.setColorHover(new java.awt.Color(17, 161, 255));
        btn1.setColorNormal(new java.awt.Color(63, 179, 255));
        btn1.setColorPressed(new java.awt.Color(38, 86, 186));
        btn1.setFocusPainted(false);
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn1MousePressed(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 149, 55));

        btn2.setBackground(new java.awt.Color(63, 179, 255));
        btn2.setText("Teclados");
        btn2.setBorderPainted(false);
        btn2.setColorHover(new java.awt.Color(17, 161, 255));
        btn2.setColorNormal(new java.awt.Color(63, 179, 255));
        btn2.setColorPressed(new java.awt.Color(38, 86, 186));
        btn2.setFocusPainted(false);
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn2MousePressed(evt);
            }
        });
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1, 140, 55));

        btn3.setBackground(new java.awt.Color(63, 179, 255));
        btn3.setText("Ensamble");
        btn3.setBorderPainted(false);
        btn3.setColorHover(new java.awt.Color(17, 161, 255));
        btn3.setColorNormal(new java.awt.Color(63, 179, 255));
        btn3.setColorPressed(new java.awt.Color(38, 86, 186));
        btn3.setFocusPainted(false);
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn3MousePressed(evt);
            }
        });
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 1, 131, 55));

        btn4.setBackground(new java.awt.Color(63, 179, 255));
        btn4.setText("Almacen");
        btn4.setBorderPainted(false);
        btn4.setColorHover(new java.awt.Color(17, 161, 255));
        btn4.setColorNormal(new java.awt.Color(63, 179, 255));
        btn4.setColorPressed(new java.awt.Color(38, 86, 186));
        btn4.setFocusPainted(false);
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn4MousePressed(evt);
            }
        });
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 1, -1, 55));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jPMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204)), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPMenu.add(jTOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 51, 90, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");
        jPMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 30, 71, -1));

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
        jPMenu.add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 51, 239, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");
        jPMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 30, 225, -1));

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
        jPMenu.add(jTProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 51, 223, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");
        jPMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setText("Tipo de proyecto:");
        jPMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 119, -1));

        cbTipo.setForeground(new java.awt.Color(102, 102, 102));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Normal", "RQT", "Quick" }));
        cbTipo.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbTipo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });
        jPMenu.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 51, 162, 25));

        jBActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retro.png"))); // NOI18N
        jBActualizar.setToolTipText("");
        jBActualizar.setBorderPainted(false);
        jBActualizar.setContentAreaFilled(false);
        jBActualizar.setFocusable(false);
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });
        jPMenu.add(jBActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 20, 20));

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
                .addContainerGap(383, Short.MAX_VALUE))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        this.dispose();
        System.gc();//Garabage collector
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        EstadoDelMenu(true);
        cambiarPanel(2);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        EstadoDelMenu(true);
        cambiarPanel(1);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        EstadoDelMenu(true);
        cambiarPanel(3);
    }//GEN-LAST:event_btn3ActionPerformed

    public void cambiarPanel(int op) {
        switch (op) {
            case 1:
                //Vista de formato estandar
                if (!Contenido.getComponent(0).getName().equals("FE")) {
                    ProduccionFE obj = new ProduccionFE();
                    obj.setName("FE");
                    new CambiaPanel(Contenido, obj);
                }
                reinicializarVariables();
                negocio = 1;
                agregarProyectoEnTabla(1, "", "", "", "");
                break;
            case 2:
                //Vista de teclados
                if (!Contenido.getComponent(0).getName().equals("TE")) {
                    new CambiaPanel(Contenido, new ProduccionTE());
                }
                reinicializarVariables();
                negocio = 2;
                agregarProyectoEnTabla(2, "", "", "", "");
                break;
            case 3:
                //Vista de Ensamble
                if (!Contenido.getComponent(0).getName().equals("IN")) {
                    new CambiaPanel(Contenido, new ProduccionEN());
                }
                reinicializarVariables();
                negocio = 3;
                agregarProyectoEnTabla(3, "", "", "", "");
                break;
            case 4:
                //Vista de almacen
                if (!Contenido.getComponent(0).getName().equals("Almacen")) {
                    ProduccionFE obj = new ProduccionFE();
                    obj.setName("Almacen");
                    new CambiaPanel(Contenido, obj);
                }
                reinicializarVariables();
                negocio = 4;
                agregarProyectoEnTabla(4, "", "", "", "");
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

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
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
            case "Almacen":
                cambiarPanel(4);
                break;
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu.bp = null;
    }//GEN-LAST:event_formWindowClosed

    private void btn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MousePressed
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
    }//GEN-LAST:event_btn1MousePressed

    private void btn2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MousePressed
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
    }//GEN-LAST:event_btn2MousePressed

    private void btn3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MousePressed
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
    }//GEN-LAST:event_btn3MousePressed

    private void btn4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MousePressed
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
            btn4.setColorHover(cor);
            btn4.setColorNormal(cor);
            btn4.setColorPressed(cor);
        }
    }//GEN-LAST:event_btn4MousePressed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        EstadoDelMenu(true);
        cambiarPanel(4);
    }//GEN-LAST:event_btn4ActionPerformed

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
                case 4:
                    ProduccionFE.contenidoFE.removeAll();
                    ProduccionFE.contenidoFE.updateUI();
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
                    case 4:
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
                jp = null;
            }
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

    private void EstadoDelMenu(boolean estado) {
        jTOrden.setEnabled(estado);
        jTNombre.setEnabled(estado);
        jTProyecto.setEnabled(estado);
        cbTipo.setEnabled(estado);
        jBActualizar.setEnabled(estado);
        jPMenu.setEnabled(estado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//Estas lines me van a mostrar todos los detalles del proyecto sin importar se estan en ejecucion o no "1"
        int orden = Integer.parseInt(e.getActionCommand());
        detalleProduccion obj = new detalleProduccion(this, true, orden, negocio, 1);
        if (negocio == 4) {
            obj.btnPNC.setVisible(false);
        }
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
    private rsbuttom.RSButtonMetro btn1;
    private rsbuttom.RSButtonMetro btn2;
    private rsbuttom.RSButtonMetro btn3;
    private rsbuttom.RSButtonMetro btn4;
    private elaprendiz.gui.comboBox.ComboBoxRound cbTipo;
    private javax.swing.JButton jBActualizar;
    public static javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombre;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTOrden;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTProyecto;
    // End of variables declaration//GEN-END:variables
@Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
