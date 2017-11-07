package Controlador;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static org.apache.poi.hslf.model.ShapeTypes.types;

public class Tabla {

    private boolean[] editable = {false, false, false, true};

    public void visualizar(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel model = new DefaultTableModel(null, new String[]{"Nombre", "Apellido", "Telefono", "Estado"}) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };
        JButton reiniciarTiempo = new JButton("Reiniciar");
        reiniciarTiempo.setName("9");

        Object row[] = new Object[4];

        for (int i = 0; i < 4; i++) {
            row[0] = "juan";
            row[1] = "marulanda";
            row[2] = "2528099";
            row[3] = reiniciarTiempo;
            model.addRow(row);
        }
        tabla.setModel(model);
    }
}
