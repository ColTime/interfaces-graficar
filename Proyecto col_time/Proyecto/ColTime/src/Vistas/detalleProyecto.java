package Vistas;

import Controlador.DetalleProyecto;
import Controlador.FE_TE_IN;
import Controlador.Tabla;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyAnimated;

public class detalleProyecto extends javax.swing.JDialog {

    public detalleProyecto(java.awt.Frame parent, boolean modal, int detalle, int negocio, String orden, int permiso) {//Falta organizar la variable "tipo" para que traiga el valor correspondiente
        super(parent, modal);
        initComponents();
        if (negocio == 1) {
            this.setTitle(orden + " - " + "Formato estándar");
        } else if (negocio == 2) {
            this.setTitle(orden + " - " + "Teclados");
        } else if (negocio == 3) {
            this.setTitle(orden + " - " + "Ensamble");
        } else {
            this.setTitle(orden + " - " + "Almacen");
        }

        this.detalle = detalle;
        this.negocio = negocio;
        this.setLocationRelativeTo(null);
        this.permiso = permiso;
        cargarTabla();
        jTNombreCliente.setEditable(false);
        jTNombreProyecto.setEditable(false);
        jTFechaEntrega.setEditable(false);
        jTFechaIngreso.setEditable(false);
        jTCantidadTotal.setEditable(false);
        jTTimepoTotal.setEditable(false);
        jTTimepoTotalUnidad.setEditable(false);
        jTFechaIngreso1.setEditable(false);
        jTFechaIngreso2.setEditable(false);
        jTFechaIngreso3.setEditable(false);
        jTFechaIngreso4.setEditable(false);

        //jTTimepoTotalUnidad
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenesEmpresa/favicon.png")).getImage());
    }
    //variables
    private CachedRowSet crs = null;
    private static int detalle = 0;
    private static int negocio = 0, permiso = 0;
    int rows = -1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TDetalleProduccion = new javax.swing.JTable();
        jPInformacion = new javax.swing.JPanel();
        jTNombreCliente = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel5 = new javax.swing.JLabel();
        jTNombreProyecto = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel4 = new javax.swing.JLabel();
        jTFechaEntrega = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFechaIngreso = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jTCantidadTotal = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel8 = new javax.swing.JLabel();
        jTTimepoTotal = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFechaIngreso1 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel11 = new javax.swing.JLabel();
        jTFechaIngreso2 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel12 = new javax.swing.JLabel();
        jTFechaIngreso3 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel13 = new javax.swing.JLabel();
        jTFechaIngreso4 = new elaprendiz.gui.textField.TextFieldRoundBackground();
        jLabel14 = new javax.swing.JLabel();
        jTTimepoTotalUnidad = new elaprendiz.gui.textField.TextFieldRoundBackground();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retro.png"))); // NOI18N
        jMenuItem1.setText("Actualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        popMenu.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1348, 432));

        jPanel1.setPreferredSize(new java.awt.Dimension(1285, 416));

        TDetalleProduccion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        TDetalleProduccion.setAutoCreateRowSorter(true);
        TDetalleProduccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TDetalleProduccion.setForeground(new java.awt.Color(128, 128, 131));
        TDetalleProduccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Proceso", "Fecha inicio", "Fecha fin", "Restantes", "Cantidad Procesada", "Tiempo total min", "Tiempo por unidad min", "Estado", "Hora Ejecucion", "Tiempo Ejecucion", "Hora Terminacion", "N°Op", "reiniciar", "IDdetalle", "Tiempo"
            }
        ));
        TDetalleProduccion.setFillsViewportHeight(true);
        TDetalleProduccion.setFocusTraversalPolicyProvider(true);
        TDetalleProduccion.setFocusable(false);
        TDetalleProduccion.setGridColor(new java.awt.Color(255, 255, 255));
        TDetalleProduccion.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TDetalleProduccion.setMinimumSize(new java.awt.Dimension(900, 300));
        TDetalleProduccion.setName("TDetalleProduccion"); // NOI18N
        TDetalleProduccion.setRowHeight(18);
        TDetalleProduccion.setSelectionBackground(new java.awt.Color(63, 179, 255));
        TDetalleProduccion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TDetalleProduccion.setShowHorizontalLines(false);
        TDetalleProduccion.setShowVerticalLines(false);
        TDetalleProduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDetalleProduccionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TDetalleProduccionMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TDetalleProduccion);

        jPInformacion.setBackground(new java.awt.Color(255, 255, 255));
        jPInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Información del detalle"));

        jTNombreCliente.setBorder(null);
        jTNombreCliente.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreCliente.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(128, 128, 131));
        jLabel5.setText("Nombre del cliente:");

        jTNombreProyecto.setBorder(null);
        jTNombreProyecto.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTNombreProyecto.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTNombreProyecto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 128, 131));
        jLabel4.setText("Nombre del proyecto:");

        jTFechaEntrega.setBorder(null);
        jTFechaEntrega.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTFechaEntrega.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTFechaEntrega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(128, 128, 131));
        jLabel6.setText("Fecha de entrega:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setText("Fecha de ingreso:");

        jTFechaIngreso.setBorder(null);
        jTFechaIngreso.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTFechaIngreso.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTFechaIngreso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jTCantidadTotal.setBorder(null);
        jTCantidadTotal.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTCantidadTotal.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTCantidadTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setText("Cantidad:");

        jTTimepoTotal.setBorder(null);
        jTTimepoTotal.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTTimepoTotal.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTTimepoTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 128, 131));
        jLabel9.setText("Tiempo Total:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(128, 128, 131));
        jLabel10.setText("Tiempo total por unidad :");

        jTFechaIngreso1.setBorder(null);
        jTFechaIngreso1.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTFechaIngreso1.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTFechaIngreso1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 128, 131));
        jLabel11.setText("Fecha de entrega COM Circuito");

        jTFechaIngreso2.setBorder(null);
        jTFechaIngreso2.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTFechaIngreso2.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTFechaIngreso2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(128, 128, 131));
        jLabel12.setText("Fecha de entrega COM Circuito");

        jTFechaIngreso3.setBorder(null);
        jTFechaIngreso3.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTFechaIngreso3.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTFechaIngreso3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(128, 128, 131));
        jLabel13.setText("Fecha de entrega PCB GF:");

        jTFechaIngreso4.setBorder(null);
        jTFechaIngreso4.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTFechaIngreso4.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTFechaIngreso4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(128, 128, 131));
        jLabel14.setText("Fecha de entrega PCB GF:");

        jTTimepoTotalUnidad.setBorder(null);
        jTTimepoTotalUnidad.setColorDeBorde(new java.awt.Color(204, 204, 204));
        jTTimepoTotalUnidad.setColorDeTextoBackground(new java.awt.Color(255, 255, 255));
        jTTimepoTotalUnidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPInformacionLayout = new javax.swing.GroupLayout(jPInformacion);
        jPInformacion.setLayout(jPInformacionLayout);
        jPInformacionLayout.setHorizontalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 244, Short.MAX_VALUE))
                    .addComponent(jTNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap())
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jTTimepoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTTimepoTotalUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFechaIngreso2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFechaIngreso3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFechaIngreso4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPInformacionLayout.setVerticalGroup(
            jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInformacionLayout.createSequentialGroup()
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPInformacionLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(31, 31, 31))
                                    .addGroup(jPInformacionLayout.createSequentialGroup()
                                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInformacionLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInformacionLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPInformacionLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTTimepoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTTimepoTotalUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPInformacionLayout.createSequentialGroup()
                                    .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9))
                                    .addGap(31, 31, 31))))
                        .addComponent(jTFechaIngreso4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTFechaIngreso3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPInformacionLayout.createSequentialGroup()
                            .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel13))
                            .addGap(31, 31, 31)))
                    .addGroup(jPInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTFechaIngreso2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPInformacionLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(31, 31, 31))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1324, Short.MAX_VALUE)
                    .addComponent(jPInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TDetalleProduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDetalleProduccionMouseClicked
        //Botones de seguridad
        String[] botones = {" SI ", " NO "};
        rows = TDetalleProduccion.rowAtPoint(evt.getPoint());

        int column = TDetalleProduccion.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TDetalleProduccion.getRowHeight();

        if (row < TDetalleProduccion.getRowCount() && row >= 0 && column < TDetalleProduccion.getColumnCount() && column >= 0) {
            Object value = TDetalleProduccion.getValueAt(row, column);
            if (value instanceof JButton) {
                JButton boton;
                boton = (JButton) value;
                if (boton.getText().equals("Tiempo") && !TDetalleProduccion.getValueAt(row, 7).toString().equals("Pausado")) {
                    //Finalizar la toma de tiempo de los procesos del almacen(Solo lo pueden realizar los encargado de almacen)
                    if (boton.getActionCommand().equals("1")) {
                        FE_TE_IN almacen = new FE_TE_IN();
                        String idDetalle = "";
                        //<Gran formato>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                        if (TDetalleProduccion.getValueAt(row, 0).toString().equals("GF")) {
                            //Se pide la cantidad que se recibio del gran formato.
                            String cantidad = JOptionPane.showInputDialog("Cantidades recibidas:");
                            if (cantidad != null) {//Presiona el botono "NO"
                                if (!cantidad.equals("") && Integer.parseInt(cantidad) >= 1) {//Validar la cantidad cuendo presiona el boton "SI"
                                    idDetalle = String.valueOf(TDetalleProduccion.getValueAt(row, 13));//Identificador
                                    int proceso = 0;
                                    if (TDetalleProduccion.getValueAt(row, 0).toString().equals("GF")) {
                                        proceso = 22;
                                    }
                                    String orden[] = this.getTitle().split("-");                                                  //Cantidad//   
                                    if (almacen.pararTiempoAlmacen(Integer.parseInt(orden[0].trim()), Integer.parseInt(idDetalle), Integer.parseInt(cantidad), detalle, proceso)) {
                                        //Mensaje de confirmación.
                                        new rojerusan.RSNotifyAnimated("¡Listo!", "Mensaje", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                                        cargarTabla();
                                    }
                                } else {
                                    //Mensaje de ingresar una cantidad valida.
                                    new rojerusan.RSNotifyAnimated("¡Alerta!", "Por favor ingrese una cantidad validad.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                                }
                            }
                        } else {//Si presiona el boton SI
                            //<Componentes>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                            //Registro te tiempo de componentes
                            if (JOptionPane.showOptionDialog(null, "¿Seguro desea terminar la toma de tiempos de los componentes.", "Seguridad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null/*icono*/, botones, botones[0]) == 0) {
                                idDetalle = String.valueOf(TDetalleProduccion.getValueAt(row, 13));//Identificador
                                String orden[] = this.getTitle().split("-");                                         //Cantidad//   
                                almacen.pararTiempoAlmacen(Integer.parseInt(orden[0].trim()), Integer.parseInt(idDetalle), 0, detalle, 23);//
                                //Mensaje de confirmación de la terminación de la toma de tiempo
                                new rojerusan.RSNotifyAnimated("¡Listo!", "Mensaje___.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                                cargarTabla();
                            }
                        }
                    }
                    //------------------------------------------------------------
                } else {
                    //Boton para reiniciar la toma de tiempo(Solo lo puede realizar el administrador)
                    if (boton.getActionCommand().equals("1")) {
                        if (JOptionPane.showOptionDialog(null, "¿Seguro desea reinicializar la toma de tiempo? Perdera toda esta información.", "Seguridad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null/*icono*/, botones, botones[0]) == 0) {
                            String idDetalle = String.valueOf(TDetalleProduccion.getValueAt(row, 13));//Identificador!!
                            DetalleProyecto obj = new DetalleProyecto();
                            if (obj.ReiniciarDetalle(Integer.parseInt(idDetalle), negocio, detalle)) {///Pendiente???¿¿¿???¿¿¿XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                                new rojerusan.RSNotifyAnimated("¡Listo!", "El proceso: " + TDetalleProduccion.getValueAt(row, 0) + " fue reinicializado corresctamente.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                                cargarTabla();
                            } else {
                                new rojerusan.RSNotifyAnimated("¡Error!", "El proceso: " + TDetalleProduccion.getValueAt(row, 0) + " no pudo ser reinicializado.", 7, RSNotifyAnimated.PositionNotify.BottomRight, RSNotifyAnimated.AnimationNotify.BottomUp, RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_TDetalleProduccionMouseClicked

    private void TDetalleProduccionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDetalleProduccionMouseReleased
        if (negocio != 4) {
            if (evt.isPopupTrigger()) {
                popMenu.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_TDetalleProduccionMouseReleased
//one day baby, i thiking but
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        cargarTabla();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cargarTabla() {
        Tabla personalizar = new Tabla();
        personalizar.visualizar(TDetalleProduccion, detalle, negocio);
        try {
            DetalleProyecto obj = new DetalleProyecto();
            crs = obj.ConsultarInformacionFiltrariaDelDetalle(detalle);
            crs.next();
            jTNombreCliente.setText("  " + crs.getString(1));
            jTNombreProyecto.setText("  " + crs.getString(2));
            jTFechaIngreso.setText("  " + crs.getString(3));
            jTFechaEntrega.setText("  " + crs.getString(4));
            jTCantidadTotal.setText("  " + crs.getString(5));
            jTTimepoTotal.setText("  " + crs.getString(6));
            jTFechaIngreso1.setText("  " + (crs.getString(7) == null ? "" : crs.getString(7)));
            jTFechaIngreso2.setText("  " + (crs.getString(8) == null ? "" : crs.getString(7)));
            jTFechaIngreso3.setText("  " + (crs.getString(9) == null ? "" : crs.getString(7)));
            jTFechaIngreso4.setText("  " + (crs.getString(10) == null ? "" : crs.getString(7)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!! " + e);
        }

        if (permiso == 1 || negocio == 4) {
            editarTamañoColumnas();
            if (negocio == 4) {
                TDetalleProduccion.getColumnModel().getColumn(6).setMinWidth(0);
                TDetalleProduccion.getColumnModel().getColumn(6).setMaxWidth(0);
                TDetalleProduccion.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
                TDetalleProduccion.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
//                TDetalleProduccion.getColumnModel().getColumn(8).setMinWidth(0);
//                TDetalleProduccion.getColumnModel().getColumn(8).setMaxWidth(0);
//                TDetalleProduccion.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
//                TDetalleProduccion.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
            }
        }
        if (negocio != 4) {
            TDetalleProduccion.getColumnModel().getColumn(14).setMinWidth(0);
            TDetalleProduccion.getColumnModel().getColumn(14).setMaxWidth(0);
            TDetalleProduccion.getTableHeader().getColumnModel().getColumn(14).setMaxWidth(0);
            TDetalleProduccion.getTableHeader().getColumnModel().getColumn(14).setMinWidth(0);
        }
        TDetalleProduccion.getColumnModel().getColumn(13).setMinWidth(0);
        TDetalleProduccion.getColumnModel().getColumn(13).setMaxWidth(0);
        TDetalleProduccion.getTableHeader().getColumnModel().getColumn(13).setMaxWidth(0);
        TDetalleProduccion.getTableHeader().getColumnModel().getColumn(13).setMinWidth(0);
    }

    public void editarTamañoColumnas() {
        TDetalleProduccion.getColumnModel().getColumn(12).setMinWidth(0);
        TDetalleProduccion.getColumnModel().getColumn(12).setMaxWidth(0);
        TDetalleProduccion.getTableHeader().getColumnModel().getColumn(12).setMaxWidth(0);
        TDetalleProduccion.getTableHeader().getColumnModel().getColumn(12).setMinWidth(0);
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
            java.util.logging.Logger.getLogger(detalleProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                detalleProyecto dialog = new detalleProyecto(new javax.swing.JFrame(), true, 0, 0, "", 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TDetalleProduccion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPInformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTCantidadTotal;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTFechaEntrega;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTFechaIngreso;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTFechaIngreso1;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTFechaIngreso2;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTFechaIngreso3;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTFechaIngreso4;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNombreCliente;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTNombreProyecto;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTTimepoTotal;
    public static elaprendiz.gui.textField.TextFieldRoundBackground jTTimepoTotalUnidad;
    private javax.swing.JPopupMenu popMenu;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
