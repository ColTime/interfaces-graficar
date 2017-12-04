package informecoltime;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer {

    private int comlumna_patron;

    public FormatoTabla(int colPatron) {
        this.comlumna_patron = colPatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (Integer.parseInt(table.getValueAt(row, comlumna_patron).toString()) == 0) {
            setBackground(Color.white);
        } else if (Integer.parseInt(table.getValueAt(row, comlumna_patron).toString()) < 0) {
            setBackground(Color.ORANGE);
        } else if (Integer.parseInt(table.getValueAt(row, comlumna_patron).toString()) > 0) {
            setBackground(Color.GREEN);
        }
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        return this;
    }

}
