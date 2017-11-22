package Vistas;

import Atxy2k.CustomTextField.RestrictedTextField;
import Controlador.DetalleProyecto;
import Controlador.Proyecto;
import coltime.Menu;
import com.barcodelib.barcode.QRCode;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import elaprendiz.gui.textField.TextFieldRoundBackground;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

public class proyecto extends javax.swing.JPanel {

    public proyecto(int p) {
        if (p == 1) {
            initComponents();
            cambiarEstadoFalso();
            cambiarEstadoBotones();
            btnNuevo.setEnabled(true);
            Notificacion1.setVisible(false);
            GenerarQR.setEnabled(false);
            btnTomaTiempos.setVisible(false);
            visibilidadID();
            limites();
        }
        op = p;
        limpiarCampos();
    }
    static int op = 0;
    boolean v[] = new boolean[12];
    int udm = 0, resol = 100, rot = 0;
    float mi = 0.000f, md = 0.000f, ms = 0.000f, min = 0.000f, tam = 21.000f;
    static String fecha = "";

    private void visibilidadID() {
        jLIDConversor.setVisible(false);
        jLIDTroquel.setVisible(false);
        jLIDRepujado.setVisible(false);
        jLIDStencil.setVisible(false);
        jLIDCircuito.setVisible(false);
        jLIDPCB.setVisible(false);
        jLIDTeclado.setVisible(false);
        jLIDIntegracion.setVisible(false);
    }

    private void limites() {
        RestrictedTextField obj = new RestrictedTextField(jTConversor);
        obj.setLimit(6);
        RestrictedTextField obj1 = new RestrictedTextField(jTRepujado);
        obj1.setLimit(6);
        RestrictedTextField obj2 = new RestrictedTextField(jTTroquel);
        obj2.setLimit(6);
        RestrictedTextField obj3 = new RestrictedTextField(jTCircuito);
        obj3.setLimit(6);
        RestrictedTextField obj4 = new RestrictedTextField(jTStencil);
        obj4.setLimit(6);
        RestrictedTextField obj5 = new RestrictedTextField(jTIntegracion);
        obj5.setLimit(6);
        RestrictedTextField obj6 = new RestrictedTextField(jTTeclado);
        obj6.setLimit(6);
        RestrictedTextField obj7 = new RestrictedTextField(jTPCBTE);
        obj7.setLimit(6);
        RestrictedTextField obj8 = new RestrictedTextField(jTNombreCliente);
        obj8.setLimit(45);
        RestrictedTextField obj9 = new RestrictedTextField(jTNombreProyecto);
        obj9.setLimit(45);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPInformacion = new javax.swing.JPanel();
        jTNorden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jTNombreCliente = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTNombreProyecto = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPDetalles1 = new javax.swing.JPanel();
        jTTeclado = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCTeclado = new javax.swing.JCheckBox();
        jTConversor = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTTroquel = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTRepujado = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTStencil = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCConversor = new javax.swing.JCheckBox();
        jTCircuito = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCRepujado = new javax.swing.JCheckBox();
        jTPCBTE = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel8 = new javax.swing.JLabel();
        jCTroquel = new javax.swing.JCheckBox();
        jCCircuito = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jCPCBTE = new javax.swing.JCheckBox();
        jCStencil = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cbMaterialCircuito = new elaprendiz.gui.comboBox.ComboBoxRound();
        cbMaterialPCBTE = new elaprendiz.gui.comboBox.ComboBoxRound();
        jTIntegracion = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jCIntegracion = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCRuteoC = new javax.swing.JCheckBox();
        jCAntisolderC = new javax.swing.JCheckBox();
        jCAntisolderP = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCRuteoP = new javax.swing.JCheckBox();
        jPDetalles = new javax.swing.JPanel();
        jDentrega = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbNegocio = new elaprendiz.gui.comboBox.ComboBoxRound();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbTipo = new elaprendiz.gui.comboBox.ComboBoxRound();
        jLabel21 = new javax.swing.JLabel();
        jLIngreso = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        Notificacion1 = new javax.swing.JLabel();
        jLIDConversor = new javax.swing.JLabel();
        jLIDTroquel = new javax.swing.JLabel();
        jLIDRepujado = new javax.swing.JLabel();
        jLIDStencil = new javax.swing.JLabel();
        jLIDCircuito = new javax.swing.JLabel();
        jLIDPCB = new javax.swing.JLabel();
        jLIDTeclado = new javax.swing.JLabel();
        jLIDIntegracion = new javax.swing.JLabel();
        GenerarQR = new elaprendiz.gui.button.ButtonColoredAction();
        jTProyectoQR = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jButton1 = new javax.swing.JButton();
        btnTomaTiempos = new elaprendiz.gui.button.ButtonColoredAction();
        jPanel3 = new javax.swing.JPanel();
        btnGenerarExcel = new javax.swing.JButton();
        btnGenerarPDF = new javax.swing.JButton();

        setBackground(new java.awt.Color(219, 219, 219));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("proyectos"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 131)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(128, 128, 131))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPInformacion.setBackground(new java.awt.Color(255, 255, 255));
        jPInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Información filtraria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jTNorden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTNorden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNorden.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNorden.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");

        jTNombreCliente.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreCliente.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreClienteKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("*");

        jTNombreProyecto.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreProyecto.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreProyecto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTNombreProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNombreProyectoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("*");

