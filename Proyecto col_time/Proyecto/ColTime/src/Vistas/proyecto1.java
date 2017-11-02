package Vistas;

import Controlador.DetalleProyecto;
import com.barcodelib.barcode.QRCode;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import rojerusan.RSNotifyAnimated;

public class proyecto1 extends javax.swing.JPanel {

    public proyecto1(int p) {
        if (p == 1) {
            initComponents();
            desactivarComponentes();
            grafica();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPEstadistica = new javax.swing.JPanel();
        grafica = new javax.swing.JLabel();

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
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConsultarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLDetalle)
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
                            .addComponent(btnModificarPNC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        grafica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
            .addComponent(grafica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
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
    boolean res = false;
    private void btnConsultarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDetalleActionPerformed
        ConsultarPNC obj = new ConsultarPNC(cargo, 1,1);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnConsultarDetalleActionPerformed

    private void cbProcedoPNCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProcedoPNCItemStateChanged

    }//GEN-LAST:event_cbProcedoPNCItemStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jPInformacion.setBackground(new Color(255, 255, 255));
        btnConsultarDetalle.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnModificarPNC.setEnabled(false);
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jTCantindadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCantindadKeyTyped
        //Borrar
    }//GEN-LAST:event_jTCantindadKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        RegistrarPNCModificar(1);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarPNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPNCActionPerformed
        ConsultarPNC obj = new ConsultarPNC(cargo, 2,2);
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
        if (!jTCantindad.getText().equals("")) {
            btnGuardar.setEnabled(true);
        } else {
            btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTCantindadKeyReleased
//Metodos-------------------------------------------------------------------->

    private String rutaGuardado() {
        //Se obtiene la ruta donde se quiere guardar codigo QR
        try {
            JFileChooser Chocer = new JFileChooser();
            Chocer.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
                String texto = jTNorden.getText() + ';' + jLDetalle.getText() + ';' + negocio;
                cod.setData(texto);
                cod.setDataMode(QRCode.MODE_BYTE);

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

    private void RegistrarPNCModificar(int op) {
        if (cbProcedoPNC.getSelectedIndex() != 0) {
            DetalleProyecto obj = new DetalleProyecto();
            int cantidad = obj.ValidarCnatidadPNC(jTNorden.getText(), Integer.parseInt(jLDetalle.getText()), op, jTTipoNegocio.getText(), jTNegocio.getText());
            if (Integer.parseInt(jTCantindad.getText()) <=cantidad) {
                obj.setCantidad(jTCantindad.getText());
                obj.setNegocio(jTNegocio.getText());
                obj.setTipoNegocio(jTTipoNegocio.getText());
                obj.setMaterial("");
                res = obj.registrarModificarPNC(jTNorden.getText(), op, Integer.parseInt(jLDetalle.getText()), cbProcedoPNC.getSelectedItem().toString());
                if (res) {
                    desactivarComponentes();
                    new rojerusan.RSNotifyAnimated("¡listo!", "El PNC fue registrado correctamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    limpiar();
                    btnNuevo.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    btnConsultarDetalle.setEnabled(false);
                } else {
                    new rojerusan.RSNotifyAnimated("¡Alerta!", "La cantidad ingresada es mayor a la cantidad del proyecto.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            } else {
                new rojerusan.RSNotifyAnimated("¡Alerta!", "El PNC no pudo ser registrado.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        } else {
            new rojerusan.RSNotifyAnimated("¡Alerta!", "Debes seleccionar el proceso donde se genero el PNC.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
        }
    }

    public void desactivarComponentes() {
        jPInformacion.setBackground(new Color(244, 244, 244));
        btnConsultarDetalle.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnModificarPNC.setEnabled(false);
        jTNorden.setEnabled(false);
        jTNegocio.setEnabled(false);
        jTTipoNegocio.setEnabled(false);
        cbProcedoPNC.setEnabled(false);
        jTCantindad.setEnabled(false);
    }

    private void grafica() {
        try {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            ds.addValue(70, "Formato estandar", "FE");
            ds.addValue(20, "Teclados", "TE");
            ds.addValue(30, "Ensamble", "EN");

            JFreeChart jf = ChartFactory.createBarChart3D("Cantidad de proyectos por area", "Nombres", "Edades", ds, PlotOrientation.VERTICAL, true, true, true);

            grafica.setIcon(new ImageIcon(jf.createBufferedImage(859, 366)));
//            ChartFrame f = new ChartFrame("Edades", jf);
//            f.setSize(1000, 600);
//            f.setLocationRelativeTo(null);
//            f.setVisible(true);

        } catch (Exception e) {
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscarPNC;
    public static elaprendiz.gui.button.ButtonColoredAction btnConsultarDetalle;
    public static elaprendiz.gui.button.ButtonColoredAction btnGenerarQR;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnModificarPNC;
    public static javax.swing.JButton btnNuevo;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbProcedoPNC;
    private javax.swing.JLabel grafica;
    public static javax.swing.JLabel jLDetalle;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
