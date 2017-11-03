/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.DetalleProyecto;
import Controlador.FormatoTabla;
import coltime.Menu;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author comunicaciones03
 */
public class ConsutaProyecto extends javax.swing.JFrame {

    /**
     * Creates new form ConsutaProyecto
     */
    public ConsutaProyecto() {
        initComponents();
        jDFecha.setEnabled(false);
        jRnulo.setVisible(false);
        jTtipo.setText("");
        consultarProyectos("", "", "", "");
        editarColumnasPNC();
        editarColumnasDetalle();
        System.out.println("width: " + jPEncabezado.getWidth() + "\n"
                + "Heigth: " + jPEncabezado.getHeight());
    }
    //VAriables globales
    int posX = 0;
    int posY = 0;
    CachedRowSet crs;
    //Botones de radio
    String encabezado1[] = {"idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Estado", "Material"};//Detalle del proyecto
    String encabezado2[] = {"idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Ubicación", "Estado"};//PNC

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechas = new javax.swing.ButtonGroup();
        jPEncabezado = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTtipo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTNumerOrden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jTNombreCliente = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        jTNombreProyecto = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDFecha = new com.toedter.calendar.JDateChooser();
        jREntrega = new javax.swing.JRadioButton();
        jRIngreso = new javax.swing.JRadioButton();
        jRSalida = new javax.swing.JRadioButton();
        jRnulo = new javax.swing.JRadioButton();
        jTtipo1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TProyecto = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPNC = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TDetalle = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPEncabezado.setBackground(new java.awt.Color(63, 179, 255));
        jPEncabezado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPEncabezado.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPEncabezadoMouseDragged(evt);
            }
        });
        jPEncabezado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPEncabezadoMousePressed(evt);
            }
        });
        jPEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPEncabezado.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1192, 11, 23, -1));

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
        jPEncabezado.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1163, 11, 23, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEmpresa/encabezado.jpg"))); // NOI18N
        jPEncabezado.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 1090, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTtipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTtipo.setForeground(new java.awt.Color(128, 128, 131));
        jTtipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTtipo.setText("Tipo:");
        jPanel4.add(jTtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 110, 71, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(204, 204, 204)), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTNumerOrden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNumerOrden.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNumerOrden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNumerOrdenKeyReleased(evt);
            }
        });
        jPanel3.add(jTNumerOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 51, 90, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 30, 71, -1));

        jTNombreCliente.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreCliente.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreClienteKeyReleased(evt);
            }
        });
        jPanel3.add(jTNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 51, 239, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 30, 129, -1));

        jTNombreProyecto.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreProyecto.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNombreProyectoKeyReleased(evt);
            }
        });
        jPanel3.add(jTNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 51, 250, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 30, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retro.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1178, 12, 20, 20));

        jDFecha.setToolTipText("");
        jDFecha.setDateFormatString("dd/MM/yyyy");
        jDFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jDFecha.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDFechaCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jDFechaInputMethodTextChanged(evt);
            }
        });
        jDFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDFechaPropertyChange(evt);
            }
        });
        jDFecha.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jDFechaVetoableChange(evt);
            }
        });
        jPanel3.add(jDFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 140, -1));

        jREntrega.setBackground(new java.awt.Color(255, 255, 255));
        fechas.add(jREntrega);
        jREntrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jREntrega.setForeground(new java.awt.Color(128, 128, 131));
        jREntrega.setText("E");
        jREntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jREntregaMouseClicked(evt);
            }
        });
        jPanel3.add(jREntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jRIngreso.setBackground(new java.awt.Color(255, 255, 255));
        fechas.add(jRIngreso);
        jRIngreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRIngreso.setForeground(new java.awt.Color(128, 128, 131));
        jRIngreso.setText("I");
        jRIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRIngresoMouseClicked(evt);
            }
        });
        jPanel3.add(jRIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, -1, -1));

        jRSalida.setBackground(new java.awt.Color(255, 255, 255));
        fechas.add(jRSalida);
        jRSalida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRSalida.setForeground(new java.awt.Color(128, 128, 131));
        jRSalida.setText("S");
        jRSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRSalidaMouseClicked(evt);
            }
        });
        jRSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRSalidaActionPerformed(evt);
            }
        });
        jPanel3.add(jRSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        jRnulo.setBackground(new java.awt.Color(255, 255, 255));
        fechas.add(jRnulo);
        jRnulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRnulo.setForeground(new java.awt.Color(128, 128, 131));
        jRnulo.setText("null");
        jRnulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRnuloMouseClicked(evt);
            }
        });
        jPanel3.add(jRnulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 1203, 92));

        jTtipo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTtipo1.setForeground(new java.awt.Color(128, 128, 131));
        jTtipo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTtipo1.setText("Tipo:");
        jPanel4.add(jTtipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, 60, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153)), "Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setLayout(new java.awt.CardLayout());

        TProyecto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TProyecto.setAutoCreateRowSorter(true);
        TProyecto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TProyecto.setForeground(new java.awt.Color(128, 128, 131));
        TProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Orden °N", "Comercial", "Nombre Cliente", "Nombre  Proyecto", "Fecha Ingreso", "Fecha Entrega", "Fecha Salida", "Estado", "Tipo", "FE", "TE", "IN", "Ruteo", "Antisolder"
            }
        ));
        TProyecto.setFillsViewportHeight(true);
        TProyecto.setFocusTraversalPolicyProvider(true);
        TProyecto.setGridColor(new java.awt.Color(255, 255, 255));
        TProyecto.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TProyecto.setRequestFocusEnabled(false);
        TProyecto.setRowHeight(17);
        TProyecto.setSelectionBackground(new java.awt.Color(63, 179, 255));
        TProyecto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TProyecto.setShowHorizontalLines(false);
        TProyecto.setShowVerticalLines(false);
        TProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TProyectoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TProyectoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(TProyecto);

        jPanel2.add(jScrollPane2, "card2");

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 122, 1203, 294));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153)), "PNC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setLayout(new java.awt.CardLayout());

        TPNC = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TPNC.setAutoCreateRowSorter(true);
        TPNC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TPNC.setForeground(new java.awt.Color(128, 128, 131));
        TPNC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Ubicación", "Estado"
            }
        ));
        TPNC.setFillsViewportHeight(true);
        TPNC.setFocusTraversalPolicyProvider(true);
        TPNC.setFocusable(false);
        TPNC.setGridColor(new java.awt.Color(255, 255, 255));
        TPNC.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TPNC.setSelectionBackground(new java.awt.Color(63, 179, 255));
        TPNC.setShowHorizontalLines(false);
        TPNC.setShowVerticalLines(false);
        jScrollPane1.setViewportView(TPNC);

        jPanel5.add(jScrollPane1, "card2");

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 422, 560, 193));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153)), "Detalles delproyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setLayout(new java.awt.CardLayout());

        TDetalle = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TDetalle.setAutoCreateRowSorter(true);
        TDetalle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TDetalle.setForeground(new java.awt.Color(128, 128, 131));
        TDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Estado", "Material"
            }
        ));
        TDetalle.setFillsViewportHeight(true);
        TDetalle.setFocusTraversalPolicyProvider(true);
        TDetalle.setFocusable(false);
        TDetalle.setGridColor(new java.awt.Color(255, 255, 255));
        TDetalle.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TDetalle.setSelectionBackground(new java.awt.Color(63, 179, 255));
        TDetalle.setShowHorizontalLines(false);
        TDetalle.setShowVerticalLines(false);
        jScrollPane3.setViewportView(TDetalle);

        jPanel6.add(jScrollPane3, "card2");

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 422, 600, 193));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1225, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jPEncabezadoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEncabezadoMouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_jPEncabezadoMouseDragged

    private void jPEncabezadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPEncabezadoMousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPEncabezadoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultarProyectos("", "", "", "");
        TDetalle.setModel(new DefaultTableModel(null, encabezado1));
        TPNC.setModel(new DefaultTableModel(null, encabezado2));
        limpiarCampos();
        editarColumnasDetalle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTNumerOrdenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNumerOrdenKeyReleased
        controlBusqueda();
    }//GEN-LAST:event_jTNumerOrdenKeyReleased

    private void jTNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreClienteKeyReleased
        controlBusqueda();
    }//GEN-LAST:event_jTNombreClienteKeyReleased

    private void jTNombreProyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNombreProyectoKeyReleased
        controlBusqueda();
    }//GEN-LAST:event_jTNombreProyectoKeyReleased

    private void jREntregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jREntregaMouseClicked
        jRnulo.setVisible(true);
        jDFecha.setEnabled(true);
        action();
    }//GEN-LAST:event_jREntregaMouseClicked

    private void jRIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRIngresoMouseClicked
        jRnulo.setVisible(true);
        jDFecha.setEnabled(true);
        action();
    }//GEN-LAST:event_jRIngresoMouseClicked

    private void jRSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRSalidaMouseClicked
        jRnulo.setVisible(true);
        jDFecha.setEnabled(true);
        action();
    }//GEN-LAST:event_jRSalidaMouseClicked

    private void jRnuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRnuloMouseClicked
        jRnulo.setVisible(false);
        jDFecha.setEnabled(false);
        jDFecha.setDate(null);
        consultarProyectos(jTNumerOrden.getText(), jTNombreCliente.getText(), jTNombreProyecto.getText(), "");
    }//GEN-LAST:event_jRnuloMouseClicked

    private void jDFechaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaInputMethodTextChanged
    }//GEN-LAST:event_jDFechaInputMethodTextChanged

    private void jDFechaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaCaretPositionChanged
    }//GEN-LAST:event_jDFechaCaretPositionChanged

    private void jDFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDFechaPropertyChange
        if ((jRIngreso.isSelected() || jREntrega.isSelected() || jRSalida.isSelected()) && jDFecha.getDate() != null) {
            controlBusqueda();
        }
    }//GEN-LAST:event_jDFechaPropertyChange

    private void jDFechaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jDFechaVetoableChange
    }//GEN-LAST:event_jDFechaVetoableChange

    private void TProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProyectoMouseClicked
