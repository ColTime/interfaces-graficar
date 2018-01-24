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
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Scanner;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

public class proyecto extends javax.swing.JPanel implements Runnable {

    public proyecto(int p) {
        if (p == 1) {
            initComponents();
            cambiarEstadoFalso();
            cambiarEstadoBotones();
            Notificacion1.setVisible(false);
            GenerarQR.setEnabled(false);
            btnTomaTiempos.setVisible(false);
            visibilidadID();//Pendiente para realizar mañana!
            limites();
            jREjecucion.setEnabled(false);
            jRParada.setEnabled(false);
            ocultarFechas();
            jTNovedades.setVisible(false);
            jLNovedades.setVisible(false);
            jScrollPane1.setVisible(false);
            jTNovedades.setLineWrap(true);
        }
        op = p;
        limpiarCampos();
        //---------------------------------------
    }
    //Variables e instancias
    static int op = 0;
    static int componentes = 0;
    boolean v[] = new boolean[12];
    int udm = 0, resol = 100, rot = 0;
    float mi = 0.000f, md = 0.000f, ms = 0.000f, min = 0.000f, tam = 21.000f;
    static String fecha = "";
    int opmaterial = 1;
    int modificacion = 0;
    int puertoProyecto = 0;
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private CommPort puerto = null;

