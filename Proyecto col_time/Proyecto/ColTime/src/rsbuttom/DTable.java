/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsbuttom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Administrador
 */
public class DTable extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer render, int rowIndex, int ColumnaIndex) {
        Component componente = super.prepareRenderer(render, rowIndex, ColumnaIndex);
        if (this.getValueAt(rowIndex, ColumnaIndex).equals("Normal")) {
            componente.setBackground(Color.BLUE);
            
        } else if (this.getValueAt(rowIndex, ColumnaIndex).equals("Quick")) {

        } else if (this.getValueAt(rowIndex, ColumnaIndex).equals("RQT")) {

        }

        return componente;
    }
}