//        if (evt.getClickCount() == 1) {
//            if (TProyecto.getRowCount() > 0) {
//                int f = TProyecto.getSelectedRow();
//                String valor = TProyecto.getValueAt(f, 8).toString();
//                jTtipo.setText(valor);
//                if (valor.equals("Normal")) {
//                    jTtipo.setForeground(new Color(128, 128, 131));
//                } else if (valor.equals("Quick")) {
//                    jTtipo.setForeground(Color.blue);
//                } else if (valor.equals("RQT")) {
//                    jTtipo.setForeground(Color.ORANGE);
//                }
//                consultarDetalle(TProyecto.getValueAt(f, 0).toString());
//            }
//        }
//        if (evt.getClickCount() == 2) {
//            Menu obj = new Menu();
//            obj.cambiarpanelProyecto();
//            obj.btn1.setColorHover(obj.cor);
//            obj.btn1.setColorNormal(obj.corF);
//            obj.btn1.setColorPressed(obj.cor);
//            
//            obj.btn2.setColorHover(obj.cor);
//            obj.btn2.setColorNormal(obj.cor);
//            obj.btn2.setColorPressed(obj.cor);
//
//            obj.btn3.setColorHover(obj.cor);
//            obj.btn3.setColorNormal(obj.corF);
//            obj.btn3.setColorPressed(obj.cor);
//
//            obj.btn4.setColorHover(obj.cor);
//            obj.btn4.setColorNormal(obj.corF);
//            obj.btn4.setColorPressed(obj.cor);
//            this.dispose();
//        }
    }//GEN-LAST:event_TProyectoMouseClicked

    private void TProyectoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TProyectoMousePressed
        if (evt.getClickCount() == 1) {
            if (TProyecto.getRowCount() > 0) {
                int f = TProyecto.getSelectedRow();
                String valor = TProyecto.getValueAt(f, 8).toString();
                jTtipo.setText(valor);
                if (valor.equals("Normal")) {
                    jTtipo.setForeground(new Color(128, 128, 131));
                } else if (valor.equals("Quick")) {
                    jTtipo.setForeground(Color.blue);
                } else if (valor.equals("RQT")) {
                    jTtipo.setForeground(Color.ORANGE);
                }
                consultarDetalle(TProyecto.getValueAt(f, 0).toString());
            }
        }
        if (evt.getClickCount() == 2) {
            if (TProyecto.getRowCount() > 0) {
                SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaEntrega = null;
                proyecto obj = new proyecto(2);
                obj.setFocusable(true);
                try {
                    obj.GenerarQR.setEnabled(true);
                    int f = TProyecto.getSelectedRow();
                    //Activar componentes
                    activarCamposproyecto(obj);
                    //Asignar valores a componentes
                    obj.jTNorden.setText(TProyecto.getValueAt(f, 0).toString());
                    obj.jTNombreCliente.setText(TProyecto.getValueAt(f, 2).toString());
                    obj.jTNombreProyecto.setText(TProyecto.getValueAt(f, 3).toString());
                    String fet[] = TProyecto.getValueAt(f, 4).toString().split(" ");
                    obj.jLIngreso.setText(fet[0]);
                    fechaEntrega = fecha.parse(TProyecto.getValueAt(f, 5).toString());
                    obj.jDentrega.setDate(fechaEntrega);
                    obj.cbTipo.setSelectedItem(TProyecto.getValueAt(f, 8).toString());
                    //Tipos de negocios implicados
                    if (TProyecto.getValueAt(f, 9).toString().equals("true") && TProyecto.getValueAt(f, 10).toString().equals("false") && TProyecto.getValueAt(f, 11).toString().equals("false")) {
                        obj.cbNegocio.setSelectedIndex(1);
                    }
                    if (TProyecto.getValueAt(f, 9).toString().equals("false") && TProyecto.getValueAt(f, 10).toString().equals("true") && TProyecto.getValueAt(f, 11).toString().equals("false")) {
                        obj.cbNegocio.setSelectedIndex(2);
                    }
                    if (TProyecto.getValueAt(f, 9).toString().equals("false") && TProyecto.getValueAt(f, 10).toString().equals("false") && TProyecto.getValueAt(f, 11).toString().equals("true")) {
                        obj.cbNegocio.setSelectedIndex(3);
                    }
                    if (TProyecto.getValueAt(f, 9).toString().equals("true") && TProyecto.getValueAt(f, 10).toString().equals("true") && TProyecto.getValueAt(f, 11).toString().equals("false")) {
                        obj.cbNegocio.setSelectedIndex(4);
                    }
                    if (TProyecto.getValueAt(f, 9).toString().equals("true") && TProyecto.getValueAt(f, 10).toString().equals("false") && TProyecto.getValueAt(f, 11).toString().equals("true")) {
                        obj.cbNegocio.setSelectedIndex(5);
                    }
                    if (TProyecto.getValueAt(f, 9).toString().equals("true") && TProyecto.getValueAt(f, 10).toString().equals("true") && TProyecto.getValueAt(f, 11).toString().equals("true")) {
                        obj.cbNegocio.setSelectedIndex(6);
                    }
                    //RuteoC y antisolderC
                    if (TProyecto.getValueAt(f, 12).toString().equals("true")) {
                        obj.jCRuteoC.setSelected(true);
                    } else {
                        obj.jCRuteoC.setSelected(false);
                    }

                    if (TProyecto.getValueAt(f, 13).toString().equals("true")) {
                        obj.jCAntisolderC.setSelected(true);
                    } else {
                        obj.jCAntisolderC.setSelected(false);
                    }
                    //RuteoP y AntisolderP
                    if (TProyecto.getValueAt(f, 14).toString().equals("true")) {
                        obj.jCRuteoP.setSelected(true);
                    } else {
                        obj.jCRuteoP.setSelected(false);
                    }

                    if (TProyecto.getValueAt(f, 15).toString().equals("true")) {
                        obj.jCAntisolderP.setSelected(true);
                    } else {
                        obj.jCAntisolderP.setSelected(false);
                    }
                    //Limpiar labes de id de detalle
                    obj.jLIDConversor.setText("0");
                    obj.jLIDTroquel.setText("0");
                    obj.jLIDRepujado.setText("0");
                    obj.jLIDStencil.setText("0");
                    obj.jLIDPCB.setText("0");
                    obj.jLIDCircuito.setText("0");
                    obj.jLIDTeclado.setText("0");
                    obj.jLIDIntegracion.setText("0");

                    for (int i = 0; i < TDetalle.getRowCount(); i++) {
                        //Buscamos que detalles tiene este proyecto para enviar a la vista de proyecto
                        if (TDetalle.getValueAt(i, 2).toString().equals("Conversor")) {
                            obj.jLIDConversor.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCConversor.setSelected(true);
                            obj.jCConversor.setEnabled(true);
                            obj.jTConversor.setEnabled(true);
                            obj.jTConversor.setText(TDetalle.getValueAt(i, 3).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("Troquel")) {
                            obj.jLIDTroquel.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCTroquel.setSelected(true);
                            obj.jCTroquel.setEnabled(true);
                            obj.jTTroquel.setEnabled(true);
                            obj.jTTroquel.setText(TDetalle.getValueAt(i, 3).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("Repujado")) {
                            obj.jLIDRepujado.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCRepujado.setSelected(true);
                            obj.jCRepujado.setEnabled(true);
                            obj.jTRepujado.setEnabled(true);
                            obj.jTRepujado.setText(TDetalle.getValueAt(i, 3).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("Stencil")) {
                            obj.jLIDStencil.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCStencil.setSelected(true);
                            obj.jCStencil.setEnabled(true);
                            obj.jTStencil.setEnabled(true);
                            obj.jTStencil.setText(TDetalle.getValueAt(i, 3).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("PCB")) {
                            obj.jLIDPCB.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCRuteoP.setEnabled(true);
                            obj.jCAntisolderP.setEnabled(true);
                            obj.jCPCBTE.setSelected(true);
                            obj.jCPCBTE.setEnabled(true);
                            obj.jTPCBTE.setEnabled(true);
                            obj.jTPCBTE.setText(TDetalle.getValueAt(i, 3).toString());
                            obj.cbMaterialPCBTE.setEnabled(true);
                            obj.cbMaterialPCBTE.setSelectedItem(TDetalle.getValueAt(i, 5).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("Circuito") && TDetalle.getValueAt(i, 1).toString().equals("IN")) {
                            obj.jLIDIntegracion.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCIntegracion.setSelected(true);
                            obj.jCIntegracion.setEnabled(true);
                            obj.jTIntegracion.setEnabled(true);
                            obj.jTIntegracion.setText(TDetalle.getValueAt(i, 3).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("Teclado") && TDetalle.getValueAt(i, 1).toString().equals("TE")) {
                            obj.jLIDTeclado.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCTeclado.setSelected(true);
                            obj.jCTeclado.setEnabled(true);
                            obj.jTTeclado.setEnabled(true);
                            obj.jTTeclado.setText(TDetalle.getValueAt(i, 3).toString());
                        } else if (TDetalle.getValueAt(i, 2).toString().equals("Circuito") && TDetalle.getValueAt(i, 1).toString().equals("FE")) {
                            obj.jLIDCircuito.setText(TDetalle.getValueAt(i, 0).toString());
                            obj.jCRuteoC.setEnabled(true);
                            obj.jCAntisolderC.setEnabled(true);
                            obj.jCCircuito.setSelected(true);
                            obj.jCCircuito.setEnabled(true);
                            obj.jTCircuito.setEnabled(true);
                            obj.jTCircuito.setText(TDetalle.getValueAt(i, 3).toString());
                            obj.cbMaterialCircuito.setEnabled(true);
                            obj.cbMaterialCircuito.setSelectedItem(TDetalle.getValueAt(i, 5).toString());
                        }
                    }
                    obj.btnUpdate.setEnabled(true);
                    this.dispose();
                } catch (Exception e) {
                    //Si se genera algun error a la hora del paso de informacion a la vista
                    JOptionPane.showMessageDialog(null, "Error! " + e);
                }
            }
        }
    }//GEN-LAST:event_TProyectoMousePressed

    private void jRSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRSalidaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsutaProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsutaProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsutaProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsutaProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsutaProyecto().setVisible(true);
            }
        });
    }
//Metodos---------------------------------------------------------------------->

    private void activarCamposproyecto(proyecto obj) {
        obj.btnNuevo.setEnabled(true);
        obj.jTNombreCliente.setEnabled(true);
        obj.jTNombreProyecto.setEnabled(true);
        obj.jDentrega.setEnabled(true);
        obj.cbNegocio.setEnabled(true);
        obj.cbTipo.setEnabled(true);
        obj.jTIntegracion.setEnabled(true);
        obj.jPInformacion.setBackground(new Color(255, 255, 255));
        obj.jPDetalles1.setBackground(new Color(255, 255, 255));
        obj.jPDetalles.setBackground(new Color(255, 255, 255));
    }

//Se valida que si se pueda ejecutar la consulta sin tener ningun problema
    private void action() {
        if ((jRIngreso.isSelected() || jREntrega.isSelected() || jRSalida.isSelected()) && jDFecha.getDate() != null) {
            controlBusqueda();
        }
    }

    private void controlBusqueda() {
        String fecha = "";
        if (jDFecha.getDate() != null) {
            DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
            fecha = formato.format(jDFecha.getDate());
        }
        consultarProyectos(jTNumerOrden.getText(), jTNombreCliente.getText(), jTNombreProyecto.getText(), fecha);
    }

    private void consultarProyectos(String numerOrden, String nombrecliente, String nombreProyecto, String fecha) {
        Controlador.Proyecto obj = new Controlador.Proyecto();
        if (!numerOrden.equals("")) {
            obj.setIdOrden(Integer.parseInt(numerOrden));
        } else {
            obj.setIdOrden(0);
        }
        obj.setNombreCliente(nombrecliente);
        obj.setNombreProyecto(nombreProyecto);
        obj.setFecha(fecha);
        String tipo = "";
        if (jRIngreso.isSelected()) {
            tipo = "Ingreso";
        } else if (jREntrega.isSelected()) {
            tipo = "Entrega";
        } else if (jRSalida.isSelected()) {
            tipo = "Salida";
        }
        //Se ejecuta la sencencia y recibimos los proyectos
        crs = obj.consultar_Proyecto(tipo);
        try {
            String v[] = {"N° Orden", "Comercial", "Nombre Cliente", "Nombre Proyecto", "Fecha Ingreso", "Fecha Entrega", "Fecha Salida", "Estado", "Tipo", "FE", "TE", "IN", "RuteoC", "AntisolderC", "RuteoP", "AntisolderP"};
            DefaultTableModel model = new DefaultTableModel(null, v);
            String v1[] = new String[16];
            while (crs.next()) {
                v1[0] = String.valueOf(crs.getInt(1));
                v1[1] = crs.getString(2);
                v1[2] = crs.getString(3);
                v1[3] = crs.getString(4);
                v1[4] = crs.getString(5);
                v1[5] = crs.getString(6);
                v1[6] = crs.getString(7);
                v1[7] = crs.getString(8);
                v1[8] = crs.getString(9);
                v1[9] = String.valueOf(crs.getBoolean(10));
                v1[10] = String.valueOf(crs.getBoolean(11));
                v1[11] = String.valueOf(crs.getBoolean(12));
                v1[12] = String.valueOf(crs.getBoolean(13));
                v1[13] = String.valueOf(crs.getBoolean(14));
                v1[14] = String.valueOf(crs.getBoolean(15));
                v1[15] = String.valueOf(crs.getBoolean(16));
                model.addRow(v1);
            }
            crs.close();
            TProyecto.setModel(model);
            editarColumnasProyecto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Erro! " + e);
        }
    }

    private void consultarDetalle(String numerOrden) {
        DetalleProyecto obj = new DetalleProyecto();
        try {
            crs = obj.consultar_Detalle_Proyecto(numerOrden);
            DefaultTableModel model1 = new DefaultTableModel(null, encabezado1);
            DefaultTableModel model2 = new DefaultTableModel(null, encabezado2);
            String v1[] = new String[6];
            String v2[] = new String[6];
            while (crs.next()) {
                if (crs.getBoolean(6)) {
                    //PNC del proyecto
                    v2[0] = String.valueOf(crs.getInt(1));//idDetalle
                    v2[1] = crs.getString(2);//Negocio
                    v2[2] = crs.getString(3);//Tipo negocio
                    v2[3] = crs.getString(4);//Cantidad
                    v2[4] = crs.getString(7);//Ubicacion del PNC
                    v2[5] = crs.getString(5);//Estado
                    model2.addRow(v2);
                } else {
                    //Detalle del proyecto
                    v1[0] = String.valueOf(crs.getInt(1));//idDetalle
                    v1[1] = crs.getString(2);//Negocio
                    v1[2] = crs.getString(3);//Tipo negocio
                    v1[3] = crs.getString(4);//Cantidad
                    v1[4] = crs.getString(5);//Estado
                    v1[5] = crs.getString(8);//Material
                    model1.addRow(v1);
                }
            }
            crs.close();
            TDetalle.setModel(model1);
            editarColumnasDetalle();
            TPNC.setModel(model2);
            editarColumnasPNC();
            FormatoTabla ft = new FormatoTabla(4);
            TDetalle.setDefaultRenderer(Object.class, ft);
            FormatoTabla ftP = new FormatoTabla(5);
            TPNC.setDefaultRenderer(Object.class, ftP);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    private void limpiarCampos() {
        jTNumerOrden.setText("");
        jTNombreCliente.setText("");
        jTNombreProyecto.setText("");
        jDFecha.setDate(null);
        jDFecha.setEnabled(false);
        jRnulo.setSelected(true);
        jRnulo.setVisible(false);
    }

    private void editarColumnasDetalle() {
        TDetalle.getColumnModel().getColumn(0).setMinWidth(58);
        TDetalle.getColumnModel().getColumn(0).setMaxWidth(58);
        TDetalle.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(58);
        TDetalle.getTableHeader().getColumnModel().getColumn(0).setMinWidth(58);
        TDetalle.getColumnModel().getColumn(1).setMinWidth(70);
        TDetalle.getColumnModel().getColumn(1).setMaxWidth(70);
        TDetalle.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(70);
        TDetalle.getTableHeader().getColumnModel().getColumn(1).setMinWidth(70);
        TDetalle.getColumnModel().getColumn(2).setMinWidth(250);
        TDetalle.getColumnModel().getColumn(2).setMaxWidth(250);
        TDetalle.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(250);
        TDetalle.getTableHeader().getColumnModel().getColumn(2).setMinWidth(250);
        TDetalle.getColumnModel().getColumn(3).setMinWidth(100);
        TDetalle.getColumnModel().getColumn(3).setMaxWidth(100);
        TDetalle.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(100);
        TDetalle.getTableHeader().getColumnModel().getColumn(3).setMinWidth(100);
        TDetalle.getColumnModel().getColumn(4).setMinWidth(113);
        TDetalle.getColumnModel().getColumn(4).setMaxWidth(113);
        TDetalle.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(113);
        TDetalle.getTableHeader().getColumnModel().getColumn(4).setMinWidth(113);
        TDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        TDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        TDetalle.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        TDetalle.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
    }

    private void editarColumnasPNC() {
        TPNC.getColumnModel().getColumn(0).setMinWidth(58);
        TPNC.getColumnModel().getColumn(0).setMaxWidth(58);
        TPNC.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(58);
        TPNC.getTableHeader().getColumnModel().getColumn(0).setMinWidth(58);
        TPNC.getColumnModel().getColumn(1).setMinWidth(100);
        TPNC.getColumnModel().getColumn(1).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(1).setMinWidth(100);
        TPNC.getColumnModel().getColumn(2).setMinWidth(100);
        TPNC.getColumnModel().getColumn(2).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(2).setMinWidth(100);
        TPNC.getColumnModel().getColumn(3).setMinWidth(100);
        TPNC.getColumnModel().getColumn(3).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(3).setMinWidth(100);
        TPNC.getColumnModel().getColumn(4).setMinWidth(100);
        TPNC.getColumnModel().getColumn(4).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(4).setMinWidth(100);
        TPNC.getColumnModel().getColumn(5).setMinWidth(100);
        TPNC.getColumnModel().getColumn(5).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(100);
        TPNC.getTableHeader().getColumnModel().getColumn(5).setMinWidth(100);
    }

    private void editarColumnasProyecto() {
        TProyecto.getColumnModel().getColumn(0).setMinWidth(65);
        TProyecto.getColumnModel().getColumn(0).setMaxWidth(65);
        TProyecto.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(65);
        TProyecto.getTableHeader().getColumnModel().getColumn(0).setMinWidth(65);
        TProyecto.getColumnModel().getColumn(1).setMinWidth(85);
        TProyecto.getColumnModel().getColumn(1).setMaxWidth(85);
        TProyecto.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(85);
        TProyecto.getTableHeader().getColumnModel().getColumn(1).setMinWidth(85);
        TProyecto.getColumnModel().getColumn(2).setMinWidth(255);
        TProyecto.getColumnModel().getColumn(2).setMaxWidth(255);
        TProyecto.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(255);
        TProyecto.getTableHeader().getColumnModel().getColumn(2).setMinWidth(255);
        TProyecto.getColumnModel().getColumn(3).setMinWidth(250);
        TProyecto.getColumnModel().getColumn(3).setMaxWidth(250);
        TProyecto.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(250);
        TProyecto.getTableHeader().getColumnModel().getColumn(3).setMinWidth(250);
        TProyecto.getColumnModel().getColumn(4).setMinWidth(185);
        TProyecto.getColumnModel().getColumn(4).setMaxWidth(185);
        TProyecto.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(185);
        TProyecto.getTableHeader().getColumnModel().getColumn(4).setMinWidth(185);
        TProyecto.getColumnModel().getColumn(5).setMinWidth(100);
        TProyecto.getColumnModel().getColumn(5).setMaxWidth(100);
        TProyecto.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(100);
        TProyecto.getTableHeader().getColumnModel().getColumn(5).setMinWidth(100);
        TProyecto.getColumnModel().getColumn(6).setMinWidth(180);
        TProyecto.getColumnModel().getColumn(6).setMaxWidth(180);
        TProyecto.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(180);
        TProyecto.getTableHeader().getColumnModel().getColumn(6).setMinWidth(180);
        TProyecto.getColumnModel().getColumn(7).setMinWidth(75);
        TProyecto.getColumnModel().getColumn(7).setMaxWidth(75);
        TProyecto.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(75);
        TProyecto.getTableHeader().getColumnModel().getColumn(7).setMinWidth(75);
        TProyecto.getColumnModel().getColumn(8).setMinWidth(0);
        TProyecto.getColumnModel().getColumn(8).setMaxWidth(0);
        TProyecto.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
        TProyecto.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
    }

//Metodo de finalizacion de clase---------------------------------------------->
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TDetalle;
    private javax.swing.JTable TPNC;
    private javax.swing.JTable TProyecto;
    private javax.swing.ButtonGroup fechas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jREntrega;
    private javax.swing.JRadioButton jRIngreso;
    private javax.swing.JRadioButton jRSalida;
    private javax.swing.JRadioButton jRnulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombreCliente;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNombreProyecto;
    private elaprendiz.gui.textField.TextFieldRoundBackground jTNumerOrden;
    private javax.swing.JLabel jTtipo;
    private javax.swing.JLabel jTtipo1;
    // End of variables declaration//GEN-END:variables
}
