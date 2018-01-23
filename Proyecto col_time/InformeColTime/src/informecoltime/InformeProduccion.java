package informecoltime;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class InformeProduccion extends javax.swing.JFrame implements Runnable {

    public InformeProduccion() {
        initComponents();
        this.setExtendedState(InformeProduccion.MAXIMIZED_BOTH);
        Thread iniciar = new Thread(this);
        iniciar.start();
    }
    //Variable
    CachedRowSet crs = null;
    int cont = 1;

    private void centrarContenidoCeldas() {
        for (int i = 0; i < ReporteProduccion.getColumnCount(); i++) {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            ReporteProduccion.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                ConsultarInformacion(0);
//                centrarContenidoCeldas();
//                editarCerlas();
//                JOptionPane.showMessageDialog(null, "Interaccion " + cont);
                cont++;
                Thread.sleep(60000);//60 segundos
            } catch (Exception e) {

            }
        }
    }

    private void ConsultarInformacion(int orden) {
        //Concultar
        Logica obj = new Logica();
        String encabezado[] = {"N°Orden", "Ubicaciòn", "Estado"};
        String cuerpo[] = new String[3];
        String proceso = "";
        DefaultTableModel modelo = new DefaultTableModel(null, encabezado);
        try {
            //Cuerpo...
            for (int i = 1; i <= 3; i++) {
                //Este ciclo va hacer que pase por todas las areas
                crs = obj.ConsultarInformacion(i, orden);
                //Validaciones
                while (crs.next()) {
                    cuerpo[0] = crs.getString(1);//Numero de la orden
                    cuerpo[1] = crs.getString(2);//Área de negocio
                    cuerpo[2] = "A tiempo";//Producto
                    switch (i) {
                        //Formato estandar
                        case 1:
                            //Procesos
                            switch (crs.getInt(4)) {
                                case 1:
                                    proceso = "Perforado";
                                    break;
                                case 2:
                                    proceso = "Químicos";
                                    break;
                                case 3:
                                    proceso = "Caminos";
                                    break;
                                case 4:
                                    proceso = "Quemado";
                                    break;
                                case 5:
                                    proceso = "C.C.TH";
                                    break;
                                case 6:
                                    proceso = "Screen";
                                    break;
                                case 7:
                                    proceso = "Estañado";
                                    break;
                                case 8:
                                    proceso = "C.C.2";
                                    break;
                                case 9:
                                    proceso = "Ruteo";
                                    break;
                                case 10:
                                    proceso = "Maquinas";
                                    break;
                            }
                            break;
                        //Teclados
                        case 2:
                            //Procesos
                            switch (crs.getInt(4)) {
                                case 11:
                                    proceso = "Correas y conversor";
                                    break;
                                case 12:
                                    proceso = "Lexan";
                                    break;
                                case 13:
                                    proceso = "Acople";
                                    break;
                                case 14:
                                    proceso = "Control calidad";
                                    break;
                            }
                            break;
                        //Ensamble
                        case 3:
                            //Procesos
                            switch (crs.getInt(4)) {
                                case 15:
                                    proceso = "Manual";
                                    break;
                                case 16:
                                    proceso = "Limpieza";
                                    break;
                                case 17:
                                    proceso = "Control calidad";
                                    break;
                                case 18:
                                    proceso = "Empaque";
                                    break;
                                case 19:
                                    proceso = "Stencil";
                                    break;
                                case 20:
                                    proceso = "Linea";
                                    break;
                                case 21:
                                    proceso = "Arnes";
                                    break;
                            }
                            break;
                    }
//                    cuerpo[3] = proceso;//Proceso de ubicación
//                    if (Integer.parseInt(crs.getString(5)) < 0) {
//                        cuerpo[4] = "Retrasado: " + crs.getString(5);//Tiempo de entrega
//                    } else {
//                        cuerpo[4] = crs.getString(5);//Tiempo de entrega
//                    }
//                    cuerpo[5] = crs.getString(5);
                    modelo.addRow(cuerpo);
                }
            }
            ReporteProduccion.setModel(modelo);//Se agrega el modelo a la tabla
            FormatoTabla format = new FormatoTabla(5);
            ReporteProduccion.setDefaultRenderer(Object.class, format);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReporteProduccion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1456, 1456));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ReporteProduccion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        ReporteProduccion.setAutoCreateRowSorter(true);
        ReporteProduccion.setFont(new java.awt.Font("Arial", 0, 32)); // NOI18N
        ReporteProduccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°Orden", "Ubicaciòn", "Estado"
            }
        ));
        ReporteProduccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ReporteProduccion.setEditingColumn(0);
        ReporteProduccion.setEditingRow(0);
        ReporteProduccion.setFillsViewportHeight(true);
        ReporteProduccion.setGridColor(new java.awt.Color(0, 0, 0));
        ReporteProduccion.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ReporteProduccion.setRowHeight(60);
        ReporteProduccion.setSelectionBackground(new java.awt.Color(97, 176, 255));
        ReporteProduccion.setSelectionForeground(new java.awt.Color(0, 0, 0));
        ReporteProduccion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ReporteProduccion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(InformeProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformeProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformeProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformeProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformeProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ReporteProduccion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
