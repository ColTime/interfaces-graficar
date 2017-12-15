package Controlador;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer {

    private int columna_patron;

    public FormatoTabla(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        setBackground(Color.white);//color de fondo
        table.setForeground(Color.black);//color de texto
        //Si la celda corresponde a una fila con estado FALSE, se cambia el color de fondo a rojo
        if (table.getName().equals("Proyecto")) {
            if (table.getValueAt(row, 16).toString().equals("1")) {
                if (table.getValueAt(row, columna_patron).equals("Por iniciar")) {
                    setBackground(Color.white);
                } else if (table.getValueAt(row, columna_patron).equals("Pausado")) {
                    setBackground(Color.ORANGE);
                } else if (table.getValueAt(row, columna_patron).equals("Terminado")) {
                    setBackground(Color.GREEN);
                } else if (table.getValueAt(row, columna_patron).equals("Ejecucion")) {
                    setBackground(Color.gray);
                }
            } else {
                setBackground(Color.red);
            }
        } else {
            if (table.getValueAt(row, columna_patron).equals("Por iniciar")) {
                setBackground(Color.white);
            } else if (table.getValueAt(row, columna_patron).equals("Pausado")) {
                setBackground(Color.ORANGE);
            } else if (table.getValueAt(row, columna_patron).equals("Terminado")) {
                setBackground(Color.GREEN);
            } else if (table.getValueAt(row, columna_patron).equals("Ejecucion")) {
                setBackground(Color.gray);
            } else if (table.getValueAt(row, columna_patron).equals("Parada")) {
                setBackground(Color.RED);
            }
        }

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