    private void visibilidadID() {
        jLIDConversor.setVisible(false);
        jLIDTroquel.setVisible(false);
        jLIDRepujado.setVisible(false);
        jLIDStencil.setVisible(false);
        jLIDCircuito.setVisible(false);
        jLIDPCB.setVisible(false);
        jLIDTeclado.setVisible(false);
        jLIDIntegracion.setVisible(false);
        //Identificadores de productos de almacen
        jLIDCircuitoGF.setVisible(false);//ID del Circuito Cuando es GF
        jLIDCircuitoCOM.setVisible(false);//ID de los componenetes del circuito
        jLIDPCBGF.setVisible(false);//ID de la PCB cuando es GF
        jLIDPCBCOM.setVisible(false);//ID de los componentes del circuito
        jLMaterialPCB.setVisible(false);
        jLMaterialCircuito.setVisible(false);
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
        obj8.setLimit(150);
        RestrictedTextField obj9 = new RestrictedTextField(jTNombreProyecto);
        obj9.setLimit(150);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ParadasOEjecucion = new javax.swing.ButtonGroup();
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
        jLCircuitoGF = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCRuteoC = new javax.swing.JCheckBox();
        jCAntisolderC = new javax.swing.JCheckBox();
        jCAntisolderP = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCRuteoP = new javax.swing.JCheckBox();
        jDFechaEntregaFE = new com.toedter.calendar.JDateChooser();
        jDFechaEntregaFECOM = new com.toedter.calendar.JDateChooser();
        jDFechaEntregaPCBGF = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLCircuitoFE = new javax.swing.JLabel();
        jLComCircuitos = new javax.swing.JLabel();
        jRPCBCOM = new javax.swing.JRadioButton();
        jDFechaEntregaPCBCOMGF = new com.toedter.calendar.JDateChooser();
        jLpcbGF = new javax.swing.JLabel();
        jLIDCircuitoGF = new javax.swing.JLabel();
        jLIDCircuitoCOM = new javax.swing.JLabel();
        jLIDPCBCOM = new javax.swing.JLabel();
        jLIDPCBGF = new javax.swing.JLabel();
        jRPIntegracion = new javax.swing.JRadioButton();
        jLIDPCBEN = new javax.swing.JLabel();
        jLMaterialPCB = new javax.swing.JLabel();
        jLMaterialCircuito = new javax.swing.JLabel();
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
        jRParada = new javax.swing.JRadioButton();
        jREjecucion = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
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
        btnTomaTiempos = new elaprendiz.gui.button.ButtonColoredAction();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNovedades = new javax.swing.JTextArea();
        jLNovedades = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreClienteKeyReleased(evt);
            }
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreProyectoKeyReleased(evt);
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
        jCTeclado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTecladoActionPerformed(evt);
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
        jCConversor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCConversorActionPerformed(evt);
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
        jCRepujado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCRepujadoActionPerformed(evt);
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
        jCTroquel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTroquelActionPerformed(evt);
            }
        });
        jPDetalles1.add(jCTroquel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 19, 80, -1));

        jCCircuito.setBackground(new java.awt.Color(255, 255, 255));
        jCCircuito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCCircuito.setForeground(new java.awt.Color(102, 102, 102));
        jCCircuito.setText("Circuito-FE");
        jCCircuito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCircuitoActionPerformed(evt);
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
        jCPCBTE.setText("PCB-TE");
        jCPCBTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPCBTEActionPerformed(evt);
            }
        });
        jPDetalles1.add(jCPCBTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 19, -1, -1));

        jCStencil.setBackground(new java.awt.Color(255, 255, 255));
        jCStencil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCStencil.setForeground(new java.awt.Color(102, 102, 102));
        jCStencil.setText("Stencil");
        jCStencil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCStencilActionPerformed(evt);
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
        cbMaterialCircuito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "TH", "FV", "GF" }));
        cbMaterialCircuito.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbMaterialCircuito.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbMaterialCircuito.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaterialCircuitoItemStateChanged(evt);
            }
        });
        jPDetalles1.add(cbMaterialCircuito, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 92, 150, 25));

        cbMaterialPCBTE.setForeground(new java.awt.Color(102, 102, 102));
        cbMaterialPCBTE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "TH", "FV", "GF" }));
        cbMaterialPCBTE.setColorDeBorde(new java.awt.Color(204, 204, 204));
        cbMaterialPCBTE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbMaterialPCBTE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMaterialPCBTEItemStateChanged(evt);
            }
        });
        jPDetalles1.add(cbMaterialPCBTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 92, 150, 25));

        jTIntegracion.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTIntegracion.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTIntegracion.setDescripcion(".");
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
        jCIntegracion.setText("Ensamble");
        jCIntegracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCIntegracionActionPerformed(evt);
            }
        });
        jPDetalles1.add(jCIntegracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 19, -1, -1));

        jLCircuitoGF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCircuitoGF.setForeground(new java.awt.Color(128, 128, 131));
        jLCircuitoGF.setText("Fecha de entrega PCB GF");
        jPDetalles1.add(jLCircuitoGF, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

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

        jDFechaEntregaFE.setToolTipText("");
        jDFechaEntregaFE.setDateFormatString("dd/MM/yyyy");
        jDFechaEntregaFE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDFechaEntregaFE.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDFechaEntregaFECaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPDetalles1.add(jDFechaEntregaFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 140, -1));

        jDFechaEntregaFECOM.setToolTipText("");
        jDFechaEntregaFECOM.setDateFormatString("dd/MM/yyyy");
        jDFechaEntregaFECOM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDFechaEntregaFECOM.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDFechaEntregaFECOMCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPDetalles1.add(jDFechaEntregaFECOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 130, 20));

        jDFechaEntregaPCBGF.setToolTipText("");
        jDFechaEntregaPCBGF.setDateFormatString("dd/MM/yyyy");
        jDFechaEntregaPCBGF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDFechaEntregaPCBGF.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDFechaEntregaPCBGFCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPDetalles1.add(jDFechaEntregaPCBGF, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 130, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(128, 128, 131));
        jLabel24.setText("¿Lleva antisolder?");
        jPDetalles1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLCircuitoFE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLCircuitoFE.setForeground(new java.awt.Color(128, 128, 131));
        jLCircuitoFE.setText("Fecha de entrega FE Circuito");
        jPDetalles1.add(jLCircuitoFE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLComCircuitos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLComCircuitos.setForeground(new java.awt.Color(128, 128, 131));
        jLComCircuitos.setText("Fecha de entrega COM Circuito");
        jPDetalles1.add(jLComCircuitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jRPCBCOM.setText("COM");
        jRPCBCOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRPCBCOMActionPerformed(evt);
            }
        });
        jPDetalles1.add(jRPCBCOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, -1, 20));

        jDFechaEntregaPCBCOMGF.setToolTipText("");
        jDFechaEntregaPCBCOMGF.setDateFormatString("dd/MM/yyyy");
        jDFechaEntregaPCBCOMGF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDFechaEntregaPCBCOMGF.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDFechaEntregaPCBCOMGFCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPDetalles1.add(jDFechaEntregaPCBCOMGF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 130, -1));

        jLpcbGF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLpcbGF.setForeground(new java.awt.Color(128, 128, 131));
        jLpcbGF.setText("Fecha de entrega COM GF");
        jPDetalles1.add(jLpcbGF, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, -1));

        jLIDCircuitoGF.setText("0");
        jPDetalles1.add(jLIDCircuitoGF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 10, -1));

        jLIDCircuitoCOM.setText("0");
        jPDetalles1.add(jLIDCircuitoCOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 10, -1));

        jLIDPCBCOM.setText("0");
        jPDetalles1.add(jLIDPCBCOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 10, -1));

        jLIDPCBGF.setText("0");
        jPDetalles1.add(jLIDPCBGF, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 10, -1));

        jRPIntegracion.setText("IN");
        jRPIntegracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRPIntegracionActionPerformed(evt);
            }
        });
        jPDetalles1.add(jRPIntegracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 50, 20));

        jLIDPCBEN.setText("0");
        jPDetalles1.add(jLIDPCBEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 10, -1));

        jLMaterialPCB.setText("M");
        jPDetalles1.add(jLMaterialPCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, -1, -1));

        jLMaterialCircuito.setText("M");
        jPDetalles1.add(jLMaterialCircuito, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        jPanel2.add(jPDetalles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 820, 222));

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
        cbNegocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "FE", "TE", "EN", "FE/TE", "FE/EN", "FE/TE/EN" }));
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

        jRParada.setBackground(new java.awt.Color(255, 255, 255));
        ParadasOEjecucion.add(jRParada);
        jRParada.setText("Parada");
        jRParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRParadaActionPerformed(evt);
            }
        });

        jREjecucion.setBackground(new java.awt.Color(255, 255, 255));
        ParadasOEjecucion.add(jREjecucion);
        jREjecucion.setText("Ejecucion");
        jREjecucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jREjecucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDetallesLayout = new javax.swing.GroupLayout(jPDetalles);
        jPDetalles.setLayout(jPDetallesLayout);
        jPDetallesLayout.setHorizontalGroup(
            jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDetallesLayout.createSequentialGroup()
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDetallesLayout.createSequentialGroup()
                        .addComponent(jLIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jDentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDetallesLayout.createSequentialGroup()
                        .addComponent(cbNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPDetallesLayout.createSequentialGroup()
                                .addComponent(jREjecucion)
                                .addGap(8, 8, 8)
                                .addComponent(jRParada))
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))))
        );
        jPDetallesLayout.setVerticalGroup(
            jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDetallesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPDetallesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jREjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRParada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
        btnUpdate.setBounds(175, 2, 60, 45);

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
        btnDelete.setBounds(232, 0, 58, 49);

        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chek-user.png"))); // NOI18N
        btnActivar.setBorderPainted(false);
        btnActivar.setContentAreaFilled(false);
        btnActivar.setFocusPainted(false);
        btnActivar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chek-user1.png"))); // NOI18N
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        jPanel5.add(btnActivar);
        btnActivar.setBounds(230, 0, 60, 50);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 292, 50));

        Notificacion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Notificacion1.setForeground(new java.awt.Color(128, 128, 131));
        Notificacion1.setText("Estado");
        jPanel2.add(Notificacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 90, 20));

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
        jPanel2.add(GenerarQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, -1, -1));

        btnTomaTiempos.setText("Toma de tiempos");
        btnTomaTiempos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomaTiemposActionPerformed(evt);
            }
        });
        jPanel2.add(btnTomaTiempos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 150, -1));

        jTNovedades.setColumns(20);
        jTNovedades.setRows(5);
        jTNovedades.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTNovedades);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 290, 150));

        jLNovedades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLNovedades.setForeground(new java.awt.Color(128, 128, 131));
        jLNovedades.setText("Novedades:");
        jPanel2.add(jLNovedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(189, 189, 189));
        jLabel14.setText("Colcircuitos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        ocultarFechas();
        Thread QRProyecto = new Thread(this);
        QRProyecto.start();
    }//GEN-LAST:event_btnNuevoActionPerformed
    @Override
    public void run() {
        String valor = proyectoQR();
        if (puertoProyecto == 1) {
            puertoProyecto = 0;
            llenarCamporProyecto(valor);
        } else {
            //No se pudo establecer la conexión con el puerto COM, desea cambiarlo o volver a intentar? 
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con el puerto COM");
        }
    }

    private String proyectoQR() {
        String valor = "";
        int op = 0;
        try {
            Enumeration commports = CommPortIdentifier.getPortIdentifiers();//Enumeracion de todos los puertos.
            CommPortIdentifier myCPI = null;
            Scanner mySC;
            while (commports.hasMoreElements()) {
                myCPI = (CommPortIdentifier) commports.nextElement();
                if (myCPI.getName().equals("COM4")) {//Localización del puerto 
                    puertoProyecto = 1;
                    puerto = myCPI.open("Puerto serial Proyecto", 100);//Apertura y nombre del puerto
                    SerialPort mySP = (SerialPort) puerto;
                    //Configuracion del puerto
                    mySP.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    //
                    mySC = new Scanner(mySP.getInputStream());//Datos de entrada al puerto
                    while (!mySC.hasNext()) {//Valida la informacion que va a ingresar!!
                        mySC.close();
                        mySC = null;
                        mySC = new Scanner(mySP.getInputStream());
                    }
                    valor = mySC.next();
                    puerto.close();
                }
            }
        } catch (Exception e) {
            //Error al leer por el puerto serial.
            puerto.close();
        }
        return valor;
    }

    private void limpiarID() {
        jLIDConversor.setText("0");
        jLIDRepujado.setText("0");
        jLIDTroquel.setText("0");
        jLIDStencil.setText("0");
        jLIDCircuito.setText("0");
        jLIDPCB.setText("0");
        jLIDTeclado.setText("0");
        jLIDIntegracion.setText("0");
        jLIDPCBGF.setText("0");
        jLIDPCBCOM.setText("0");
        jLIDCircuitoGF.setText("0");
        jLIDCircuitoCOM.setText("0");
        jLMaterialPCB.setText("M");
        jLMaterialCircuito.setText("M");
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
        puerto.close();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jTNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyTyped
        char cara = evt.getKeyChar();
        if (Character.isDigit(cara) || evt.getKeyChar() == '|') {
            evt.consume();
        }
    }//GEN-LAST:event_jTNombreClienteKeyTyped

    private void cbNegocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNegocioItemStateChanged
        if (cbNegocio.getSelectedIndex() != 0) {
            desactivarBotonesjC();
            if (cbNegocio.getSelectedItem().toString().equals("FE")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE"
                jCCircuito.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("TE")) {
                //Activa solo los jcheckbos necesarios para ese negocío "TE"
                jCTeclado.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("EN")) {
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
            } else if (cbNegocio.getSelectedItem().toString().equals("FE/EN")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE/IN"
                jCCircuito.setEnabled(true);
                jCStencil.setEnabled(true);
                jCIntegracion.setEnabled(true);
            } else if (cbNegocio.getSelectedItem().toString().equals("FE/TE/EN")) {
                //Activa solo los jcheckbos necesarios para ese negocío "FE/TE/IN"
                jCTeclado.setEnabled(true);
                jCPCBTE.setEnabled(true);
                jCCircuito.setEnabled(true);
                jCConversor.setEnabled(true);
                jCRepujado.setEnabled(true);
                jCTroquel.setEnabled(true);
                jCStencil.setEnabled(true);
                jCIntegracion.setEnabled(true);
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
            ocultarFechas();
            jRPCBCOM.setEnabled(false);
            jRPIntegracion.setEnabled(false);
            jRPCBCOM.setSelected(false);
            jRPIntegracion.setSelected(false);
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

    private void btnTomaTiemposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTomaTiemposActionPerformed
        Menu principal = new Menu();
        detalleProduccion obj = new detalleProduccion(principal, true, Integer.parseInt(jTNorden.getText()), 4, 4);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
    }//GEN-LAST:event_btnTomaTiemposActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showOptionDialog(null, "¿Seguro desea eliminar este proyecto?",
                "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "SI") == 0) {
            Proyecto obj = new Proyecto();
            if (obj.EliminarProyecto(Integer.parseInt(jTNorden.getText()))) {
                //Eliminación fue realizada correactamente.
                //Mensaje
                new rojerusan.RSNotifyAnimated("Listo.", "El proyecto con la orden " + jTNorden.getText() + " fue eliminada exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                limpiarCampos();
                limpiarID();
                cambiarEstadoBotones();
                cambiarEstadoFalso();
            } else {
                //Error al realizar la eliminación del proyecto.
                //Mensaje
                new rojerusan.RSNotifyAnimated("¡Alerta!", "El proyecto no pudo ser eliminado correctamente, por favor intentalo de nuevo.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        if (JOptionPane.showOptionDialog(null, "¿Seguro desea reactivar este proyecto?",
                "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "SI") == 0) {
            Proyecto obj = new Proyecto();
            if (obj.ReacttivarProyecto(Integer.parseInt(jTNorden.getText()))) {
                //Eliminación fue realizada correactamente.
                //Mensaje
                new rojerusan.RSNotifyAnimated("Listo.", "El proyecto con la orden " + jTNorden.getText() + " fue reactivado coreectamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                limpiarCampos();
                limpiarID();
                cambiarEstadoBotones();
                cambiarEstadoFalso();
            } else {
                //Error al realizar la eliminación del proyecto.
                //Mensaje
                new rojerusan.RSNotifyAnimated("¡Alerta!", "El proyecto no pudo ser reactivado correctamente, por favor intentalo de nuevo.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    public void llenarCamporProyecto(String QRProyecto) {
        //Registro de proyecto mediante lectura de codigo QR (Actual)
        //29359;Micro Hom Cali S.A.S;Control Planta;FE;Normal;15/01/2018;null;null;null;null;25;TH;SI;SI;null;null;NO;NO;null;null;null;null;null;null;null;null
        String nombreCliente = "";
        try {
            String InformacionProyecto[] = QRProyecto.split(";");
            if (InformacionProyecto.length == 26) {
                jTNorden.setText(InformacionProyecto[0]);//Numero de orden
                String infoC[] = InformacionProyecto[1].split("-");
                for (int i = 0; i < infoC.length; i++) {
                    nombreCliente += infoC[i] + " ";
                }
                jTNombreCliente.setText(nombreCliente);//Nombre del cliente
                nombreCliente = "";
                String infoP[] = InformacionProyecto[2].split("-");
                for (int i = 0; i < infoP.length; i++) {
                    nombreCliente += infoP[i] + " ";
                }
                jTNombreProyecto.setText(nombreCliente);//Nombre del proyecto
                cbNegocio.setSelectedItem(InformacionProyecto[3]);//Negocios implicados
                cbTipo.setSelectedItem(InformacionProyecto[4]);//Tipo de proyecto
                jDentrega.setDate(formato.parse(InformacionProyecto[5]));//Fecha de entrega al cliente
                if (!InformacionProyecto[6].equals("null")) {//Conversor
                    jCConversor.setSelected(true);
                    jTConversor.setText(InformacionProyecto[6]);
                    jTConversor.setEnabled(true);
                }
                if (!InformacionProyecto[7].equals("null")) {//Troquel
                    jCTroquel.setSelected(true);
                    jTTroquel.setText(InformacionProyecto[7]);
                    jTTroquel.setEnabled(true);
                }
                if (!InformacionProyecto[8].equals("null")) {//Repujado
                    jCRepujado.setSelected(true);
                    jTRepujado.setText(InformacionProyecto[8]);
                    jTRepujado.setEnabled(true);
                }
                if (!InformacionProyecto[9].equals("null")) {//Stencil
                    jCStencil.setSelected(true);
                    jTStencil.setText(InformacionProyecto[9]);
                    jTStencil.setEnabled(true);
                }
                if (!InformacionProyecto[10].equals("null")) {//Circuito de FE
                    jCCircuito.setSelected(true);
                    jTCircuito.setText(InformacionProyecto[10]);
                    jTCircuito.setEnabled(true);
                    cbMaterialCircuito.setSelectedItem(InformacionProyecto[11]);
                    cbMaterialCircuito.setEnabled(true);
                    jCAntisolderC.setSelected(InformacionProyecto[12].toUpperCase().equals("SI"));
                    jCRuteoC.setSelected(InformacionProyecto[13].toUpperCase().equals("SI"));
                }
                if (!InformacionProyecto[14].equals("null")) {//PCB TE
                    jCPCBTE.setSelected(true);
                    jTPCBTE.setText(InformacionProyecto[14]);
                    jTPCBTE.setEnabled(true);
                    cbMaterialPCBTE.setSelectedItem(InformacionProyecto[15]);
                    cbMaterialPCBTE.setEnabled(true);
                    jCAntisolderP.setSelected(InformacionProyecto[16].toUpperCase().equals("SI"));
                    jCRuteoP.setSelected(InformacionProyecto[17].toUpperCase().equals("SI"));
                    jRPCBCOM.setSelected(InformacionProyecto[18].toUpperCase().equals("SI"));
                    jRPCBCOM.setEnabled(true);
                    jRPIntegracion.setSelected(InformacionProyecto[19].toUpperCase().equals("SI"));
                    jRPIntegracion.setEnabled(true);
                    if (jRPCBCOM.isSelected()) {//Componentes de la PCB del teclado
                        jDFechaEntregaPCBCOMGF.setVisible(true);
                        if (!InformacionProyecto[25].equals("null")) {
                            jDFechaEntregaPCBCOMGF.setDate(formato.parse(InformacionProyecto[25]));//Fecha de entrega de componentes de la PCB_TE:
                        }
                        jLpcbGF.setVisible(true);
                    }
                    if (jRPIntegracion.isSelected()) {//Integración de la PCB del teclado 
                        jDFechaEntregaPCBGF.setVisible(true);
                        if (!InformacionProyecto[24].equals("null")) {
                            jDFechaEntregaPCBGF.setDate(formato.parse(InformacionProyecto[24]));//Fecha de entrega de la PCB_TE(TH,FV,GF):
                        }
                        jLCircuitoGF.setVisible(true);
                    }
                }
                if (!InformacionProyecto[20].equals("null")) {//Teclado
                    jCTeclado.setSelected(true);
                    jTTeclado.setText(InformacionProyecto[20]);
                    jTTeclado.setEnabled(true);
                }
                if (!InformacionProyecto[21].equals("null")) {//Ensamble
                    jCIntegracion.setSelected(true);
                    jTIntegracion.setText(InformacionProyecto[21]);
                    jTIntegracion.setEnabled(true);
                }
                if (jCCircuito.isSelected() && jCIntegracion.isSelected()) {//Esto se le conoce como integración.
                    jLComCircuitos.setVisible(true);
                    if (!InformacionProyecto[23].equals("null")) {
                        jDFechaEntregaFECOM.setDate(formato.parse(InformacionProyecto[23]));//Fecha de entrega de los componentes del circuito_FE:
                    }
                    jDFechaEntregaFECOM.setVisible(true);
                    jLCircuitoFE.setVisible(true);
                    if (!InformacionProyecto[22].equals("null")) {
                        jDFechaEntregaFE.setDate(formato.parse(InformacionProyecto[22]));//Fecha de entrega del Circuito_FE(TH,FV,GF) a ensamble:
                    }
                    jDFechaEntregaFE.setVisible(true);
                }
                if (jTNombreCliente.getText().length() > 0 && jTNombreProyecto.getText().length() > 0 && jDentrega.getDate() != null && !cbNegocio.getSelectedItem().toString().equals("Seleccione...")
                        && !cbTipo.getSelectedItem().toString().equals("Seleccione...")) {
                    btnGuardar.setEnabled(true);
                }
            } else {
                //Mensaje...
                //Al QR del proyecto le falta información para poder realizar el registro
                new rojerusan.RSNotifyAnimated("¡Alerta!", "El código QR esta mal estructurado.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        //Fin de la lectura del Código QR del proyecto.
    }

    private void jCConversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCConversorActionPerformed
        activarjTfilex(jCConversor, jTConversor);
    }//GEN-LAST:event_jCConversorActionPerformed

    private void jCTroquelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTroquelActionPerformed
        activarjTfilex(jCTroquel, jTTroquel);
    }//GEN-LAST:event_jCTroquelActionPerformed

    private void jCRepujadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCRepujadoActionPerformed
        activarjTfilex(jCRepujado, jTRepujado);
    }//GEN-LAST:event_jCRepujadoActionPerformed

    private void jCStencilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCStencilActionPerformed
        activarjTfilex(jCStencil, jTStencil);
    }//GEN-LAST:event_jCStencilActionPerformed

    private void jCCircuitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCircuitoActionPerformed
        activarjTfilex(jCCircuito, jTCircuito);
        if (jCCircuito.isSelected()) {
            cbMaterialCircuito.setEnabled(true);
            jCAntisolderC.setEnabled(true);
            jCRuteoC.setEnabled(true);
//            if (jCIntegracion.isSelected()) {
//                jDFechaEntregaFE.setEnabled(true);
//            } else {
//                jDFechaEntregaFE.setEnabled(false);
//            }
        } else {
            cbMaterialCircuito.setEnabled(false);
            jCAntisolderC.setEnabled(false);
            jCRuteoC.setEnabled(false);
        }
        //Validacion para saber si lleva otras fechas de control.
        fechaEntregaFEoGF();
    }//GEN-LAST:event_jCCircuitoActionPerformed

    private void jCPCBTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPCBTEActionPerformed
        activarjTfilex(jCPCBTE, jTPCBTE);
        if (jCPCBTE.isSelected()) {
            cbMaterialPCBTE.setEnabled(true);
            jCAntisolderP.setEnabled(true);
            jCRuteoP.setEnabled(true);
//            jRPCBCOM.setEnabled(true);
//            jRPIntegracion.setEnabled(true);
        } else {
            cbMaterialPCBTE.setEnabled(false);
            cbMaterialPCBTE.setSelectedIndex(0);
            jCAntisolderP.setEnabled(false);
            jCRuteoP.setEnabled(false);
            jRPCBCOM.setEnabled(false);
            jRPIntegracion.setEnabled(false);
            jRPCBCOM.setSelected(false);
            jRPIntegracion.setSelected(false);
            jDFechaEntregaPCBGF.setDate(null);
            jDFechaEntregaPCBGF.setVisible(false);
            jLCircuitoGF.setVisible(false);
            jDFechaEntregaPCBCOMGF.setDate(null);
            jDFechaEntregaPCBCOMGF.setVisible(false);
            jLpcbGF.setVisible(false);
        }
    }//GEN-LAST:event_jCPCBTEActionPerformed

    private void jCTecladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTecladoActionPerformed
        activarjTfilex(jCTeclado, jTTeclado);
    }//GEN-LAST:event_jCTecladoActionPerformed

    private void jCIntegracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCIntegracionActionPerformed
        activarjTfilex(jCIntegracion, jTIntegracion);
        if (jCCircuito.isSelected() && jCIntegracion.isSelected()) {
            jDFechaEntregaFECOM.setEnabled(true);
        } else {
            jDFechaEntregaFECOM.setEnabled(false);
        }
        //Validacion para saber si lleva otras fechas de control.
        fechaEntregaFEoGF();
    }//GEN-LAST:event_jCIntegracionActionPerformed

    private void jDFechaEntregaFECaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaEntregaFECaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jDFechaEntregaFECaretPositionChanged

    private void jDFechaEntregaFECOMCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaEntregaFECOMCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jDFechaEntregaFECOMCaretPositionChanged

    private void jDFechaEntregaPCBGFCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaEntregaPCBGFCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jDFechaEntregaPCBGFCaretPositionChanged

    private void jRParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRParadaActionPerformed
        ejecucionOParada(0);
    }//GEN-LAST:event_jRParadaActionPerformed

    private void jREjecucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jREjecucionActionPerformed
        ejecucionOParada(1);
    }//GEN-LAST:event_jREjecucionActionPerformed

    private void cbMaterialCircuitoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaterialCircuitoItemStateChanged
        //Necesito controlar esto
        if (cbMaterialCircuito.getSelectedIndex() == 3 || cbMaterialCircuito.getSelectedIndex() == 0) {//Gran formato
            jCAntisolderC.setEnabled(false);
            jCAntisolderC.setSelected(false);
            jCRuteoC.setEnabled(false);
            jCRuteoC.setSelected(false);
//            if (jCIntegracion.isSelected()) {
//                jDFechaEntregaPCBGF.setEnabled(true);
//            } else {
//                jDFechaEntregaFE.setEnabled(false);
//            }
        } else {
            jCAntisolderC.setEnabled(true);
            jCRuteoC.setEnabled(true);
        }

        fechaEntregaFEoGF();


    }//GEN-LAST:event_cbMaterialCircuitoItemStateChanged

    private void cbMaterialPCBTEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMaterialPCBTEItemStateChanged
        if (cbMaterialPCBTE.getSelectedIndex() != 0) {
            if (cbMaterialPCBTE.getSelectedIndex() == 3) {
                jCAntisolderP.setEnabled(false);
                jCAntisolderP.setSelected(false);
                jCRuteoP.setEnabled(false);
                jCRuteoP.setSelected(false);
            } else {
                jCAntisolderP.setEnabled(true);
                jCRuteoP.setEnabled(true);
            }
            jRPCBCOM.setEnabled(true);
            jRPIntegracion.setEnabled(true);
        } else {
            jRPCBCOM.setEnabled(false);
            jRPIntegracion.setEnabled(false);
        }
    }//GEN-LAST:event_cbMaterialPCBTEItemStateChanged

    private void jDFechaEntregaPCBCOMGFCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaEntregaPCBCOMGFCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jDFechaEntregaPCBCOMGFCaretPositionChanged

    private void jRPCBCOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRPCBCOMActionPerformed

        if (jRPCBCOM.isSelected()) {
            if (cbMaterialPCBTE.getSelectedItem().toString().equals("TH") || cbMaterialPCBTE.getSelectedItem().toString().equals("FV")) {
                jLpcbGF.setText("Fecha de entrega COM PCB FE");
            } else if (cbMaterialPCBTE.getSelectedItem().toString().equals("GF")) {
                jLpcbGF.setText("Fecha de entrega COM PCB GF");
            }
            jLpcbGF.setVisible(true);
            jDFechaEntregaPCBCOMGF.setVisible(true);
        } else {
            jLpcbGF.setVisible(false);
            jDFechaEntregaPCBCOMGF.setVisible(false);
            jDFechaEntregaPCBCOMGF.setDate(null);
        }
    }//GEN-LAST:event_jRPCBCOMActionPerformed

    private void jRPIntegracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRPIntegracionActionPerformed
        if (jRPIntegracion.isSelected()) {
            if (cbMaterialPCBTE.getSelectedItem().toString().equals("TH") || cbMaterialPCBTE.getSelectedItem().toString().equals("FV")) {
                jLCircuitoGF.setText("Fecha de entrega PCB FE");
            } else if (cbMaterialPCBTE.getSelectedItem().toString().equals("GF")) {
                jLCircuitoGF.setText("Fecha de entrega PCB GF");
            }
            jLCircuitoGF.setVisible(true);
            jDFechaEntregaPCBGF.setVisible(true);
        } else {
            jLCircuitoGF.setVisible(false);
            jDFechaEntregaPCBGF.setVisible(false);
            jDFechaEntregaPCBGF.setDate(null);
        }
    }//GEN-LAST:event_jRPIntegracionActionPerformed

    private void jTNombreProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreProyectoKeyReleased
        validarCampos();
    }//GEN-LAST:event_jTNombreProyectoKeyReleased

    private void jTNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyReleased
        validarCampos();
    }//GEN-LAST:event_jTNombreClienteKeyReleased