        javax.swing.GroupLayout jPInformacionLayout = new javax.swing.GroupLayout(jPInformacion);
        jPInformacion.setLayout(jPInformacionLayout);
        jPInformacionLayout.setHorizontalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTNorden, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPInformacionLayout.setVerticalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNorden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 430, 180));

        jPDetalles1.setBackground(new java.awt.Color(255, 255, 255));
        jPDetalles1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPDetalles1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTTeclado.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTTeclado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTTeclado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTTeclado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTTecladoKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTTeclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 49, -1, 25));

        jCTeclado.setBackground(new java.awt.Color(255, 255, 255));
        jCTeclado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTeclado.setForeground(new java.awt.Color(102, 102, 102));
        jCTeclado.setText("Teclado");
        jCTeclado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCTecladoMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCTeclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 19, -1, -1));

        jTConversor.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTConversor.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTConversor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTConversor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTConversorKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTConversor, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 49, -1, 25));

        jTTroquel.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTTroquel.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTTroquel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTTroquel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTTroquelKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTTroquel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 49, -1, 25));

        jTRepujado.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTRepujado.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTRepujado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTRepujado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTRepujadoKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTRepujado, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 49, -1, 25));

        jTStencil.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTStencil.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTStencil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTStencil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTStencilKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTStencil, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 49, -1, 25));

        jCConversor.setBackground(new java.awt.Color(255, 255, 255));
        jCConversor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCConversor.setForeground(new java.awt.Color(102, 102, 102));
        jCConversor.setText("Conversor");
        jCConversor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCConversorMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCConversor, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 19, -1, -1));

        jTCircuito.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTCircuito.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTCircuito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTCircuito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCircuitoKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTCircuito, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 49, -1, 25));

        jCRepujado.setBackground(new java.awt.Color(255, 255, 255));
        jCRepujado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCRepujado.setForeground(new java.awt.Color(102, 102, 102));
        jCRepujado.setText("Repujado");
        jCRepujado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCRepujadoMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCRepujado, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 19, -1, -1));

        jTPCBTE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTPCBTE.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTPCBTE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTPCBTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPCBTEKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTPCBTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 49, -1, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setText("Cantidades:");
        jPDetalles1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 49, -1, -1));

        jCTroquel.setBackground(new java.awt.Color(255, 255, 255));
        jCTroquel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCTroquel.setForeground(new java.awt.Color(102, 102, 102));
        jCTroquel.setText("Troquel");
        jCTroquel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCTroquelMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCTroquel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 19, 80, -1));

        jCCircuito.setBackground(new java.awt.Color(255, 255, 255));
        jCCircuito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCCircuito.setForeground(new java.awt.Color(102, 102, 102));
        jCCircuito.setText("Circuito");
        jCCircuito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCCircuitoMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCCircuito, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 19, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 128, 131));
        jLabel9.setText("Otras ordenes:");
        jPDetalles1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 29, -1, -1));

        jCPCBTE.setBackground(new java.awt.Color(255, 255, 255));
        jCPCBTE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCPCBTE.setForeground(new java.awt.Color(102, 102, 102));
        jCPCBTE.setText("PCB");
        jCPCBTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCPCBTEMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCPCBTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 19, -1, -1));

        jCStencil.setBackground(new java.awt.Color(255, 255, 255));
        jCStencil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCStencil.setForeground(new java.awt.Color(102, 102, 102));
        jCStencil.setText("Stencil");
        jCStencil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCStencilMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCStencil, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 19, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(128, 128, 131));
        jLabel22.setText("Material de la PCB TE:");
        jPDetalles1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 97, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setText("Material del Circuito:");
        jPDetalles1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 97, -1, -1));

        cbMaterialCircuito.setForeground(new java.awt.Color(102, 102, 102));
        cbMaterialCircuito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "TH", "FV" }));
        cbMaterialCircuito.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbMaterialCircuito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDetalles1.add(cbMaterialCircuito, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 92, 150, 25));

        cbMaterialPCBTE.setForeground(new java.awt.Color(102, 102, 102));
        cbMaterialPCBTE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "TH", "FV" }));
        cbMaterialPCBTE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbMaterialPCBTE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPDetalles1.add(cbMaterialPCBTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 92, 150, 25));

        jTIntegracion.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTIntegracion.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTIntegracion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTIntegracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTIntegracionKeyTyped(evt);
            }
        });
        jPDetalles1.add(jTIntegracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 47, -1, 25));

        jCIntegracion.setBackground(new java.awt.Color(255, 255, 255));
        jCIntegracion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCIntegracion.setForeground(new java.awt.Color(102, 102, 102));
        jCIntegracion.setText("Integración");
        jCIntegracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCIntegracionMouseClicked(evt);
            }
        });
        jPDetalles1.add(jCIntegracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 19, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(128, 128, 131));
        jLabel14.setText("¿Lleva antisolder?");
        jPDetalles1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(128, 128, 131));
        jLabel19.setText("¿Lleva ruteo?");
        jPDetalles1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        jCRuteoC.setBackground(new java.awt.Color(255, 255, 255));
        jCRuteoC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCRuteoC.setForeground(new java.awt.Color(102, 102, 102));
        jCRuteoC.setText("R");
        jCRuteoC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCRuteoCMousePressed(evt);
            }
        });
        jPDetalles1.add(jCRuteoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 135, -1, -1));

        jCAntisolderC.setBackground(new java.awt.Color(255, 255, 255));
        jCAntisolderC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCAntisolderC.setForeground(new java.awt.Color(102, 102, 102));
        jCAntisolderC.setText("A");
        jCAntisolderC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCAntisolderCMousePressed(evt);
            }
        });
        jPDetalles1.add(jCAntisolderC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 135, -1, -1));

        jCAntisolderP.setBackground(new java.awt.Color(255, 255, 255));
        jCAntisolderP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCAntisolderP.setForeground(new java.awt.Color(102, 102, 102));
        jCAntisolderP.setText("A");
        jCAntisolderP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCAntisolderPMousePressed(evt);
            }
        });
        jPDetalles1.add(jCAntisolderP, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 135, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 128, 131));
        jLabel11.setText("¿Lleva antisolder?");
        jPDetalles1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(128, 128, 131));
        jLabel16.setText("¿Lleva ruteo?");
        jPDetalles1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        jCRuteoP.setBackground(new java.awt.Color(255, 255, 255));
        jCRuteoP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCRuteoP.setForeground(new java.awt.Color(102, 102, 102));
        jCRuteoP.setText("R");
        jCRuteoP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jCRuteoPMousePressed(evt);
            }
        });
        jPDetalles1.add(jCRuteoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 135, -1, -1));

        jPanel2.add(jPDetalles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 820, 170));

        jPDetalles.setBackground(new java.awt.Color(255, 255, 255));
        jPDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Detalles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N

        jDentrega.setToolTipText("");
        jDentrega.setDateFormatString("dd/MM/yyyy");
        jDentrega.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDentrega.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDentregaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(128, 128, 131));
        jLabel10.setText("Fecha de entraga:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("*");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(128, 128, 131));
        jLabel18.setText("Fecha de ingreso:");

        cbNegocio.setForeground(new java.awt.Color(102, 102, 102));
        cbNegocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "FE", "TE", "IN", "FE/TE", "FE/IN", "FE/TE/IN" }));
        cbNegocio.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbNegocio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbNegocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNegocioItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setText("Negocio:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setText("*");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("*");

        cbTipo.setForeground(new java.awt.Color(102, 102, 102));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Normal", "RQT", "Quick" }));
        cbTipo.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(128, 128, 131));
        jLabel21.setText("Tipo de proyecto:");

        jLIngreso.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLIngreso.setForeground(new java.awt.Color(128, 128, 131));
        jLIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLIngreso.setText("DD-MM-YYYY");

        javax.swing.GroupLayout jPDetallesLayout = new javax.swing.GroupLayout(jPDetalles);
        jPDetalles.setLayout(jPDetallesLayout);
        jPDetallesLayout.setHorizontalGroup(
            jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addComponent(cbNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPDetallesLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPDetallesLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel18)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)))
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
        );
        jPDetallesLayout.setVerticalGroup(
            jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetallesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDentrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.add(jPDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 370, 180));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setLayout(null);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_Proyect.png"))); // NOI18N
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_prpyect_roll.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(btnNuevo);
        btnNuevo.setBounds(2, 2, 57, 45);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_proyect.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setFocusable(false);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save_roll.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGuardar);
        btnGuardar.setBounds(59, 0, 57, 45);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFocusable(false);
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_roll.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscar);
        btnBuscar.setBounds(118, 2, 57, 45);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btnUpdate.setBorderPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update1.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel5.add(btnUpdate);
        btnUpdate.setBounds(175, 2, 57, 45);

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
        jPanel5.add(btnDelete);
        btnDelete.setBounds(232, 0, 57, 45);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 292, 50));

        Notificacion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Notificacion1.setForeground(new java.awt.Color(128, 128, 131));
        Notificacion1.setText("Estado");
        jPanel2.add(Notificacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 90, 18));

        jLIDConversor.setText("0");
        jPanel2.add(jLIDConversor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 10, -1));

        jLIDTroquel.setText("0");
        jPanel2.add(jLIDTroquel, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 210, 10, -1));

        jLIDRepujado.setText("0");
        jPanel2.add(jLIDRepujado, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 210, 10, -1));

        jLIDStencil.setText("0");
        jPanel2.add(jLIDStencil, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 210, 10, -1));

        jLIDCircuito.setText("0");
        jPanel2.add(jLIDCircuito, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 210, 10, -1));

        jLIDPCB.setText("0");
        jPanel2.add(jLIDPCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 210, 10, -1));

        jLIDTeclado.setText("0");
        jPanel2.add(jLIDTeclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 210, 10, -1));

        jLIDIntegracion.setText("0");
        jPanel2.add(jLIDIntegracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 210, 10, -1));

        GenerarQR.setText("GenerarQR");
        GenerarQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarQRActionPerformed(evt);
            }
        });
        jPanel2.add(GenerarQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, -1, -1));

        jTProyectoQR.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTProyectoQR.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTProyectoQR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTProyectoQR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProyectoQRKeyTyped(evt);
            }
        });
        jPanel2.add(jTProyectoQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 230, 23));

        jButton1.setText("Cargar Excel");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        btnTomaTiempos.setText("Toma de tiempos");
        btnTomaTiempos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomaTiemposActionPerformed(evt);
            }
        });
        jPanel2.add(btnTomaTiempos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 150, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        btnGenerarExcel.setText("Reporte");
        btnGenerarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnGenerarExcel);

        btnGenerarPDF.setText("Reporte1");
        btnGenerarPDF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnGenerarPDF);

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 140, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addGap(10, 10, 10))
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        op = 1;
        activarComponentes();
        cambiarEstadoBotones();
        limpiarCampos();
        NumeroDeOrden();
        jTNorden.setEnabled(true);
        fecha();
        limpiarID();
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void limpiarID() {
        jLIDConversor.setText("0");
        jLIDRepujado.setText("0");
        jLIDTroquel.setText("0");
        jLIDStencil.setText("0");
        jLIDCircuito.setText("0");
        jLIDPCB.setText("0");
        jLIDTeclado.setText("0");
        jLIDIntegracion.setText("0");
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ConsutaProyecto obj = new ConsutaProyecto();
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int seleccion = JOptionPane.showOptionDialog(null, "Seguro desea modificar este proyecto",
                "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "SI");
        if (seleccion == 0) {
            validarRegistro(2);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Proyecto obj = new Proyecto();
        if (obj.validarNumerOrden(Integer.parseInt(jTNorden.getText()))) {//Se valida que la orden no exista
            new rojerusan.RSNotifyAnimated("¡Alerta!", "Este numero de orden ya existe.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
        } else {
            validarRegistro(1);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jCConversorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCConversorMouseClicked
        activarjTfilex(jCConversor, jTConversor);
    }//GEN-LAST:event_jCConversorMouseClicked

    private void jCTroquelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCTroquelMouseClicked
        activarjTfilex(jCTroquel, jTTroquel);
    }//GEN-LAST:event_jCTroquelMouseClicked

    private void jCRepujadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCRepujadoMouseClicked
        activarjTfilex(jCRepujado, jTRepujado);
    }//GEN-LAST:event_jCRepujadoMouseClicked

    private void jCStencilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCStencilMouseClicked
        activarjTfilex(jCStencil, jTStencil);
    }//GEN-LAST:event_jCStencilMouseClicked

    private void jCCircuitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCCircuitoMouseClicked
        activarjTfilex(jCCircuito, jTCircuito);
        if (jCCircuito.isSelected()) {
            cbMaterialCircuito.setEnabled(true);
            jCAntisolderC.setEnabled(true);
            jCRuteoC.setEnabled(true);
        } else {
            cbMaterialCircuito.setSelectedIndex(0);
            cbMaterialCircuito.setEnabled(false);
            jCAntisolderC.setEnabled(false);
            jCRuteoC.setEnabled(false);
            jCAntisolderC.setSelected(false);
            jCRuteoC.setSelected(false);
        }
    }//GEN-LAST:event_jCCircuitoMouseClicked

    private void jCPCBTEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCPCBTEMouseClicked
        activarjTfilex(jCPCBTE, jTPCBTE);
        if (jCPCBTE.isSelected()) {
            jCAntisolderP.setEnabled(true);
            jCRuteoP.setEnabled(true);
            cbMaterialPCBTE.setEnabled(true);
        } else {
            cbMaterialPCBTE.setSelectedIndex(0);
            jCAntisolderP.setEnabled(false);
            jCRuteoP.setEnabled(false);
            jCAntisolderP.setSelected(false);
            jCRuteoP.setSelected(false);
            cbMaterialPCBTE.setEnabled(false);
        }
    }//GEN-LAST:event_jCPCBTEMouseClicked

    private void jCTecladoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCTecladoMouseClicked
        activarjTfilex(jCTeclado, jTTeclado);
    }//GEN-LAST:event_jCTecladoMouseClicked

    private void jCIntegracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCIntegracionMouseClicked
        activarjTfilex(jCIntegracion, jTIntegracion);
    }//GEN-LAST:event_jCIntegracionMouseClicked

    private void jTNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyTyped
        validarCampos();
        char cara = evt.getKeyChar();
        if (Character.isDigit(cara) || evt.getKeyChar() == '.' || evt.getKeyChar() == '|') {
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreClienteKeyTyped

    private void jTNombreProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreProyectoKeyTyped
        validarCampos();
        char cara = evt.getKeyChar();
        if (Character.isDigit(cara) || evt.getKeyChar() == '.' || evt.getKeyChar() == '|') {
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreProyectoKeyTyped

    private void cbNegocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNegocioItemStateChanged
        if (cbNegocio.getSelectedIndex() != 0) {
            desactivarBotonesjC();
            if (cbNegocio.getSelectedItem().toString().equals("FE")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE"
                jCCircuito.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("TE")) {
                //Activa solo los jcheckbos necesarios para ese negocío "TE"
                jCTeclado.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("IN")) {
                //Activa solo los jcheckbos necesarios para ese negocío "IN"
                jCIntegracion.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("FE/TE")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE/TE"
                jCTeclado.setEnabled(true);
                jCCircuito.setEnabled(true);
                jCPCBTE.setEnabled(true);
                jCConversor.setEnabled(true);
                jCRepujado.setEnabled(true);
                jCTroquel.setEnabled(true);
                jCStencil.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("FE/IN")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE/IN"
                jCCircuito.setEnabled(true);
                jCStencil.setEnabled(true);
                jCIntegracion.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("FE/TE/IN")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE/TE/IN"
                jCTeclado.setEnabled(true);
                jCPCBTE.setEnabled(true);
                jCCircuito.setEnabled(true);
                jCConversor.setEnabled(true);
                jCRepujado.setEnabled(true);
                jCTroquel.setEnabled(true);
                jCStencil.setEnabled(true);
                jCIntegracion.setEnabled(true);
                jCIntegracion.setSelected(true);
            }
            jTConversor.setText("");
            jTTroquel.setText("");
            jTRepujado.setText("");
            jTStencil.setText("");
            jTCircuito.setText("");
            jTPCBTE.setText("");
            jTTeclado.setText("");
            jTIntegracion.setText("");
            cbMaterialCircuito.setEnabled(false);
            cbMaterialCircuito.setSelectedIndex(0);
            cbMaterialPCBTE.setEnabled(false);
            cbMaterialPCBTE.setSelectedIndex(0);
        } else {
            desactivarBotonesjC();
        }
    }//GEN-LAST:event_cbNegocioItemStateChanged

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
    }//GEN-LAST:event_cbTipoItemStateChanged

    private void jDentregaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDentregaCaretPositionChanged
    }//GEN-LAST:event_jDentregaCaretPositionChanged

    private void jCAntisolderPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCAntisolderPMousePressed
    }//GEN-LAST:event_jCAntisolderPMousePressed

    private void jCRuteoPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCRuteoPMousePressed
    }//GEN-LAST:event_jCRuteoPMousePressed

    private void jTConversorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTConversorKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTConversorKeyTyped

    private void jTTroquelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTroquelKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTTroquelKeyTyped

    private void jTRepujadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTRepujadoKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTRepujadoKeyTyped

    private void jTStencilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTStencilKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTStencilKeyTyped

    private void jTCircuitoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCircuitoKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTCircuitoKeyTyped

    private void jTPCBTEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPCBTEKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTPCBTEKeyTyped

    private void jTTecladoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTecladoKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTTecladoKeyTyped

    private void jTIntegracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTIntegracionKeyTyped
        numerosT(evt);
    }//GEN-LAST:event_jTIntegracionKeyTyped

    private void GenerarQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarQRActionPerformed
        generarQR();
    }//GEN-LAST:event_GenerarQRActionPerformed

    private void jCAntisolderCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCAntisolderCMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAntisolderCMousePressed

    private void jCRuteoCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCRuteoCMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCRuteoCMousePressed

    private void jTProyectoQRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProyectoQRKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProyectoQRKeyTyped

    private void btnTomaTiemposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomaTiemposActionPerformed
        Menu principal = new Menu();
        detalleProduccion obj = new detalleProduccion(principal, true, Integer.parseInt(jTNorden.getText()), 4, 4);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);

    }//GEN-LAST:event_btnTomaTiemposActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Proyecto obj = new Proyecto();
        if (obj.EliminarProyecto(Integer.parseInt(jTNorden.getText()))) {
            //Eliminación fue realizada correactamente.
            //Mensaje
            limpiarCampos();
            limpiarID();
            botonRegistrarModificar();
        } else {
            //Error al realizar la eliminación del proyecto.
            //Mensaje
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
//Metodos-------------------------------------------------------------------->

    private Paragraph tipoProyecto(int tipo, int negocio) {
        Paragraph tipoPrpyecto = new Paragraph();
        String tip = "", negoci = "";
        switch (negocio) {
            case 1:
                negoci = "FE";
                break;
            case 2:
                negoci = "TE";
                break;
            case 3:
                negoci = "IN";
                break;
            default:
                break;
        }

        switch (tipo) {
            case 1:
                tip = "Circuito";
                break;
            case 2:
                tip = "Conversor";
                break;
            case 3:
                tip = "Repujado";
                break;
            case 4:
                tip = "Troquel";
                break;
            case 5:
                tip = "Teclado";
                break;
            case 6:
                tip = "Stencil";
                break;
            case 7:
                tip = "PCB";
                break;
            default:
                break;
        }
        tipoPrpyecto.setFont(new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL));
        tipoPrpyecto.add(negoci + " - " + tip + "\n");
        tipoPrpyecto.setSpacingAfter(10);
        return tipoPrpyecto;
    }

    private void generarQR() {
        try {
            //Validar o crear carpeta
            File folder = new File("ImágenesQR");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File folderPDF = new File("PDF");
            if (!folderPDF.exists()) {
                folderPDF.mkdirs();
            }
            //Generar codigos QR
            //Informacion del QR desde la base de datos
            Controlador.Proyecto obj = new Controlador.Proyecto();
            CachedRowSet crs = obj.Consultar_informacion_para_el_QR(Integer.parseInt(jTNorden.getText()));

            //Tabla y encabezado
            PdfPTable tabla = new PdfPTable(3);
            PdfPCell header = new PdfPCell(new Paragraph("Orden numero: " + jTNorden.getText() + "\n"));
            Image logo = Image.getInstance("src\\imagenesEmpresa\\logo.png");
            logo.scaleAbsolute(300, 125);
            logo.setAlignment(Image.ALIGN_CENTER);

            header.setBorder(Rectangle.NO_BORDER);
            header.setColspan(3);
            tabla.addCell(header);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{3, 3, 3});
            //se creo y se abrio el documento
            Document doc = new Document(PageSize.A4, 20, 20, 30, 30);
            //se obtine la ruta del proyecto en tiempo de ejecucion.
            String ruta = System.getProperty("user.dir");
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(ruta + "\\PDF\\" + jTNorden.getText() + ".pdf"));
            doc.open();
            doc.add(logo);
            fecha();
            doc.add(new Paragraph("Generado: " + fecha));
            while (crs.next()) {
                //Creo la cadena de texto que contendra el QR
                QRCode cod = new QRCode();
                String texto = jTNorden.getText() + ';' + crs.getInt(1) + ';' + crs.getInt(3);
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
                cod.renderBarcode(ruta + "\\ImágenesQR\\" + texto + ".png");

                Image imagenQR = Image.getInstance(ruta + "\\ImágenesQR\\" + texto + ".png");
                imagenQR.setWidthPercentage(90);
                imagenQR.setAlignment(Image.ALIGN_CENTER);
                //Personalizar cell
                PdfPCell celda = new PdfPCell();
                celda.setBorder(Rectangle.NO_BORDER);
                celda.addElement(tipoProyecto(crs.getInt(2), crs.getInt(3)));
                celda.addElement(imagenQR);
                tabla.addCell(celda);

//                File QRdelet = new File(ruta + "\\ImágenesQR\\" + texto + ".png");
//                QRdelet.delete();
            }
            crs.close();
            header.setBorder(Rectangle.NO_BORDER);
            header.addElement(new Paragraph());
            header.setColspan(3);
            tabla.addCell(header);
            doc.add(tabla);
            doc.close();
