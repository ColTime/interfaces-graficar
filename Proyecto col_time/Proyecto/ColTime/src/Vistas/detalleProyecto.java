package Vistas;

import Controlador.DetalleProyecto;
import Controlador.FormatoTabla;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class detalleProyecto extends javax.swing.JDialog {

    public detalleProyecto(java.awt.Frame parent, boolean modal, int detalle, int negocio, String orden, String tipo) {
        super(parent, modal);
        initComponents();
        this.setTitle(orden + " - " + tipo);
        this.detalle = detalle;
        this.negocio = negocio;
        this.setLocationRelativeTo(null);
        cargarTabla();
    }
    //variables
    private CachedRowSet crs = null;
    private int detalle = 0;
    private int negocio = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TDetalleProduccion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1195, 300));
        setPreferredSize(new java.awt.Dimension(900, 300));

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
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Proceso", "Fecha inicio", "Fecha fin", "Cantidad Procesada", "Tiempo total min", "Tiempo por unidad min", "Estado", "Hora Ejecucion", "Tiempo Ejecucion", "Hora Terminacion"
            }
        ));
        TDetalleProduccion.setFillsViewportHeight(true);
        TDetalleProduccion.setFocusTraversalPolicyProvider(true);
        TDetalleProduccion.setFocusable(false);
        TDetalleProduccion.setGridColor(new java.awt.Color(255, 255, 255));
        TDetalleProduccion.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TDetalleProduccion.setMinimumSize(new java.awt.Dimension(900, 300));
        TDetalleProduccion.setSelectionBackground(new java.awt.Color(63, 179, 255));
        TDetalleProduccion.setShowHorizontalLines(false);
        TDetalleProduccion.setShowVerticalLines(false);
        jScrollPane3.setViewportView(TDetalleProduccion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
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

    private CachedRowSet consuldateDetalleProduccion() {
        DetalleProyecto obj = new DetalleProyecto();
        return obj.consultarDetalleProduccion(detalle, negocio);
    }

    private void cargarTabla() {
        String encabezado[] = {"Proceso", "Fecha inicio", "Fecha fin", "Cantidad procesada", "Tiempo total min", "Tiempo unidad min", "Estado", "Hora de ejecución", "Tiempo Ejecución", "Hora de Terminación"};
        DefaultTableModel ds = new DefaultTableModel(null, encabezado);
        String v[] = new String[10];
        try {
            crs = consuldateDetalleProduccion();
            while (crs.next()) {
                v[0] = crs.getString(1);
                v[1] = crs.getString(2);
                v[2] = crs.getString(3);
                v[3] = String.valueOf(crs.getInt(4));
                v[4] = crs.getString(5);
                v[5] = crs.getString(6);
                v[6] = crs.getString(7);
                v[7] = crs.getString(8);
                if (crs.getString(10) != null) {
                    v[8] = crs.getString(11);
                } else {
                    v[8] = crs.getString(9);
                }
                v[9] = crs.getString(10);
                ds.addRow(v);
            }
            TDetalleProduccion.setModel(ds);
            FormatoTabla ft = new FormatoTabla(6);
            TDetalleProduccion.setDefaultRenderer(Object.class, ft);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }

    }

    //La funcion de este metodo es cambiar el color de la celda estada deacuedo a l contenido de este
    private void ColorCeldas() {
        int filas = TDetalleProduccion.getRowCount();
        for (int i = 0; i < filas; i++) {
            String estado = TDetalleProduccion.getValueAt(i, 6).toString();
            if (estado.equals("Ejecucion")) {

            }
        }
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
                detalleProyecto dialog = new detalleProyecto(new javax.swing.JFrame(), true, 0, 0, "", "");
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
