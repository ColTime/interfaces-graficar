package informecoltime;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer {
    
    private int comlumna_patron;
    
    public FormatoTabla(int colPatron) {
        this.comlumna_patron = colPatron;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (row == 0) {
            table.getTableHeader().setFont(new Font("Arial", 1, 24));
//            table.getTableHeader().setAlignmentX(40);
            //Editar tamaño de columnas
//            table.getColumnModel().getColumn(0).setMinWidth(160);
//            table.getColumnModel().getColumn(0).setMaxWidth(160);
//            table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(160);
//            table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(160);
//            table.getColumnModel().getColumn(1).setMinWidth(200);
//            table.getColumnModel().getColumn(1).setMaxWidth(200);
//            table.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(200);
//            table.getTableHeader().getColumnModel().getColumn(1).setMinWidth(200);
//            table.getColumnModel().getColumn(2).setMinWidth(250);
//            table.getColumnModel().getColumn(2).setMaxWidth(250);
//            table.getTableHeader().getColumnModel().getColumn(2).setMaxWidth(250);
//            table.getTableHeader().getColumnModel().getColumn(2).setMinWidth(250);
//            table.getColumnModel().getColumn(3).setMinWidth(450);
//            table.getColumnModel().getColumn(3).setMaxWidth(450);
//            table.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(450);
//            table.getTableHeader().getColumnModel().getColumn(3).setMinWidth(450);
//            table.getColumnModel().getColumn(4).setMinWidth(338);
//            table.getColumnModel().getColumn(4).setMaxWidth(338);
//            table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(338);
//            table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(338);
//            table.getColumnModel().getColumn(5).setMinWidth(0);
//            table.getColumnModel().getColumn(5).setMaxWidth(0);
//            table.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
//            table.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        }
//        if (Integer.parseInt(table.getValueAt(row, comlumna_patron).toString()) == 0) {
//            setBackground(Color.white);
//        } else if (Integer.parseInt(table.getValueAt(row, comlumna_patron).toString()) < 0) {
//            setBackground(Color.ORANGE);
//        } else if (Integer.parseInt(table.getValueAt(row, comlumna_patron).toString()) > 0) {
//            setBackground(Color.GREEN);
//        }
        //Centralizar texto de celdas
        this.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(column).setCellRenderer(this);
        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        return this;
    }
    
}