//            Thread.sleep(7000);
            new rojerusan.RSNotifyAnimated("¡Listo!", "Los codigos QR de la orden N°" + jTNorden.getText() + " fueron generados exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    private void validarRegistro(int op) {
        //Validar los campos principales del proyecto-------------------------->
        if (jDentrega.getDate() != null && cbNegocio.getSelectedIndex() != 0 && cbTipo.getSelectedIndex() != 0 && !jTNombreCliente.getText().equals("")
                && !jTNombreProyecto.getText().equals("") && contarRadiosPresionados() == contarTextoLleno() && contarRadiosPresionados() > 0 && contarTextoLleno() > 0) {
            registrarModificarProyecto(op);
        } else {
            new rojerusan.RSNotifyAnimated("¡Error!", "Falta algun campo por diligenciar.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }

    public int contarRadiosPresionados() {
        int cant = 0;
        if (jCConversor.isSelected()) {
            cant++;
        }
        if (jCTroquel.isSelected()) {
            cant++;
        }
        if (jCRepujado.isSelected()) {
            cant++;
        }
        if (jCStencil.isSelected()) {
            cant++;
        }
        if (jCCircuito.isSelected()) {
            cant++;
        }
        if (jCPCBTE.isSelected()) {
            cant++;
        }
        if (jCTeclado.isSelected()) {
            cant++;
        }
        if (jCIntegracion.isSelected()) {
            cant++;
        }

        return cant;
    }

    public int contarTextoLleno() {
        int cant = 0;
        if (!jTConversor.getText().equals("")) {
            cant++;
        }
        if (!jTTroquel.getText().equals("")) {
            cant++;
        }
        if (!jTRepujado.getText().equals("")) {
            cant++;
        }
        if (!jTStencil.getText().equals("")) {
            cant++;
        }
        if (!jTCircuito.getText().equals("") && cbMaterialCircuito.getSelectedIndex() != 0) {
            cant++;
        }
        if (!jTPCBTE.getText().equals("") && cbMaterialPCBTE.getSelectedIndex() != 0) {
            cant++;
        }
        if (!jTTeclado.getText().equals("")) {
            cant++;
        }
        if (!jTIntegracion.getText().equals("")) {
            cant++;
        }
        return cant;
    }

    private void registrarModificarProyecto(int op) {
        if (op == 1) {
            //Para registrar no se tiene que validar los proyectos que no se pueden eliminar
            botonRegistrarModificar();
        } else if (op == 2) {
            //Validar que los detalles del proyecto puedan ser modificados o si no el proyecto no va a poder ser modificado de ninguna manera.
            String v[] = new String[8];
            int i = 0;
            boolean res = true;
            DetalleProyecto obj = new DetalleProyecto();

            if (!jLIDCircuito.getText().equals("0") && jCCircuito.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(1, Integer.parseInt(jTNorden.getText()), 1, 0, 1));
                i++;
            }
            if (!jLIDTeclado.getText().equals("0") && jCTeclado.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(2, Integer.parseInt(jTNorden.getText()), 5, 0, 1));
                i++;
            }
            if (!jLIDIntegracion.getText().equals("0") && jCIntegracion.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(3, Integer.parseInt(jTNorden.getText()), 1, 0, 1));
                i++;
            }
            if (!jLIDConversor.getText().equals("0") && jCConversor.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(1, Integer.parseInt(jTNorden.getText()), 2, 0, 1));
                i++;
            }
            if (!jLIDTroquel.getText().equals("0") && jCTroquel.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(1, Integer.parseInt(jTNorden.getText()), 4, 0, 1));
                i++;
            }
            if (!jLIDRepujado.getText().equals("0") && jCRepujado.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(1, Integer.parseInt(jTNorden.getText()), 3, 0, 1));
                i++;
            }
            if (!jLIDStencil.getText().equals("0") && jCStencil.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(1, Integer.parseInt(jTNorden.getText()), 6, 0, 1));
                i++;
            }
            if (!jLIDPCB.getText().equals("0") && jCPCBTE.isSelected() == false) {
                v[i] = String.valueOf(obj.validarEliminacionModificar(1, Integer.parseInt(jTNorden.getText()), 7, 0, 1));
                i++;
            }
            //Se verifica que todos los proyectos se puedan eliminar, incluso los pnc
            for (int j = 0; j < v.length; j++) {
                if (v[j] == null) {
                    break;
                } else {
                    if (v[j].equals("false")) {
                        res = false;
                        break;
                    }
                }
            }
            //si es true se podran eliminar todos los proyectos y podra seguir con la modificacion de la informacion del proyecto
            if (res) {
                botonRegistrarModificar();
            } else {
                new rojerusan.RSNotifyAnimated("¡Error!", "No se puede modificar este proyecto porque ya esta en ejecucion", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        }
    }

    private void botonRegistrarModificar() {
        Controlador.Proyecto obj = new Controlador.Proyecto();
        obj.setNombreCliente(jTNombreCliente.getText());
        obj.setNombreProyecto(jTNombreProyecto.getText());
        obj.setTipoProyecto(cbTipo.getSelectedItem().toString());
        obj.setNegocio(cbNegocio.getSelectedItem().toString());
        DateFormat fecha = new SimpleDateFormat("YYYY/MM/dd");
        obj.setFecha(fecha.format(jDentrega.getDate()));
        v[0] = jCCircuito.isSelected();
        v[1] = jCPCBTE.isSelected();
        v[2] = jCConversor.isSelected();
        v[3] = jCRepujado.isSelected();
        v[4] = jCTroquel.isSelected();
        v[5] = jCStencil.isSelected();
        v[6] = jCTeclado.isSelected();
        v[7] = jCRuteoC.isSelected();
        v[8] = jCAntisolderC.isSelected();
        v[9] = jCAntisolderP.isSelected();
        v[10] = jCRuteoP.isSelected();
//        v[10] = jCIntegracion.isSelected() ? true : false;
        obj.setDetalles(v);
        obj.setIdOrden(Integer.parseInt(jTNorden.getText()));
        if (obj.registrar_Modificar_Proyecto(Menu.jDocumento.getText(), op)) {
            if (op == 1) {
                //Registrar el proyecto
                if (RegistrarModificarDetalle(jTNorden.getText(), 1)) {
                    //Mensaje de exito
                    new rojerusan.RSNotifyAnimated("Listo!!", "El Proyecto con el numero de orden: " + jTNorden.getText() + " fue registrada exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    generarQR();
                    limpiarID();
                } else {
                    //Mensaje de error
                    new rojerusan.RSNotifyAnimated("¡Error!", "El detalle no pudo ser registrado satisfactoriamente", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            } else if (op == 2) {
                //Modificar el detalle del proyecto
                if (RegistrarModificarDetalle(jTNorden.getText(), 2)) {
                    //Mensaje de exito
                    new rojerusan.RSNotifyAnimated("Listo!!", "El Proyecto con el numero de orden: " + jTNorden.getText() + " fue modificado exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    GenerarQR.setEnabled(false);
                    limpiarID();
                } else {
                    //Mensaje de error
                }
            }
        } else {
            new rojerusan.RSNotifyAnimated("¡Error!", "El proyecto no pudo ser registrado.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
        System.gc();//Garbage collector
        limpiarCampos();
        cambiarEstadoFalso();
        cambiarEstadoBotones();
        btnNuevo.setEnabled(true);
    }

    private void cambiarEstadoFalso() {
        jPInformacion.setBackground(new Color(244, 244, 244));
        jPDetalles1.setBackground(new Color(244, 244, 244));
        jPDetalles.setBackground(new Color(244, 244, 244));
        jTNorden.setEnabled(false);
        jTNombreCliente.setEnabled(false);
        jTNombreProyecto.setEnabled(false);
        jDentrega.setEnabled(false);
        cbNegocio.setEnabled(false);
        cbTipo.setEnabled(false);
        jCAntisolderP.setEnabled(false);
        jCRuteoP.setEnabled(false);
        jCAntisolderC.setEnabled(false);
        jCRuteoC.setEnabled(false);
        jCConversor.setEnabled(false);
        jTConversor.setEnabled(false);
        jCTroquel.setEnabled(false);
        jTTroquel.setEnabled(false);
        jCRepujado.setEnabled(false);
        jTRepujado.setEnabled(false);
        jCStencil.setEnabled(false);
        jTStencil.setEnabled(false);
        jCCircuito.setEnabled(false);
        jTCircuito.setEnabled(false);
        jCPCBTE.setEnabled(false);
        jTPCBTE.setEnabled(false);
        cbMaterialCircuito.setEnabled(false);
        cbMaterialPCBTE.setEnabled(false);
        jCTeclado.setEnabled(false);
        jTTeclado.setEnabled(false);
        jCIntegracion.setEnabled(false);
        jTIntegracion.setEnabled(false);
    }

    private void cambiarEstadoBotones() {
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(false);
        GenerarQR.setEnabled(false);
    }

    private void desactivarBotonesjC() {
        jCAntisolderP.setEnabled(false);
        jCRuteoP.setEnabled(false);
        jCAntisolderC.setEnabled(false);
        jCRuteoC.setEnabled(false);
        jCConversor.setEnabled(false);
        jCTroquel.setEnabled(false);
        jCRepujado.setEnabled(false);
        jCStencil.setEnabled(false);
        jCCircuito.setEnabled(false);
        jCPCBTE.setEnabled(false);
        jCIntegracion.setEnabled(false);
        jCTeclado.setEnabled(false);
        jCAntisolderP.setSelected(false);
        jCRuteoP.setSelected(false);
        jCAntisolderC.setSelected(false);
        jCRuteoC.setSelected(false);
        jCConversor.setSelected(false);
        jCTroquel.setSelected(false);
        jCRepujado.setSelected(false);
        jCStencil.setSelected(false);
        jCCircuito.setSelected(false);
        jCPCBTE.setSelected(false);
        jCIntegracion.setSelected(false);
        jCTeclado.setSelected(false);
    }

    public void activarComponentes() {
        jTNombreCliente.setEnabled(true);
        jTNombreProyecto.setEnabled(true);
        jDentrega.setEnabled(true);
        cbNegocio.setEnabled(true);
        cbTipo.setEnabled(true);
        jTIntegracion.setEnabled(true);
        jPInformacion.setBackground(new Color(255, 255, 255));
        jPDetalles1.setBackground(new Color(255, 255, 255));
        jPDetalles.setBackground(new Color(255, 255, 255));
    }

    private void NumeroDeOrden() {
        Proyecto obj = new Proyecto();
        String numero = obj.consultarNumeroOrden();
        jTNorden.setText(numero);
    }

    private void activarjTfilex(JCheckBox cs, TextFieldRoundBackground tx) {
        if (cs.isSelected()) {
            tx.setEnabled(true);
            tx.setText("");
            tx.requestFocus();
        } else {
            tx.setEnabled(false);
            tx.setText("");
        }
    }

    private void validarCampos() {
        if (op == 1) {
            if (!jTNombreCliente.getText().equals("") && !jTNombreProyecto.getText().equals("")) {
                btnGuardar.setEnabled(true);
            } else {
                btnGuardar.setEnabled(false);
            }
        }
    }

    private void fecha() {
        Proyecto obj = new Proyecto();
        jLIngreso.setText(obj.fecha());
        fecha = jLIngreso.getText();
    }

    private void limpiarCampos() {
        Notificacion1.setVisible(false);
        jTNorden.setText("");
        jTNombreCliente.setText("");
        jTNombreProyecto.setText("");
        jDentrega.setCalendar(null);
        jLIngreso.setText("DD-MM-YYYY");
        cbNegocio.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
        jCRuteoP.setSelected(false);
        jCAntisolderP.setSelected(false);
        jCRuteoC.setSelected(false);
        jCAntisolderC.setSelected(false);
        jCConversor.setSelected(false);
        jCRepujado.setSelected(false);
        jCTroquel.setSelected(false);
        jCCircuito.setSelected(false);
        jCPCBTE.setSelected(false);
        jCTeclado.setSelected(false);
        jCStencil.setSelected(false);
        jTIntegracion.setText("");
        jTConversor.setText("");
        jTRepujado.setText("");
        jTTroquel.setText("");
        jTCircuito.setText("");
        jTPCBTE.setText("");
        jTTeclado.setText("");
        jTIntegracion.setText("");
        jTStencil.setText("");
        cbMaterialCircuito.setSelectedIndex(0);
        cbMaterialPCBTE.setSelectedIndex(0);
        cbMaterialCircuito.setEnabled(false);
        cbMaterialPCBTE.setEnabled(false);
    }

    private void VerificarQueSeElimina(DetalleProyecto obj) {
        if (!jLIDCircuito.getText().equals("0") && jCCircuito.isSelected() == false) {
            //Eliminar el detalle del proyecto si ya no esta seleccionado
            subEliminardetalle(obj, Integer.parseInt(jLIDCircuito.getText()), Integer.parseInt(jTNorden.getText()), "FE", "Circuito");
        }
        if (!jLIDTeclado.getText().equals("0") && jCTeclado.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDTeclado.getText()), Integer.parseInt(jTNorden.getText()), "TE", "Teclado");
        }
        if (!jLIDIntegracion.getText().equals("0") && jCIntegracion.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDIntegracion.getText()), Integer.parseInt(jTNorden.getText()), "IN", "Circuito");
        }
        if (!jLIDConversor.getText().equals("0") && jCConversor.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDConversor.getText()), Integer.parseInt(jTNorden.getText()), "FE", "Conversor");
        }
        if (!jLIDTroquel.getText().equals("0") && jCTroquel.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDTroquel.getText()), Integer.parseInt(jTNorden.getText()), "FE", "Troquel");
        }
        if (!jLIDRepujado.getText().equals("0") && jCRepujado.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDRepujado.getText()), Integer.parseInt(jTNorden.getText()), "FE", "Repujado");
        }
        if (!jLIDStencil.getText().equals("0") && jCStencil.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDStencil.getText()), Integer.parseInt(jTNorden.getText()), "FE", "Stencil");
        }
        if (!jLIDPCB.getText().equals("0") && jCPCBTE.isSelected() == false) {
            subEliminardetalle(obj, Integer.parseInt(jLIDPCB.getText()), Integer.parseInt(jTNorden.getText()), "FE", "PCB");
        }
    }

    private boolean RegistrarModificarDetalle(String numeroOrden, int op) {
        DetalleProyecto obj = new DetalleProyecto();
        boolean res = false;
        int op1 = 0;
        //Falta validar que antes de eliminar un su proyecto si se puede eliminar o no
        if (cbNegocio.getSelectedItem().equals("FE")) {
            //Se registra el detalle del proyecto con negocio "FE"
            if (jCCircuito.isSelected()) {
                //Registrar PCB de FE------------------------------------------>
                if (jLIDCircuito.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                if (jLIDCircuito.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB FE
            }
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("TE")) {
            //Se registra el detalle del proyecto con negocio "TE"
            if (jCTeclado.isSelected()) {
                //Registrar El teclado en TE------------------------------------------>
                if (jLIDTeclado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTeclado.getText(), "TE", "Teclado", numeroOrden, "Lexan", op, Integer.parseInt(jLIDTeclado.getText()));
                if (jLIDTeclado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB TE
            }
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("IN")) {
            //Se registra el detalle del proyecto cuando el negocio es "IN"
            if (jCIntegracion.isSelected()) {
                //Registrar la integracion en EN------------------------------------------>
                if (jLIDIntegracion.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTIntegracion.getText(), "IN", "Circuito", numeroOrden, "", op, Integer.parseInt(jLIDIntegracion.getText()));
                if (jLIDIntegracion.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del circuito IN
            }
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("FE/TE")) {
            //Se registra el detalle del proyecto cuando el negocio es "FE/TE"
            if (jCConversor.isSelected()) {
                //Registrar Conversor------------------------------------------>
                if (jLIDConversor.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTConversor.getText(), "FE", "Conversor", numeroOrden, "FV", op, Integer.parseInt(jLIDConversor.getText()));
                if (jLIDConversor.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Conversor
            }
            if (jCTroquel.isSelected()) {
                //Registrar Troquel-------------------------------------------->
                if (jLIDTroquel.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTroquel.getText(), "FE", "Troquel", numeroOrden, "FV", op, Integer.parseInt(jLIDTroquel.getText()));
                if (jLIDTroquel.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Troquel
            }
            if (jCRepujado.isSelected()) {
                //Registrar Repujado------------------------------------------->
                if (jLIDRepujado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTRepujado.getText(), "FE", "Repujado", numeroOrden, "FV", op, Integer.parseInt(jLIDRepujado.getText()));
                if (jLIDRepujado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Repujado
            }
            if (jCStencil.isSelected()) {
                //Registrar Stencil-------------------------------------------->
                if (jLIDStencil.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTStencil.getText(), "FE", "Stencil", numeroOrden, "", op, Integer.parseInt(jLIDStencil.getText()));
                if (jLIDStencil.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Stencil
            }
            if (jCCircuito.isSelected()) {
                //Registrar PCB de FE------------------------------------------>
                if (jLIDCircuito.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                if (jLIDCircuito.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB FE
            }
            if (jCPCBTE.isSelected()) {
                //Registrar PCB de TE------------------------------------------>
                if (jLIDPCB.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTPCBTE.getText(), "FE", "PCB", numeroOrden, cbMaterialPCBTE.getSelectedItem().toString(), op, Integer.parseInt(jLIDPCB.getText()));
                if (jLIDPCB.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB TE
            }
            if (jCTeclado.isSelected()) {
                //Registrar Teclado-------------------------------------------->
                if (jLIDTeclado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTeclado.getText(), "TE", "Teclado", numeroOrden, "Lexan", op, Integer.parseInt(jLIDTeclado.getText()));
                if (jLIDTeclado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Teclado
            }
            VerificarQueSeElimina(obj);
        } else if (cbNegocio.getSelectedItem().equals("FE/IN")) {
            //Se registra el detalle del proyecto cuando el negocio es "FE/IN"
            if (jCCircuito.isSelected()) {
                //Registrar PCB de FE------------------------------------------>
                if (jLIDCircuito.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                if (jLIDCircuito.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB FE
            }
            if (jCIntegracion.isSelected()) {
                //REgistrar Integracion---------------------------------------->
                if (jLIDIntegracion.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTIntegracion.getText(), "IN", "Circuito", numeroOrden, "", op, Integer.parseInt(jLIDIntegracion.getText()));
                if (jLIDIntegracion.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro de Integracion
            }
            if (jCStencil.isSelected()) {
                //Registrar Stencil-------------------------------------------->
                if (jLIDStencil.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTStencil.getText(), "FE", "Stencil", numeroOrden, "", op, Integer.parseInt(jLIDStencil.getText()));
                if (jLIDStencil.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Stencil
            }
            VerificarQueSeElimina(obj);
        } else if (cbNegocio.getSelectedItem().equals("FE/TE/IN")) {
            //Se registra el detalle del proyecto cuando el negocio es "FE/TE/IN"
            if (jCConversor.isSelected()) {
                //Registrar Conversor------------------------------------------>
                if (jLIDConversor.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTConversor.getText(), "FE", "Conversor", numeroOrden, "FV", op, Integer.parseInt(jLIDConversor.getText()));
                if (jLIDConversor.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Conversor
            }
            if (jCTroquel.isSelected()) {
                //Registrar Troquel-------------------------------------------->
                if (jLIDTroquel.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTroquel.getText(), "FE", "Troquel", numeroOrden, "FV", op, Integer.parseInt(jLIDTroquel.getText()));
                if (jLIDTroquel.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Troquel
            }
            if (jCRepujado.isSelected()) {
                //Registrar Repujado------------------------------------------->
                if (jLIDRepujado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTRepujado.getText(), "FE", "Repujado", numeroOrden, "FV", op, Integer.parseInt(jLIDRepujado.getText()));
                if (jLIDRepujado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Repujado
            }
            if (jCStencil.isSelected()) {
                //Registrar Stencil-------------------------------------------->
                if (jLIDStencil.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTStencil.getText(), "FE", "Stencil", numeroOrden, "", op, Integer.parseInt(jLIDStencil.getText()));
                if (jLIDStencil.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Stencil
            }
            if (jCCircuito.isSelected()) {
                //Registrar PCB de FE------------------------------------------>
                if (jLIDCircuito.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                if (jLIDCircuito.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB FE
            }
            if (jCPCBTE.isSelected()) {
                //Registrar PCB de TE------------------------------------------>
                if (jLIDPCB.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTPCBTE.getText(), "FE", "PCB", numeroOrden, cbMaterialPCBTE.getSelectedItem().toString(), op, Integer.parseInt(jLIDPCB.getText()));
                if (jLIDPCB.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB TE
            }
            if (jCTeclado.isSelected()) {
                //Registrar Teclado-------------------------------------------->
                if (jLIDTeclado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTeclado.getText(), "TE", "Teclado", numeroOrden, "lexan", op, Integer.parseInt(jLIDTeclado.getText()));
                if (jLIDTeclado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Teclado
            }
            if (jCIntegracion.isSelected()) {
                //Registrar Integracion---------------------------------------->
                if (jLIDIntegracion.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTIntegracion.getText(), "IN", "Circuito", numeroOrden, "", op, Integer.parseInt(jLIDIntegracion.getText()));
                if (jLIDIntegracion.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro de Integracion
            }
        }
        return res;
    }

    private boolean subRegistrarModificarProyecto(DetalleProyecto obj, String cantidad, String Negocio, String TipoNegocio, String numeroOrden, String material, int op, int id) {
        obj.setCantidad(cantidad);
        obj.setTipoNegocio(TipoNegocio);
        obj.setNegocio(Negocio);
        obj.setMaterial(material);
        return obj.registrar_Detalle_Proycto(numeroOrden, op, id);
    }

    private void subEliminardetalle(DetalleProyecto obj, int idDetalle, int numerOrden, String negocio, String tipo) {

        if (obj.eliminarDetallersProyecto(idDetalle, numerOrden, negocio, tipo, 1)) {//Eliminación por la modificación
            //Mensaje de eliminacion exitosa
            new rojerusan.RSNotifyAnimated("Listo!!", "Se elimino el detalle del proyecto: " + tipo + " " + negocio + " de la orden " + jTNorden.getText(), 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        } else {
            //Mensaje de la eliminacion no se pudo realizar por que ya comenzo su ejecucion
            new rojerusan.RSNotifyAnimated("Listo!!", "el detalle " + tipo + " " + negocio + " de la orden" + jTNorden.getText() + " no pudo ser eliminada porque ya esta en ejecución.", 5, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }

    private void numerosT(java.awt.event.KeyEvent evt) {
        char cara = evt.getKeyChar();
        if (Character.isLetter(cara) || evt.getKeyChar() == '.' || evt.getKeyChar() == '|') {
            evt.consume();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static elaprendiz.gui.button.ButtonColoredAction GenerarQR;
    public static javax.swing.JLabel Notificacion1;
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGenerarExcel;
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    public static elaprendiz.gui.button.ButtonColoredAction btnTomaTiempos;
    public static javax.swing.JButton btnUpdate;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbMaterialCircuito;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbMaterialPCBTE;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbNegocio;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbTipo;
    private javax.swing.JButton jButton1;
    public static javax.swing.JCheckBox jCAntisolderC;
    public static javax.swing.JCheckBox jCAntisolderP;
    public static javax.swing.JCheckBox jCCircuito;
    public static javax.swing.JCheckBox jCConversor;
    public static javax.swing.JCheckBox jCIntegracion;
    public static javax.swing.JCheckBox jCPCBTE;
    public static javax.swing.JCheckBox jCRepujado;
    public static javax.swing.JCheckBox jCRuteoC;
    public static javax.swing.JCheckBox jCRuteoP;
    public static javax.swing.JCheckBox jCStencil;
    public static javax.swing.JCheckBox jCTeclado;
    public static javax.swing.JCheckBox jCTroquel;
    public static com.toedter.calendar.JDateChooser jDentrega;
    public static javax.swing.JLabel jLIDCircuito;
    public static javax.swing.JLabel jLIDConversor;
    public static javax.swing.JLabel jLIDIntegracion;
    public static javax.swing.JLabel jLIDPCB;
    public static javax.swing.JLabel jLIDRepujado;
    public static javax.swing.JLabel jLIDStencil;
    public static javax.swing.JLabel jLIDTeclado;
    public static javax.swing.JLabel jLIDTroquel;
    public static javax.swing.JLabel jLIngreso;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPDetalles;
    public static javax.swing.JPanel jPDetalles1;
    public static javax.swing.JPanel jPInformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTCircuito;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTConversor;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTIntegracion;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNombreCliente;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNombreProyecto;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNorden;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTPCBTE;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTProyectoQR;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTRepujado;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTStencil;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTTeclado;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTTroquel;
    // End of variables declaration//GEN-END:variables
@Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
