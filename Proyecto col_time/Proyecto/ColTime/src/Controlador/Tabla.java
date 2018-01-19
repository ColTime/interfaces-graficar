package Controlador;

import java.awt.Cursor;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla {

    private boolean[] editable = {false, false, false, false, false, false, false, false, false, false, false, false};//Que celdas son editables
    private static int detalle = 0, negocio = 0;
    private CachedRowSet crs = null;

    //Se encarga de generar la tabla con la informacion traida de la base de datos
    public void visualizar(JTable tabla, int detalle, int negocio) {
        this.detalle = detalle;
        this.negocio = negocio;
        tabla.setDefaultRenderer(Object.class, new Render(7));
        String encabezado[] = {"Proceso", "Fecha inicio", "Fecha fin", "Restante", "Cantidad procesada", "Tiempo total min", "Tiempo unidad min", "Estado", "Hora de ejecución", "Tiempo Ejecución", "Hora de Terminación", "N°OP", "Reiniciar", "IDdetalle", "Tiempo"};
        DefaultTableModel ds = new DefaultTableModel(null, encabezado) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };

        Object v[] = new Object[15];

        try {
            crs = consuldateDetalleProduccion();
            while (crs.next()) {
                JButton btn = new JButton("Reiniciar");
                JButton tiempo = new JButton("Tiempo");
//                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

                v[0] = crs.getString(1);
                v[1] = crs.getString(2);
                v[2] = crs.getString(3);
                v[3] = negocio != 4 ? crs.getString(13) : "0";
                v[4] = String.valueOf(crs.getInt(4));
                v[5] = crs.getString(5);
                v[6] = crs.getString(6);
                v[7] = crs.getString(7);//Estado del producto
                v[8] = crs.getString(8);
                if (crs.getString(11) != null) {
                    v[9] = crs.getString(11);
                } else {
                    v[9] = crs.getString(9);
                }
                v[10] = crs.getString(10);
                v[11] = negocio != 4 ? crs.getString(14) : "0";//Numero de operarios---
                v[12] = btn;//Este boton se utiliza para que el administrador pueda reiniciar la toma de tiempo de los procesos de  FE/TE/EN
                v[13] = crs.getString(12);//IDDetalle
                v[14] = tiempo;//Este boton se utiliza para parar el tiempo de los procesos de almacen.
                ds.addRow(v);//Filas de la tabla
            }
            tabla.setModel(ds);
//            FormatoTabla ft = new FormatoTabla(6);
//            tabla.setDefaultRenderer(Object.class, ft);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!" + e);
        }
    }

    //Se encarga de traer la informacion de la base de datos
    private CachedRowSet consuldateDetalleProduccion() {
        DetalleProyecto obj = new DetalleProyecto();
        return obj.consultarDetalleProduccion(detalle, negocio);
    }

}
