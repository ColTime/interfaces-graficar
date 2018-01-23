package Vistas;

import Controlador.DetalleProyecto;
import Controlador.FormatoTabla;
import java.awt.Color;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyAnimated;

public class ConsultarPNC extends javax.swing.JFrame {

    public ConsultarPNC(int cargo, int vista, int accion) {
        initComponents();
        this.cargo = cargo;
        this.vista = vista;
        this.accion = accion;
        titulo();
        editarColumnasDetalle();
        tamañoColumnas();
        jTNorden.setFocusable(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
    }

    //Variables
    CachedRowSet crs = null;
    int x = 0;
    int y = 0;
    public static int cargo = 0;
    public static int vista = 0;
    public static int accion = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jTNorden = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel3 = new javax.swing.JLabel();
        jLTitulo = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TDetalle = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jPanel2.setBackground(new java.awt.Color(63, 179, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
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

        jTNorden.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTNorden.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNorden.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNorden.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTNorden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNordenMousePressed(evt);
            }
        });
        jTNorden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTNordenKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText(" Orden °N:");

        jLTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(128, 128, 131));
        jLTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTitulo.setText("Texto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTNorden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNorden, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton9))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Estado", "Material", "ubicacion"
            }
        ));
        TDetalle.setFillsViewportHeight(true);
        TDetalle.setFocusTraversalPolicyProvider(true);
        TDetalle.setFocusable(false);
        TDetalle.setGridColor(new java.awt.Color(255, 255, 255));
        TDetalle.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TDetalle.setName("PNC"); // NOI18N
        TDetalle.setSelectionBackground(new java.awt.Color(63, 179, 255));
        TDetalle.setShowHorizontalLines(false);
        TDetalle.setShowVerticalLines(false);
        TDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TDetalleMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TDetalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTNordenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNordenMousePressed

    }//GEN-LAST:event_jTNordenMousePressed

    private void jTNordenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNordenKeyReleased
        if (jTNorden.getText().length() >= 5) {
            consutarDetalle();
        } else {
            String encabezado1[] = {"idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Estado", "Material", "Ubicacion"};
            TDetalle.setModel(new DefaultTableModel(null, encabezado1));
        }
        tamañoColumnas();
    }//GEN-LAST:event_jTNordenKeyReleased
    private void tamañoColumnas() {
        if (vista == 2) {
            TDetalle.getColumnModel().getColumn(2).setMinWidth(100);
            TDetalle.getColumnModel().getColumn(2).setMaxWidth(100);
            TDetalle.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(100);
            TDetalle.getTableHeader().getColumnModel().getColumn(2).setMinWidth(100);
            TDetalle.getColumnModel().getColumn(6).setMinWidth(150);
            TDetalle.getColumnModel().getColumn(6).setMaxWidth(150);
            TDetalle.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(150);
            TDetalle.getTableHeader().getColumnModel().getColumn(6).setMinWidth(150);
        } else {
            TDetalle.getColumnModel().getColumn(5).setMinWidth(0);
            TDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
            TDetalle.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
            TDetalle.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
            TDetalle.getColumnModel().getColumn(6).setMinWidth(0);
            TDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
            TDetalle.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
            TDetalle.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        }
    }
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void TDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDetalleMousePressed

        if (evt.getClickCount() == 2 && TDetalle.getSelectedRow() >= 0) {
            int pos = 0;
            String negocio = "";
            pos = TDetalle.getSelectedRow();//Numero de la fila donde se selecciono

            if (TDetalle.getRowCount() > 0) {
                //Se valida que el estado del proyecto no sea parado ni por iniciar para que no permita generar productos no conformes de estas ordenes.
                //Esto solo aplica para la vista numero 1 Cuando se va a registrar un PNC
                if (!TDetalle.getValueAt(pos, 4).toString().equals("Parada") && vista == 1 ? !TDetalle.getValueAt(pos, 4).toString().equals("Por iniciar") : true) {
                    if (cargo == 2) {
                        negocio = "FE";
                    } else if (cargo == 3) {
                        negocio = "EN";
                    }
                    if (negocio.equals("FE")) {
                        if (TDetalle.getValueAt(pos, 1).toString().equals("FE") || TDetalle.getValueAt(pos, 1).toString().equals("TE")) {
                            exportarInformacion(pos);
                            this.dispose();
                        } else {
                            new rojerusan.RSNotifyAnimated("¡Alerta!", "No tienes permiso para generar un PNC de este producto.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                        }
                    } else {
                        if (TDetalle.getValueAt(pos, 1).toString().equals("IN")) {//Integración ó ensamble
                            exportarInformacion(pos);
                            this.dispose();
                        } else {
                            new rojerusan.RSNotifyAnimated("¡Alerta!", "No tienes permiso para generar un PNC de este producto.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                        }
                    }
                } else {
                    //Mensaje...
                    //No puedes generar un PNC de esta orden porque esta en estado Parada/Por iniciar.
                    new rojerusan.RSNotifyAnimated("¡Alerta!", "No puedes generar un PNC de esta orden porque esta en estado: " + TDetalle.getValueAt(pos, 4).toString(), 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_TDetalleMousePressed
    //Metodos de consultarPNC--------------------------------------------------->

    private void exportarInformacion(int pos) {
        proyecto1.jPInformacion.setBackground(new Color(255, 255, 255));//Se activan los componentes
        proyecto1.btnNuevo.setEnabled(true);
        proyecto1.jLDetalle.setText(TDetalle.getValueAt(pos, 0).toString());
        proyecto1.jTNorden.setText(jTNorden.getText());
        proyecto1.jTNegocio.setText(TDetalle.getValueAt(pos, 1).toString());
        proyecto1.jTTipoNegocio.setText(TDetalle.getValueAt(pos, 2).toString());
        proyecto1.cbProcedoPNC.removeAllItems();
        proyecto1.cbProcedoPNC.addItem("Seleccione...");
        if (TDetalle.getValueAt(pos, 5) == null) {
            proyecto1.jLMaterial.setText("NULL");
        } else {
            proyecto1.jLMaterial.setText(TDetalle.getValueAt(pos, 5).toString());
        }

        if (vista == 2) {
            proyecto1.btnDelete.setEnabled(true);
            proyecto1.btnGenerarQR.setEnabled(true);
        } else {
            proyecto1.btnDelete.setEnabled(false);
            proyecto1.btnGenerarQR.setEnabled(false);
        }

        //Se valida si la accion va ser crear o modificar
        if (accion == 2) {
            proyecto1.op = 2;
        } else {
            proyecto1.op = 1;
        }
        proyecto1.btnModificarPNC.setEnabled(false);
        if (TDetalle.getValueAt(pos, 1).toString().equals("FE")) {
            try {
                crs = consultarProcesos(Integer.parseInt(TDetalle.getValueAt(pos, 0).toString()));
                while (crs.next()) {
                    proyecto1.cbProcedoPNC.addItem(crs.getString(1));
                }
            } catch (Exception e) {
            }
        } else if (TDetalle.getValueAt(pos, 1).toString().equals("TE")) {
            proyecto1.cbProcedoPNC.addItem("Correas y Conversor");
            proyecto1.cbProcedoPNC.addItem("Lexan");
            proyecto1.cbProcedoPNC.addItem("Acople");
            proyecto1.cbProcedoPNC.addItem("Control Calidad");
        } else if (TDetalle.getValueAt(pos, 1).toString().equals("IN")) {
            proyecto1.cbProcedoPNC.addItem("Manual");
            proyecto1.cbProcedoPNC.addItem("Limplieza");
            proyecto1.cbProcedoPNC.addItem("Control Calidad");
            proyecto1.cbProcedoPNC.addItem("Empaque");
            proyecto1.cbProcedoPNC.addItem("Stencil");
            proyecto1.cbProcedoPNC.addItem("Linea");
            proyecto1.cbProcedoPNC.addItem("Arnes");
        }
        if (vista == 1) {
            proyecto1.cbProcedoPNC.setEnabled(true);
            proyecto1.jTCantindad.setEnabled(true);
            proyecto1.cbProcedoPNC.setSelectedIndex(0);
            proyecto1.jTCantindad.setText("");
        } else {
            proyecto1.cbProcedoPNC.setEnabled(true);
            proyecto1.jTCantindad.setEnabled(true);
            proyecto1.cbProcedoPNC.setSelectedItem(TDetalle.getValueAt(pos, 6).toString());
            proyecto1.jTCantindad.setText(TDetalle.getValueAt(pos, 3).toString());
        }
    }

    private CachedRowSet consultarProcesos(int detalle) {
        DetalleProyecto obj = new DetalleProyecto();
        return obj.consultarProcesosFE(detalle);
    }

    private void consutarDetalle() {
        String encabezado1[] = {"idDetalle", "Negocio", "Tipo de negocio", "Cantidad", "Estado", "Material", "Ubicacion"};
        DefaultTableModel model1 = new DefaultTableModel(null, encabezado1);
        String v1[] = new String[7];
        try {
            DetalleProyecto obj = new DetalleProyecto();
            crs = obj.consultar_Detalle_Proyecto(jTNorden.getText(), 1);
            while (crs.next()) {
                if (vista == 1) {
                    if (!crs.getBoolean(6)) {
                        //Detalle del proyecto
                        v1[0] = String.valueOf(crs.getInt(1));//idDetalle
                        v1[1] = crs.getString(2);//Negocio
                        v1[2] = crs.getString(3);//Tipo negocio
                        v1[3] = crs.getString(4);//Cantidad
                        if (crs.getBoolean(9)) {
                            v1[4] = crs.getString(5);//Estado
                        } else {
                            v1[4] = "Parada";//Estado
                        }
                        v1[5] = crs.getString(8);//Material
                        v1[6] = crs.getString(7);//Ubicación
                        model1.addRow(v1);
                    }
                } else {
                    if (crs.getBoolean(6)) {
                        //PNC del proyecto
                        v1[0] = String.valueOf(crs.getInt(1));//idDetalle
                        v1[1] = crs.getString(2);//Negocio
                        v1[2] = crs.getString(3);//Tipo negocio
                        v1[3] = crs.getString(4);//Cantidad
                        if (crs.getBoolean(9)) {
                            v1[4] = crs.getString(5);//Estado
                        } else {
                            v1[4] = "Parada";//Estado
                        }
                        v1[5] = crs.getString(8);//Material
                        v1[6] = crs.getString(7);//Ubicación
                        model1.addRow(v1);
                    }
                }
            }
            TDetalle.setModel(model1);
            editarColumnasDetalle();
            FormatoTabla ft = new FormatoTabla(4);
            TDetalle.setDefaultRenderer(Object.class, ft);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
    }

    private void titulo() {
        if (vista == 1) {
            jLTitulo.setText("Tipo de negocio");
        } else {
            jLTitulo.setText("PNC");
        }
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
            java.util.logging.Logger.getLogger(ConsultarPNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPNC(0, 0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TDetalle;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNorden;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
