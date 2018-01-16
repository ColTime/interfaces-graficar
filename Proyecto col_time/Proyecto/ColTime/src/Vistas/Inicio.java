package Vistas;

import Controlador.Proyecto;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.sql.rowset.CachedRowSet;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JPanel {

    public Inicio() {
        initComponents();
        fechaYdatosProduccion();
    }
    //Variables
    String inicio = "";
    String finali = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLFecha = new javax.swing.JLabel();
        jLCantidadF = new javax.swing.JLabel();
        jLCantidadT = new javax.swing.JLabel();
        jLCantidadE = new javax.swing.JLabel();
        jLCantidadP = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLCantidadA = new javax.swing.JLabel();

        setBackground(new java.awt.Color(219, 219, 219));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("inicio"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(128, 128, 131)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Inicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(128, 128, 131))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesEmpresa/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Áreas");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(219, 219, 219)));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Numero de proyectos:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Proyectos de Formato estandar:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Proyectos de Teclados:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Proyectos de Ensamble:");

        jLFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLFecha.setText("Fecha: dd/mm/yyyy");

        jLCantidadF.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLCantidadF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCantidadF.setText("0");

        jLCantidadT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLCantidadT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCantidadT.setText("0");

        jLCantidadE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLCantidadE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCantidadE.setText("0");

        jLCantidadP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLCantidadP.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Proyectos de Almacen:");

        jLCantidadA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLCantidadA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCantidadA.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLCantidadP, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                        .addGap(307, 307, 307))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLCantidadF, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLCantidadT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCantidadE, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLCantidadA, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLFecha)
                    .addComponent(jLCantidadP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8)
                        .addComponent(jLCantidadF))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(8, 8, 8)
                        .addComponent(jLCantidadA))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(jLCantidadE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(jLCantidadT)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
//Muestra la estadistica de las areas y permitira buscar por rango de fechas
//Falta el diagrama de cantidad de proyecto de a´reas de produccion con el rango de fechas--------------------------------------------------------------------------->
//Tener en cuenta que lo reportes tiene que cargar los proceso que esten activos desde la base de datos, coregirlo porque se hizo quemado.
        proyecto1 diagrama = new proyecto1();
        Object obj[] = null;
        int bus = 0;
        int tipo = 1;
        Object diag = null;
        Object fech = null;
        Object busqueda = JOptionPane.showInputDialog(new JComboBox(),
                "Seleccione el diagrama",
                "Selector de opciones",
                JOptionPane.QUESTION_MESSAGE,
                null, // null para icono defecto
                new Object[]{"Cantidad proyectos área", "Procesos FE", "Procesos TE", "Procesos EN"},
                "Cantidad proyectos área");

        if (busqueda != null) {
            if (busqueda.equals("Cantidad proyectos área")) {
                if (busqueda.equals("Cantidad proyectos área")) {
                    obj = new Object[]{"Barras verticales", "Barras horizontal", "Torta"};
                }
                diag = JOptionPane.showInputDialog(new JComboBox(),
                        "Seleccione el estilo del diagrama",
                        "Selector de opciones",
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null para icono defecto
                        obj,
                        "Barras verticales");
                if (diag != null) {
                    //Tipo de busqueda
                    if (busqueda.equals("Cantidad proyectos área")) {
                        bus = 1;
                        //Tipo de diagrama
                        tipo = 0;
                        if (diag.equals("Barras verticales")) {
                            tipo = 1;
                        } else if (diag.equals("Barras horizontal")) {
                            tipo = 2;
                        } else {
                            tipo = 3;
                        }
                    }
                    //Fecha de inicio y fin
                    String s = "";
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

                    JDateChooser ini = new JDateChooser();
                    ini.setName("Inicio");
                    String message = "Fecha de inicio:\n";
                    Object[] params = {message, ini};
                    JOptionPane.showConfirmDialog(null, params, "Fechas", JOptionPane.PLAIN_MESSAGE);

                    if (ini.getDate() != null) {
                        inicio = formato.format(ini.getDate());//fecha de inicio

                        JDateChooser fin = new JDateChooser();
                        fin.setName("Fin");
                        message = "Fecha de inicio:\n";
                        Object[] params1 = {message, fin};
                        JOptionPane.showConfirmDialog(null, params1, "Fechas", JOptionPane.PLAIN_MESSAGE);
                        if (fin.getDate() != null) {
                            finali = formato.format(fin.getDate());//Fecha de finalizacion
                        }
                    }
                }
            } else {
                if (busqueda.equals("Procesos FE")) {
                    bus = 2;
                    tipo = 1;
                } else if (busqueda.equals("Procesos TE")) {
                    bus = 3;
                    tipo = 1;
                } else {
                    bus = 4;
                    tipo = 1;
                }
            }
            Controlador.Diagramas dia = new Controlador.Diagramas();
            dia.EnrutamientoProceso(tipo, bus, inicio, finali);
        }
    }//GEN-LAST:event_jLabel6MouseReleased

    //Variables
    CachedRowSet crs = null;//Cantidad de proyectos para cada área respectiva
    //Metodos de la calse inicio

    public ImageIcon llamarDiagramas(int tipoDiagrama, int busqueda) {
        Controlador.Diagramas obj = new Controlador.Diagramas();
        return obj.graficaCantidad(tipoDiagrama, 0, "", "");
    }

    private void fechaYdatosProduccion() {
        try {
            Proyecto obj = new Proyecto();
            crs = obj.fechaYdatosProduccion();
            //Hora y formato estandar
            cantidadArea(crs);
        } catch (Exception e) {
            //Mensaje de alerta
            JOptionPane.showMessageDialog(null, "Error! Fecha y datos de producción" + e);
        }
    }

    private void cantidadArea(CachedRowSet crsf) {
        try {
            while (crsf.next()) {
                jLFecha.setText("Fecha: " + crsf.getString(1));
                jLCantidadP.setText(crsf.getString(3));
                if (crsf.getString(4).equals("1")) {
                    jLCantidadF.setText(crsf.getString(2));
                } else if (crsf.getString(4).equals("2")) {
                    jLCantidadT.setText(crsf.getString(2));
                } else if (crsf.getString(4).equals("3")) {
                    jLCantidadE.setText(crsf.getString(2));
                } else {
                    jLCantidadA.setText(crsf.getString(2));
                }
            }
        } catch (Exception e) {
            //Mensaje de error del proceso...
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLCantidadA;
    private javax.swing.JLabel jLCantidadE;
    private javax.swing.JLabel jLCantidadF;
    private javax.swing.JLabel jLCantidadP;
    private javax.swing.JLabel jLCantidadT;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
 @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
