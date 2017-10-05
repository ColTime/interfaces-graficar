/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        consultarProyectos("", "", "", "");
    }
    //VAriables globales
    int posX = 0;
    int posY = 0;
    CachedRowSet crs;
    //Botones de radio

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TProyecto = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10)
                    .addComponent(jButton9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tipo:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 110, 71, -1));

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

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 20, -1));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153)), "Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setLayout(new java.awt.CardLayout());

        TProyecto.setAutoCreateRowSorter(true);
        TProyecto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TProyecto.setForeground(new java.awt.Color(128, 128, 131));
        TProyecto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Orden °N", "Comercial", "Nombre Cliente", "Nombre  Proyecto", "Fecha Ingreso", "Fecha Entrega", "Fecha Salida", "Estado", "Tipo"
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
        jScrollPane2.setViewportView(TProyecto);

        jPanel2.add(jScrollPane2, "card2");

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 122, 1203, 294));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153)), "PNC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setLayout(new java.awt.CardLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setForeground(new java.awt.Color(128, 128, 131));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Negocio", "Cantidad", "Proceso", "Estado"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(63, 179, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, "card2");

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 422, 474, 193));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 153, 153)), "Detalles delproyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setLayout(new java.awt.CardLayout());

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setForeground(new java.awt.Color(128, 128, 131));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Estado"
            }
        ));
        jTable3.setFillsViewportHeight(true);
        jTable3.setFocusTraversalPolicyProvider(true);
        jTable3.setFocusable(false);
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable3.setSelectionBackground(new java.awt.Color(63, 179, 255));
        jTable3.setShowHorizontalLines(false);
        jTable3.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jTable3);

        jPanel6.add(jScrollPane3, "card2");

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 422, 612, 193));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jDFecha.setDate(null);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        this.setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultarProyectos("", "", "", "");
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
    }//GEN-LAST:event_jREntregaMouseClicked

    private void jRIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRIngresoMouseClicked
        jRnulo.setVisible(true);
        jDFecha.setEnabled(true);
    }//GEN-LAST:event_jRIngresoMouseClicked

    private void jRSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRSalidaMouseClicked
        jRnulo.setVisible(true);
        jDFecha.setEnabled(true);
    }//GEN-LAST:event_jRSalidaMouseClicked

    private void jRnuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRnuloMouseClicked
        jRnulo.setVisible(false);
        jDFecha.setEnabled(false);
    }//GEN-LAST:event_jRnuloMouseClicked

    private void jDFechaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaInputMethodTextChanged
    }//GEN-LAST:event_jDFechaInputMethodTextChanged

    private void jDFechaCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDFechaCaretPositionChanged
    }//GEN-LAST:event_jDFechaCaretPositionChanged

    private void jDFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDFechaPropertyChange
         System.err.println("Ingreso");
         if((jRIngreso.isSelected() || jREntrega.isSelected() || jRSalida.isSelected()) && jDFecha.getDate()!=null){
             controlBusqueda();
         }
    }//GEN-LAST:event_jDFechaPropertyChange

    private void jDFechaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jDFechaVetoableChange
    }//GEN-LAST:event_jDFechaVetoableChange

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
    //Se valida que si se pueda ejecutar la consulta sin tener ningun problema
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
            String v[] = {"N° Orden", "Comercial", "Nombre Cliente", "Nombre Proyecto", "Fecha Ingreso", "Fecha Entrega", "Fecha Salida", "Estado", "Tipo"};
            DefaultTableModel model = new DefaultTableModel(null, v);
            while (crs.next()) {
                String v1[] = new String[9];
                v1[0] = String.valueOf(crs.getInt(1));
                v1[1] = crs.getString(2);
                v1[2] = crs.getString(3);
                v1[3] = crs.getString(4);
                v1[4] = crs.getString(5);
                v1[5] = crs.getString(6);
                v1[6] = crs.getString(7);
                v1[7] = crs.getString(8);
                v1[8] = crs.getString(9);
                model.addRow(v1);
            }
            TProyecto.setModel(model);
            editarColumnas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Erro! " + e);
        }
    }

    private void validarTabla() {
        //Metodo para colocar las filas de color respecto a su tipo de proyecto
    }

    private void editarColumnas() {
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
        TProyecto.getColumnModel().getColumn(3).setMinWidth(255);
        TProyecto.getColumnModel().getColumn(3).setMaxWidth(255);
        TProyecto.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(255);
        TProyecto.getTableHeader().getColumnModel().getColumn(3).setMinWidth(255);
        TProyecto.getColumnModel().getColumn(4).setMinWidth(180);
        TProyecto.getColumnModel().getColumn(4).setMaxWidth(180);
        TProyecto.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(180);
        TProyecto.getTableHeader().getColumnModel().getColumn(4).setMinWidth(180);
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
        System.out.println("Se finalizo la clase consultar Proyecto");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