//Metodos-------------------------------------------------------------------->

    private void ejecucionOParada(int op) {
        int seleccion = JOptionPane.showOptionDialog(null, (op == 1) ? "¿Seguro desea poner en ejecucion este numero de orden?" : "¿Seguro desea parar este numero de orden?",
                "seleccione...", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,// null para icono por defecto.
                new Object[]{"SI", "NO"}, "SI");
        if (seleccion == 0) {
            if (estadoProyecto()) {
                if (estadoDeOrden(op)) {
                    //Mensaje de cambio de estado todo un exito.
                    new rojerusan.RSNotifyAnimated("Listo!", "El estado del proyecto fue cambiado exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    limpiarCampos();
                    limpiarID();
                    cambiarEstadoFalso();
                    cambiarEstadoBotones();
                }
            } else {
                new rojerusan.RSNotifyAnimated("Alerta!", "No se puede cambiar el estado del proyecto porque esta en ejecución.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
            }
        } else {
            if (op == 1) {//No esta parada
                jRParada.setSelected(true);
            } else {//esta parada
                jREjecucion.setSelected(true);
            }
        }
    }

    private boolean estadoProyecto() {
        Proyecto obj = new Proyecto();
        return obj.estadoProyecto(Integer.parseInt(jTNorden.getText()));
    }

    private boolean estadoDeOrden(int estado) {
        Proyecto obj = new Proyecto();
        return obj.estadoDeOrden(Integer.parseInt(jTNorden.getText()), estado);
    }

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

    public void fechaEntregaFEoGF() {
        if (jCIntegracion.isSelected() && jCCircuito.isSelected()) {
            if (cbMaterialCircuito.getSelectedItem().toString().equals("TH") || cbMaterialCircuito.getSelectedItem().toString().equals("FV")) {
                //Se activa la fecha de entrega de FE para ensamble
                jLCircuitoFE.setText("Fecha de entrega FE Circuito");
                jLCircuitoFE.setVisible(true);
                jDFechaEntregaFE.setVisible(true);
            } else if (cbMaterialCircuito.getSelectedItem().toString().equals("GF")) {
                jLCircuitoFE.setText("Fecha de entrega GF Circuito");
                jLCircuitoFE.setVisible(true);
                jDFechaEntregaFE.setVisible(true);
            }
            jLComCircuitos.setVisible(true);
            jDFechaEntregaFECOM.setVisible(true);
        } else {
            jLComCircuitos.setVisible(false);
            jDFechaEntregaFECOM.setVisible(false);
            jDFechaEntregaFECOM.setDate(null);
            jLCircuitoFE.setVisible(false);
            jDFechaEntregaFE.setVisible(false);
            jDFechaEntregaFE.setDate(null);
        }
    }

    private void ocultarFechas() {
        //1
        jLCircuitoFE.setVisible(false);
        jDFechaEntregaFE.setVisible(false);
        //2
        jLComCircuitos.setVisible(false);
        jDFechaEntregaFECOM.setVisible(false);
        //3
        jLCircuitoGF.setVisible(false);
        jDFechaEntregaPCBGF.setVisible(false);
        //4
        jLpcbGF.setVisible(false);
        jDFechaEntregaPCBCOMGF.setVisible(false);
    }

    private void generarQR() {
        try {
            int cont = 0;
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
            //Informacion del QR desde la base de datos
            Controlador.Proyecto obj = new Controlador.Proyecto();
            CachedRowSet crs = obj.Consultar_informacion_para_el_QR(Integer.parseInt(jTNorden.getText()));
            while (crs.next()) {
                //Creo la cadena de texto que contendra el QR
                if (crs.getInt(3) != 4) {
                    QRCode cod = new QRCode();
                    //Numero de orden         //Detalle             //Negocio 
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
                    cont++;
                }
            }
            crs.close();
            header.setBorder(Rectangle.NO_BORDER);
            header.addElement(new Paragraph());
            header.setColspan(3);
            tabla.addCell(header);
            doc.add(tabla);
            doc.close();
            if (cont == 0) {
                File PDF = new File(ruta + "\\PDF\\" + jTNorden.getText() + ".pdf");
                PDF.delete();
            } else {
                new rojerusan.RSNotifyAnimated("¡Listo!", "Los codigos QR de la orden N°" + jTNorden.getText() + " fueron generados exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
            }
//            Thread.sleep(7000);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    private void validarRegistro(int op) {
        //Validar los campos principales del proyecto-------------------------->
        if (jDentrega.getDate() != null && cbNegocio.getSelectedIndex() != 0 && cbTipo.getSelectedIndex() != 0 && !jTNombreCliente.getText().equals("")
                && !jTNombreProyecto.getText().equals("") && contarRadiosPresionados() == contarTextoLleno() && contarRadiosPresionados() > 0 && contarTextoLleno() > 0 && validarFechaEntregaSiguienteProceso() && validarFechaEntregaPCB()) {
            //Ten en cuenta que se tiene que validar cuando se vaya a modificar estos mismos campos para saber si se elimina las fechas o no se eliminan.
            registrarModificarProyecto(op);
        } else {
            new rojerusan.RSNotifyAnimated("¡Error!", "Falta algun campo por diligenciar.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
        }
    }

    private boolean validarFechaEntregaSiguienteProceso() {//Este metodo valida los campos de fecha para evitar que esten vacios
        boolean respuesta = true;
        if (jCCircuito.isSelected() && jCIntegracion.isSelected()) {
            if (jDFechaEntregaFECOM.getDate() != null && jDFechaEntregaFE.getDate() != null) {
                respuesta = true;
            } else {
                respuesta = false;
            }
        }
        return respuesta;
    }

    private boolean validarFechaEntregaPCB() {
        boolean respues = true;
        if (jCPCBTE.isSelected()) {
            if (jRPIntegracion.isSelected() && jCPCBTE.isSelected()) {
                if (jDFechaEntregaPCBCOMGF.getDate() != null && jDFechaEntregaPCBGF.getDate() != null) {
                    respues = true;
                } else {
                    respues = false;
                }
            } else if (jRPIntegracion.isSelected()) {
                if (jDFechaEntregaPCBGF.getDate() != null) {
                    respues = true;
                } else {
                    respues = false;
                }
            } else if (jRPCBCOM.isSelected()) {
                if (jDFechaEntregaPCBCOMGF.getDate() != null) {
                    respues = true;
                } else {
                    respues = false;
                }
            }
        }
        return respues;
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
            //|| jCCircuito.isSelected() == true
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
                //Se modificara solo la información filtraria y el detalle
                new rojerusan.RSNotifyAnimated("¡Error!", "No se puede modificar el detalle de este proyecto porque ya esta en ejecución.", 8, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                Controlador.Proyecto procet = new Controlador.Proyecto();
                modificarInfoProyecto(procet);
                if (procet.registrar_Modificar_Proyecto(Menu.jDocumento.getText(), 2)) {//El dos es para poder modificar solo la informacion del proyecto
                    new rojerusan.RSNotifyAnimated("Listo!!", "La informacion filtraria del proyecto con el numero de orden: " + jTNorden.getText() + " fue modificado exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                    limpiarID();
                    limpiarCampos();
                    cambiarEstadoFalso();
                    cambiarEstadoBotones();
                    btnNuevo.setEnabled(true);
                } else {
                    new rojerusan.RSNotifyAnimated("Error!", "La informacion filtraria del proyecto con el numero de orden: " + jTNorden.getText() + " no pudo ser modificado exitosamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                }
            }
        }
    }

    private void modificarInfoProyecto(Controlador.Proyecto obj) {
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
        obj.setNovedadProyecto(jTNovedades.getText());//Novedade que se puedan presentar en el proyecto (Solo se registraran las novedades cuando se modifique un proyecto)
        //Fechas para el control de tiempos de entrega
        if (jDFechaEntregaFE.getDate() != null) {//Fecha de entrega de Circuito de FE a EN
            obj.setFechaCiccuitoFEoGF(fecha.format(jDFechaEntregaFE.getDate()));
        } else {
            obj.setFechaCiccuitoFEoGF(null);
        }
        if (jDFechaEntregaFECOM.getDate() != null) {//Fecha de entrega de los componentes del circuito (sea suministrados por la empresa o el cliente)
            obj.setFechaCiccuitoCOMFEoGF(fecha.format(jDFechaEntregaFECOM.getDate()));
        } else {
            obj.setFechaCiccuitoCOMFEoGF(null);
        }
        if (jDFechaEntregaPCBGF.getDate() != null) {//Fecha de la PCB del teclado a EN
            obj.setFechaPCBFEoGF(fecha.format(jDFechaEntregaPCBGF.getDate()));
        } else {
            obj.setFechaPCBFEoGF(null);
        }
        if (jDFechaEntregaPCBCOMGF.getDate() != null) {//Fecha de los componentes de la PCB (sea suministrados por la empresa o el cliente)
            obj.setFechaPCBCOMFEoGF(fecha.format(jDFechaEntregaPCBCOMGF.getDate()));
        } else {
            obj.setFechaPCBCOMFEoGF(null);
        }
    }

    private void botonRegistrarModificar() {
        Controlador.Proyecto obj = new Controlador.Proyecto();
        modificarInfoProyecto(obj);
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
                    new rojerusan.RSNotifyAnimated("¡Error!", "El detalle no pudo ser modificado satisfactoriamente", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
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
        jREjecucion.setEnabled(false);
        jRParada.setEnabled(false);
        jRPCBCOM.setEnabled(false);
        jRPIntegracion.setEnabled(false);
    }

    private void cambiarEstadoBotones() {
        btnActivar.setVisible(false);
        btnActivar.setEnabled(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(true);
        btnUpdate.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        GenerarQR.setEnabled(false);
        btnTomaTiempos.setVisible(false);
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
        jREjecucion.setEnabled(false);
        jRParada.setEnabled(false);
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
        jTIntegracion.setText(" ");
        jTConversor.setText(" ");
        jTRepujado.setText(" ");
        jTTroquel.setText(" ");
        jTCircuito.setText(" ");
        jTPCBTE.setText(" ");
        jTTeclado.setText(" ");
        jTIntegracion.setText(" ");
        jTStencil.setText(" ");
        cbMaterialCircuito.setSelectedIndex(0);
        cbMaterialPCBTE.setSelectedIndex(0);
        cbMaterialCircuito.setEnabled(false);
        cbMaterialPCBTE.setEnabled(false);
        jTIntegracion.setEditable(true);
        jTConversor.setEditable(true);
        jTRepujado.setEditable(true);
        jTTroquel.setEditable(true);
        jTCircuito.setEditable(true);
        jTPCBTE.setEditable(true);
        jTTeclado.setEditable(true);
        jTIntegracion.setEditable(true);
        jTStencil.setEditable(true);
        jTNovedades.setVisible(false);
        jScrollPane1.setVisible(false);
        jTNovedades.setText("");
    }

    private void VerificarQueSeElimina(DetalleProyecto obj) {//Falata la eliminacion Cuando se presenta una integración
        if (!jLIDCircuito.getText().equals("0") && jCCircuito.isSelected() == false) {
            //Eliminar el detalle del proyecto si ya no esta seleccionado
            subEliminardetalle(obj, Integer.parseInt(jLIDCircuito.getText()), Integer.parseInt(jTNorden.getText()), "FE", "Circuito");
        }
        if (!jLIDCircuito.getText().equals("0") && (jLMaterialCircuito.getText().equals("GF") || cbMaterialCircuito.getSelectedItem().toString().equals("GF"))) {//Probelmas al saber que variable de material de utiliza pra le elminacion
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
        if (!jLIDPCB.getText().equals("0") && jLMaterialPCB.getText().equals("GF")) {
            subEliminardetalle(obj, Integer.parseInt(jLIDPCB.getText()), Integer.parseInt(jTNorden.getText()), "FE", "PCB");
        }
        if (!jLIDPCB.getText().equals("0") && (jLMaterialPCB.getText().equals("TH") || jLMaterialPCB.getText().equals("FV")) && cbMaterialPCBTE.getSelectedItem().toString().equals("GF")) {
            subEliminardetalle(obj, Integer.parseInt(jLIDPCB.getText()), Integer.parseInt(jTNorden.getText()), "FE", "PCB");
        }
        if (jCCircuito.isSelected()) {
            if (!jLIDCircuitoGF.getText().equals("0") && (cbMaterialCircuito.getSelectedItem().toString().equals("TH") || cbMaterialCircuito.getSelectedItem().toString().equals("FV"))) {
                //Se eliminara el gran formato y se registrara la otra forma de circuito.
                subEliminardetalle(obj, Integer.parseInt(jLIDCircuito.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "Circuito GF");
            }
        } else {
            if (!jLIDCircuitoGF.getText().equals("0") && jLMaterialCircuito.getText().equals("GF")) {
                //Se eliminara el gran formato y se registrara la otra forma de circuito.
                subEliminardetalle(obj, Integer.parseInt(jLIDCircuito.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "Circuito GF");
            }
        }
        if (!jLIDPCBGF.getText().equals("0") && jLMaterialPCB.getText().equals("GF") && !jLMaterialPCB.getText().equals(cbMaterialPCBTE.getSelectedItem().toString())) {
            //Se eliminara el gran formato y se registrara la otra forma de circuito.
            subEliminardetalle(obj, Integer.parseInt(jLIDPCBGF.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "PCB GF");
        }
        if (jRPCBCOM.isSelected() == false && !jLIDPCBCOM.getText().equals("0")) {
            subEliminardetalle(obj, Integer.parseInt(jLIDPCBCOM.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "PCB COM");
        }
        if ((jCCircuito.isSelected() == false || jCIntegracion.isSelected() == false) && !jLIDCircuitoCOM.getText().equals("0")) {
            subEliminardetalle(obj, Integer.parseInt(jLIDCircuitoCOM.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "Circuito COM");
        }
        //Eliminación de toda la información si los check-box no estan seleccionados.
        if (!jCPCBTE.isSelected() && jLMaterialPCB.getText().equals("GF")) {
            if (!jLIDPCBGF.getText().equals("0")) {
                subEliminardetalle(obj, Integer.parseInt(jLIDPCBGF.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "PCB GF");
            }
            if (!jLIDPCBCOM.getText().equals("0")) {
                subEliminardetalle(obj, Integer.parseInt(jLIDPCBCOM.getText()), Integer.parseInt(jTNorden.getText()), "ALMACEN", "PCB COM");
            }
        }
    }

    private boolean RegistrarModificarDetalle(String numeroOrden, int op) {
        DetalleProyecto obj = new DetalleProyecto();
        boolean res = false;
        int op1 = 0;
        //Falta validar que antes de eliminar un su proyecto si se puede eliminar o no
        if (cbNegocio.getSelectedItem().equals("FE")) {///////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Se registra el detalle del proyecto con negocio "FE"
            if (jCCircuito.isSelected()) {
                //Registrar Circuito de FE------------------------------------------>
                if (cbMaterialCircuito.getSelectedIndex() == 3) {
                    //Registro de circuito GF al almacen
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuitoGF.getText()));
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op = op1;
                    }
                } else {
                    //Refitro de Circuito FE a formato estandar
                    if (jLIDCircuito.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                    if (jLIDCircuito.getText().equals("0")) {
                        op = op1;
                    }
                }
                //Fin del registro del Circuito FE
            }
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("TE")) {////////////////////////////////////////////////////////////////////////////////////////////////////
            //Se registra el detalle del proyecto con negocio "TE"
            if (jCTeclado.isSelected()) {
                //Registrar El teclado en TE------------------------------------------>
                if (jLIDTeclado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTeclado.getText(), "TE", "Teclado", numeroOrden, "", op, Integer.parseInt(jLIDTeclado.getText()));
                if (jLIDTeclado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del PCB TE
            }
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("EN")) {///////////////////////////////////////////////////////////////////////////////////////////////////
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
        } else if (cbNegocio.getSelectedItem().equals("FE/TE")) {//////////////////////////////////////////////////////////////////////////////////////////////
            //Se registra el detalle del proyecto cuando el negocio es "FE/TE"
            //Registro de componentes de la PCB del teclado.
            if (jCPCBTE.isSelected() && jRPCBCOM.isSelected() && jLIDPCBCOM.getText().equals("0")) {
                op1 = op;
                op = 1;
                res = subRegistrarModificarProyecto(obj, "", "ALMACEN", "PCB COM", numeroOrden, "", op, Integer.parseInt(jLIDCircuitoCOM.getText()));
                op = op1;
            }

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
                if (cbMaterialCircuito.getSelectedIndex() == 3) {
                    //Registro de circuito GF al almacen
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuitoGF.getText()));
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op = op1;
                    }
                } else {
                    if (jLIDCircuito.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                    if (jLIDCircuito.getText().equals("0")) {
                        op = op1;
                    }
                }
                //Fin del registro del PCB FE
            }
            if (jCPCBTE.isSelected()) {
                //Registrar PCB de TE------------------------------------------>
                if (cbMaterialPCBTE.getSelectedIndex() == 3) {
                    if (jLIDPCBGF.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTPCBTE.getText(), "FE", "PCB", numeroOrden, cbMaterialPCBTE.getSelectedItem().toString(), op, Integer.parseInt(jLIDPCBGF.getText()));
                    if (jLIDPCBGF.getText().equals("0")) {
                        op = op1;
                    }
                } else {
                    if (jLIDPCB.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTPCBTE.getText(), "FE", "PCB", numeroOrden, cbMaterialPCBTE.getSelectedItem().toString(), op, Integer.parseInt(jLIDPCB.getText()));
                    if (jLIDPCB.getText().equals("0")) {
                        op = op1;
                    }
                }
                //Fin del registro del PCB TE
            }
            if (jCTeclado.isSelected()) {
                //Registrar Teclado-------------------------------------------->
                if (jLIDTeclado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTeclado.getText(), "TE", "Teclado", numeroOrden, "", op, Integer.parseInt(jLIDTeclado.getText()));
                if (jLIDTeclado.getText().equals("0")) {
                    op = op1;
                }
                //Fin del registro del Teclado
            }
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("FE/EN")) {//////////////////////////////////////////////////////////////////////////////////////////
            //Se registra el detalle del proyecto cuando el negocio es "FE/IN"
            //Registro de componentes Circuito COM
            if (jCCircuito.isSelected() && jCIntegracion.isSelected() && jLIDCircuitoCOM.getText().equals("0")) {
                op1 = op;
                op = 1;
                res = subRegistrarModificarProyecto(obj, "", "ALMACEN", "Circuito COM", numeroOrden, "", op, Integer.parseInt(jLIDCircuitoCOM.getText()));
                op = op1;
            }
            //Registro de componentes PCB COM
            if (jCPCBTE.isSelected() && jRPCBCOM.isSelected() && jLIDPCBCOM.getText().equals("0")) {
                op1 = op;
                op = 1;
                res = subRegistrarModificarProyecto(obj, "", "ALMACEN", "PCB COM", numeroOrden, "", op, Integer.parseInt(jLIDCircuitoCOM.getText()));
                op = op1;
            }
            //Registro de componentes
            if (jCCircuito.isSelected()) {
                //Registrar Circuito de FE------------------------------------------>             
                if (cbMaterialCircuito.getSelectedIndex() == 3) {
                    //Registro de circuito GF al almacen
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuitoGF.getText()));
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op = op1;
                    }
                    //Fine del registro de Circuito GF al almacen
                } else {
                    //Registro de circuito FE
                    if (jLIDCircuito.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                    if (jLIDCircuito.getText().equals("0")) {
                        op = op1;
                    }
                    //Fin del registro
                }
                //Fin del registro del Circuito FE
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
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        } else if (cbNegocio.getSelectedItem().equals("FE/TE/EN")) {//////////////////////////////////////////////////////////////////////////////////////////////
            //Se registra el detalle del proyecto cuando el negocio es "FE/TE/IN"
            //Registro de componentes Circuito COM
            if (jCCircuito.isSelected() && jCIntegracion.isSelected() && jLIDCircuitoCOM.getText().equals("0")) {
                op1 = op;
                op = 1;
                res = subRegistrarModificarProyecto(obj, "", "ALMACEN", "Circuito COM", numeroOrden, "", op, Integer.parseInt(jLIDCircuitoCOM.getText()));
                op = op1;
            }
            //Registro de componentes PCB COM
            if (jCPCBTE.isSelected() && jRPCBCOM.isSelected() && jLIDPCBCOM.getText().equals("0")) {
                op1 = op;
                op = 1;
                res = subRegistrarModificarProyecto(obj, "", "ALMACEN", "PCB COM", numeroOrden, "", op, Integer.parseInt(jLIDCircuitoCOM.getText()));
                op = op1;
            }
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
                if (cbMaterialCircuito.getSelectedIndex() == 3) {
                    //Registro de circuito GF al almacen
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuitoGF.getText()));
                    if (jLIDCircuitoGF.getText().equals("0")) {
                        op = op1;
                    }
                } else {
                    if (jLIDCircuito.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTCircuito.getText(), "FE", "Circuito", numeroOrden, cbMaterialCircuito.getSelectedItem().toString(), op, Integer.parseInt(jLIDCircuito.getText()));
                    if (jLIDCircuito.getText().equals("0")) {
                        op = op1;
                    }
                }
                //Fin del registro del PCB FE
            }
            if (jCPCBTE.isSelected()) {
                //Registrar PCB de TE------------------------------------------>
                if (cbMaterialPCBTE.getSelectedIndex() == 3) {
                    if (jLIDPCBGF.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTPCBTE.getText(), "FE", "PCB", numeroOrden, cbMaterialPCBTE.getSelectedItem().toString(), op, Integer.parseInt(jLIDPCBGF.getText()));
                    if (jLIDPCBGF.getText().equals("0")) {
                        op = op1;
                    }
                } else {
                    if (jLIDPCB.getText().equals("0")) {
                        op1 = op;
                        op = 1;
                    }
                    res = subRegistrarModificarProyecto(obj, jTPCBTE.getText(), "FE", "PCB", numeroOrden, cbMaterialPCBTE.getSelectedItem().toString(), op, Integer.parseInt(jLIDPCB.getText()));
                    if (jLIDPCB.getText().equals("0")) {
                        op = op1;
                    }
                }
                //Fin del registro del PCB TE
            }
            if (jCTeclado.isSelected()) {
                //Registrar Teclado-------------------------------------------->
                if (jLIDTeclado.getText().equals("0")) {
                    op1 = op;
                    op = 1;
                }
                res = subRegistrarModificarProyecto(obj, jTTeclado.getText(), "TE", "Teclado", numeroOrden, "", op, Integer.parseInt(jLIDTeclado.getText()));
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
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
            VerificarQueSeElimina(obj);
            //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
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
            //Mensaje de la eliminacion no se pudo realizar por que ya comenzo su ejecucion (Esto solo se pone por seguridad) de resto no va a funcionar
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
    private javax.swing.ButtonGroup ParadasOEjecucion;
    public static javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    public static elaprendiz.gui.button.ButtonColoredAction btnTomaTiempos;
    public static javax.swing.JButton btnUpdate;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbMaterialCircuito;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbMaterialPCBTE;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbNegocio;
    public static elaprendiz.gui.comboBox.ComboBoxRound cbTipo;
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
    public static com.toedter.calendar.JDateChooser jDFechaEntregaFE;
    public static com.toedter.calendar.JDateChooser jDFechaEntregaFECOM;
    public static com.toedter.calendar.JDateChooser jDFechaEntregaPCBCOMGF;
    public static com.toedter.calendar.JDateChooser jDFechaEntregaPCBGF;
    public static com.toedter.calendar.JDateChooser jDentrega;
    public static javax.swing.JLabel jLCircuitoFE;
    public static javax.swing.JLabel jLCircuitoGF;
    public static javax.swing.JLabel jLComCircuitos;
    public static javax.swing.JLabel jLIDCircuito;
    public static javax.swing.JLabel jLIDCircuitoCOM;
    public static javax.swing.JLabel jLIDCircuitoGF;
    public static javax.swing.JLabel jLIDConversor;
    public static javax.swing.JLabel jLIDIntegracion;
    public static javax.swing.JLabel jLIDPCB;
    public static javax.swing.JLabel jLIDPCBCOM;
    public static javax.swing.JLabel jLIDPCBEN;
    public static javax.swing.JLabel jLIDPCBGF;
    public static javax.swing.JLabel jLIDRepujado;
    public static javax.swing.JLabel jLIDStencil;
    public static javax.swing.JLabel jLIDTeclado;
    public static javax.swing.JLabel jLIDTroquel;
    public static javax.swing.JLabel jLIngreso;
    public static javax.swing.JLabel jLMaterialCircuito;
    public static javax.swing.JLabel jLMaterialPCB;
    public static javax.swing.JLabel jLNovedades;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLpcbGF;
    public static javax.swing.JPanel jPDetalles;
    public static javax.swing.JPanel jPDetalles1;
    public static javax.swing.JPanel jPInformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JRadioButton jREjecucion;
    public static javax.swing.JRadioButton jRPCBCOM;
    public static javax.swing.JRadioButton jRPIntegracion;
    public static javax.swing.JRadioButton jRParada;
    public static javax.swing.JScrollPane jScrollPane1;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTCircuito;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTConversor;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTIntegracion;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNombreCliente;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNombreProyecto;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNorden;
    public static javax.swing.JTextArea jTNovedades;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTPCBTE;
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
//Orden del codigo A generar con toda la informaciòn

//NumOrden; Nombre Cliente; Nombre Proyecto; Negocios implicados; Tipo de proyecto; Fecha de entrega al cliente; Cantidad del Conversos; Cantidad del Troque; Cantidad del Repujado; Cantidad del Stencil; Cantidad del Circuito_FE; Material del Circuito; ¿Antisolder del circuito_FE?; ¿Ruteo del circuito_FE?; Cantidad de la PCB_TE; Material de la PCB; ¿Antisolder de la PCB_TE?; ¿Ruteo de la PCB_TE?; Componentes de la PCB_TE; Integraciòn del PCB_TE; Cantidad de Teclados; Cantidad de ensamble; Fecha de entrega del Circuito_FE(TH,FV,GF) a ensamble; Fecha de entrega de los componentes del circuito_FE; Fecha de entrega de la PCB_TE(TH,FV,GF); Fecha de entrega de componentes de la PCB_TE  
