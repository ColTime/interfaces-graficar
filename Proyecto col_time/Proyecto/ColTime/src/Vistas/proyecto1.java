package Vistas;

import Controlador.DetalleProyecto;
import Controlador.Proyecto;
import com.barcodelib.barcode.QRCode;
import java.awt.Color;
import java.io.File;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

public class proyecto1 extends javax.swing.JPanel {

    public proyecto1(int p) {
        if (p == 1) {
            initComponents();
            desactivarComponentes();
            grafica.setIcon(llamarDiagramas(1, 0));
            jLDetalle.setVisible(false);
        }
    }

    public proyecto1() {//Constructor vacio

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPDiagrama = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPInformacion = new javax.swing.JPanel();
        jTNorden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jTNegocio = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jTTipoNegocio = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnConsultarDetalle = new elaprendiz.gui.button.ButtonColoredAction();
        cbProcedoPNC = new elaprendiz.gui.comboBox.ComboBoxRound();
        jLabel6 = new javax.swing.JLabel();
        jTCantindad = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel7 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnBuscarPNC = new javax.swing.JButton();
        btnModificarPNC = new javax.swing.JButton();
        jLDetalle = new javax.swing.JLabel();
        btnGenerarQR = new elaprendiz.gui.button.ButtonColoredAction();
        btnDelete = new javax.swing.JButton();
        jLMaterial = new javax.swing.JLabel();
        jPEstadistica = new javax.swing.JPanel();
        grafica = new javax.swing.JLabel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Vbar.png"))); // NOI18N
        jMenuItem1.setText("Vertical");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPDiagrama.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Hvar.png"))); // NOI18N
        jMenuItem2.setText("Horizontal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPDiagrama.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/torta.png"))); // NOI18N
        jMenuItem3.setText("Torta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPDiagrama.add(jMenuItem3);

        setBackground(new java.awt.Color(219, 219, 219));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setName("proyectos1"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 131)));

        jPInformacion.setBackground(new java.awt.Color(255, 255, 255));
        jPInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Producto No Conforme", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jTNorden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTNorden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNorden.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNorden.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");

        jTNegocio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTNegocio.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNegocio.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNegocio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Negocio:");

        jTTipoNegocio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTTipoNegocio.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTTipoNegocio.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTTipoNegocio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Tipo de negocio:");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_proyect.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnConsultarDetalle.setText("Proyectos");
        btnConsultarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDetalleActionPerformed(evt);
            }
        });

        cbProcedoPNC.setForeground(new java.awt.Color(102, 102, 102));
        cbProcedoPNC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione..." }));
        cbProcedoPNC.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbProcedoPNC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbProcedoPNC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProcedoPNCItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setText("Proceso del PNC:");

        jTCantindad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTCantindad.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTCantindad.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTCantindad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTCantindad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCantindadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCantindadKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setText("Cantidad:");

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_Proyect.png"))); // NOI18N
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBuscarPNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscarPNC.setBorderPainted(false);
        btnBuscarPNC.setContentAreaFilled(false);
        btnBuscarPNC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarPNC.setFocusPainted(false);
        btnBuscarPNC.setFocusable(false);
        btnBuscarPNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPNCActionPerformed(evt);
            }
        });

        btnModificarPNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnModificarPNC.setBorderPainted(false);
        btnModificarPNC.setContentAreaFilled(false);
        btnModificarPNC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarPNC.setFocusPainted(false);
        btnModificarPNC.setFocusable(false);
        btnModificarPNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPNCActionPerformed(evt);
            }
        });

        jLDetalle.setText("0");

        btnGenerarQR.setText("Generar QR");
        btnGenerarQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarQRActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete1 (2).png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLMaterial.setText("Material");

        javax.swing.GroupLayout jPInformacionLayout = new javax.swing.GroupLayout(jPInformacion);
        jPInformacion.setLayout(jPInformacionLayout);
        jPInformacionLayout.setHorizontalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPNC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarPNC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConsultarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPInformacionLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLDetalle))
                                    .addComponent(jTNorden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInformacionLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39))
                                    .addGroup(jPInformacionLayout.createSequentialGroup()
                                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPInformacionLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(30, 30, 30)))
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTTipoNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbProcedoPNC, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTCantindad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(134, 134, 134))))
        );
        jPInformacionLayout.setVerticalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInformacionLayout.createSequentialGroup()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDetalle)
                            .addComponent(jLMaterial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNorden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTTipoNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProcedoPNC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTCantindad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarPNC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModificarPNC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPEstadistica.setBackground(new java.awt.Color(255, 255, 255));

        grafica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grafica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                graficaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPEstadisticaLayout = new javax.swing.GroupLayout(jPEstadistica);
        jPEstadistica.setLayout(jPEstadisticaLayout);
        jPEstadisticaLayout.setHorizontalGroup(
            jPEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEstadisticaLayout.createSequentialGroup()
                .addComponent(grafica, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPEstadisticaLayout.setVerticalGroup(
            jPEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(grafica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPEstadistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public static int cargo = 0;
    int udm = 0, resol = 80, rot = 0;
    float mi = 0.000f, md = 0.000f, ms = 0.000f, min = 0.000f, tam = 15.000f;
    static int op = 0;
    boolean res = false;

    private void btnConsultarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDetalleActionPerformed
        ConsultarPNC obj = new ConsultarPNC(cargo, 1, 1);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnConsultarDetalleActionPerformed

    private void cbProcedoPNCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProcedoPNCItemStateChanged
        if (op == 1) {
            if (!jTCantindad.getText().equals("")) {
                btnGuardar.setEnabled(true);
            } else {
                btnGuardar.setEnabled(false);
            }
        } else {
            if (!jTCantindad.getText().equals("")) {
                btnModificarPNC.setEnabled(true);
            } else {
                btnModificarPNC.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cbProcedoPNCItemStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jPInformacion.setBackground(new Color(255, 255, 255));
        btnConsultarDetalle.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificarPNC.setEnabled(false);
        btnGenerarQR.setEnabled(false);
        btnDelete.setEnabled(false);
        jLDetalle.setText("0");
        op = 1;
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTCantindadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantindadKeyTyped
        //No se debe permitir el ingreso de nungun caracter que no sea un numero
        if (Character.isLetter(evt.getKeyChar()) || evt.getKeyChar() == '|' || evt.getKeyChar() == '@' || evt.getKeyChar() == '.' || evt.getKeyChar() == '-' || evt.getKeyChar() == '_'
                || evt.getKeyChar() == '!' || evt.getKeyChar() == '#') {
            evt.consume();
        }
    }//GEN-LAST:event_jTCantindadKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        RegistrarPNCModificar(1);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarPNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPNCActionPerformed
        ConsultarPNC obj = new ConsultarPNC(cargo, 2, 2);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnBuscarPNCActionPerformed

    private void btnModificarPNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPNCActionPerformed
        RegistrarPNCModificar(2);
    }//GEN-LAST:event_btnModificarPNCActionPerformed

    private void btnGenerarQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarQRActionPerformed
        rutaGuardado();
    }//GEN-LAST:event_btnGenerarQRActionPerformed

    private void jTCantindadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantindadKeyReleased
        if (op == 1) {
            if (!jTCantindad.getText().equals("")) {
                btnGuardar.setEnabled(true);
            } else {
                btnGuardar.setEnabled(false);
            }
        } else {
            if (!jTCantindad.getText().equals("")) {
                btnModificarPNC.setEnabled(true);
            } else {
                btnModificarPNC.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jTCantindadKeyReleased

    private void graficaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graficaMouseReleased
        if (evt.isPopupTrigger()) {
            jPDiagrama.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_graficaMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        grafica.setIcon(llamarDiagramas(1, 0));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        grafica.setIcon(llamarDiagramas(2, 0));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        grafica.setIcon(llamarDiagramas(3, 0));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DetalleProyecto obj = new DetalleProyecto();
        int negocio = 0;//Negocio
        if (jTNegocio.getText().equals("FE")) {
            negocio = 1;
        } else if (jTNegocio.getText().equals("TE")) {
            negocio = 2;
        } else if (jTNegocio.getText().equals("IN")) {
            negocio = 3;
        }
        int tipo = 0;//Tipo de negocio
        switch (jTTipoNegocio.getText()) {
            case "Circuito":
                tipo = 1;
                break;
            case "Conversor":
                tipo = 2;
                break;
            case "PCB":
                tipo = 7;
                break;
            case "Repujado":
                tipo = 3;
                break;
            case "Stencil":
                tipo = 6;
                break;
            case "Teclado":
                tipo = 5;
                break;
            case "Troquel":
                tipo = 4;
                break;
        }
        if (obj.validarEliminacionModificar(negocio, Integer.parseInt(jTNorden.getText()), tipo, Integer.parseInt(jLDetalle.getText()), 2)) {
            if (JOptionPane.showOptionDialog(null, "¿Seguro desea eliminar el PNC",
                    "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                    new Object[]{"SI", "NO"}, "SI") == 0) {
                if (obj.eliminarDetallersProyecto(Integer.parseInt(jLDetalle.getText()), Integer.parseInt(jTNorden.getText()), jTNegocio.getText(), jTTipoNegocio.getText(), 2)) {//Producto no conforme
                    new rojerusan.RSNotifyAnimated("Listo", "El PNC fue eliminado correctamente.", 6, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    limpiar();
                    desactivarComponentes();
                }
            }
        } else {
            //Mensaje de no se puede eliminar el PNC
            new rojerusan.RSNotifyAnimated("Advertencia", "El PNC no puede ser eliminado.", 6, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
        }

        //Esta pendiente organizar esta parte del codigo----------------------------------------------------------------->
    }//GEN-LAST:event_btnDeleteActionPerformed
//Metodos-------------------------------------------------------------------->

    private ImageIcon llamarDiagramas(int tipoDiagrama, int busqueda) {
        Controlador.Diagramas obj = new Controlador.Diagramas();
        return obj.graficaCantidad(tipoDiagrama, 0, "", "");
    }

    private String rutaGuardado() {
        //Se obtiene la ruta donde se quiere guardar codigo QR
        try {
            JFileChooser Chocer = new JFileChooser();
            Chocer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            Chocer.setLocation(500, 500);
            Chocer.showOpenDialog(this);
            File guardar = Chocer.getSelectedFile();
            if (guardar != null) {
                QRCode cod = new QRCode();
                String negocio = "";
                switch (jTNegocio.getText()) {
                    case "FE":
                        negocio = "1";
                        break;
                    case "TE":
                        negocio = "2";
                        break;
                    case "EN":
                        negocio = "3";
                        break;
                }
                //Se asigna el valor al QR
                String texto = jTNorden.getText() + ';' + jLDetalle.getText() + ';' + negocio;
                cod.setData(texto);
                cod.setDataMode(QRCode.MODE_BYTE);
                //se crea el QR y se guarda en la direccion seleccionada
                cod.setUOM(udm);
                cod.setLeftMargin(mi);
                cod.setResolution(resol);
                cod.setRightMargin(md);
                cod.setTopMargin(ms);
                cod.setBottomMargin(min);
                cod.setRotate(rot);
                cod.setModuleSize(tam);
                cod.renderBarcode(guardar + "\\" + texto + ".png");
                new rojerusan.RSNotifyAnimated("¡listo!", "El codigo fue generado en la ruta: " + guardar, 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private void limpiar() {
        jTNorden.setText("");
        jTNegocio.setText("");
        jTTipoNegocio.setText("");
        jTCantindad.setText("");
        jTCantindad.setEnabled(false);
        cbProcedoPNC.setSelectedItem(0);
        cbProcedoPNC.setEnabled(false);
    }

    private void RegistrarPNCModificar(int op) {//------------------------------------>
        if (cbProcedoPNC.getSelectedIndex() != 0) {
            DetalleProyecto obj = new DetalleProyecto();
            int cantidad = obj.ValidarCnatidadPNC(jTNorden.getText(), Integer.parseInt(jLDetalle.getText()), op, jTTipoNegocio.getText(), jTNegocio.getText());
            if (Integer.parseInt(jTCantindad.getText()) > 0) {
                if (Integer.parseInt(jTCantindad.getText()) <= cantidad) {
                    obj.setCantidad(jTCantindad.getText());
                    obj.setNegocio(jTNegocio.getText());
                    obj.setTipoNegocio(jTTipoNegocio.getText());
                    obj.setMaterial(jLMaterial.getText());//...Pendiente...
                    res = obj.registrarModificarPNC(jTNorden.getText(), op, Integer.parseInt(jLDetalle.getText()), cbProcedoPNC.getSelectedItem().toString());
                    if (res) {
                        desactivarComponentes();
                        if (op == 1) {
                            new rojerusan.RSNotifyAnimated("¡listo!", "El PNC fue registrado correctamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                        } else {
                            new rojerusan.RSNotifyAnimated("¡listo!", "El PNC fue Modificado correctamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                        }
                        limpiar();
                        btnNuevo.setEnabled(true);
                        btnGuardar.setEnabled(false);
                        btnConsultarDetalle.setEnabled(false);
                    } else {
                        new rojerusan.RSNotifyAnimated("¡Alerta!", "El PNC no pudo ser registrado.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                    }
                } else {
                    new rojerusan.RSNotifyAnimated("¡Alerta!", "La cantidad ingresada es mayor a la cantidad del proyecto (" + cantidad + ").", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR
                    ).setVisible(true);
                }
            } else {
                new rojerusan.RSNotifyAnimated("¡Alerta!", "La cantidad de un producto no conforme no puede ser menor o igual a 0.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
            }
        } else {
            new rojerusan.RSNotifyAnimated("¡Alerta!", "Debes seleccionar el proceso donde se genero el PNC.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
        }
    }

    public void desactivarComponentes() {
        jPInformacion.setBackground(new Color(244, 244, 244));
        btnConsultarDetalle.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnDelete.setEnabled(false);
        btnModificarPNC.setEnabled(false);
        btnGenerarQR.setEnabled(false);
        jTNorden.setEnabled(false);
        jTNegocio.setEnabled(false);
        jTTipoNegocio.setEnabled(false);
        cbProcedoPNC.setEnabled(false);
        jTCantindad.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscarPNC;
    public static elaprendiz.gui.button.ButtonColoredAction btnConsultarDetalle;
    public static javax.swing.JButton btnDelete;
    public static elaprendiz.gui.button.ButtonColoredAction btnGenerarQR;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnModificarPNC;
    public static javax.swing.JButton btnNuevo;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbProcedoPNC;
    private javax.swing.JLabel grafica;
    public static javax.swing.JLabel jLDetalle;
    public static javax.swing.JLabel jLMaterial;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPDiagrama;
    private javax.swing.JPanel jPEstadistica;
    public static javax.swing.JPanel jPInformacion;
    private javax.swing.JPanel jPanel1;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTCantindad;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNegocio;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNorden;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTTipoNegocio;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
