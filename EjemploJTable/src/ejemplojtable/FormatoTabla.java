/**
 * @author Monillo007
 * :: Visita http://monillo007.blogspot.com ::
 */
package ejemplojtable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

//Implementa la interfaz TableCellRenderer que servirá para dar formato a la tabla
public class FormatoTabla implements TableCellRenderer{
    
    //Sobreescribimos el método getTableCellRendererComponent para poder formatear los componentes
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        //campoTexto nos sirve como componente dentro de la tabla, es cada una de las celdas de la misma
        JFormattedTextField campoTexto = new JFormattedTextField();
        //Se establece primeramente un borde vacío o sin borde
        campoTexto.setBorder(BorderFactory.createEmptyBorder());
        
        //Si el valor que contiene actualmente es cadena se establece el valor sin formatear en ningún sentido
        if(value instanceof String){
            System.out.println("String value = " + value);
            campoTexto.setText((String)value);
        }
        //Si el valor que contiene actualmente es entero se establece el valor y se alinea al centro 
        if(value instanceof Integer){
            System.out.println("Integer value = " + value);
            campoTexto.setText(value+"");
            campoTexto.setHorizontalAlignment(SwingConstants.CENTER);
        }
        //Si el valor que contiene actualmente es Double se establece el valor
        //y se le aplica un formato para agregar comas cada tres dítigos
        if(value instanceof Double){
            System.out.println("Double value = " + value);
            Double valor = (Double)value;
            campoTexto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00")))); 
            //Se aplica alineación a la izquierda
            campoTexto.setHorizontalAlignment(SwingConstants.TRAILING); 
            campoTexto.setValue(valor);
            
            //Si el valor es negativo se elimina el símbolo - y se establece un fondo de color rojo
            if(valor.compareTo(new Double(0))==-1) { 
              campoTexto.setText(campoTexto.getText().replace("-", "")); 
              campoTexto.setBackground(new Color(0xFE899B)); 
              campoTexto.setOpaque(true); 
            }
        }
        
        //Se verifica si el último valor de la fila es negativo para establecer todas las celdas de dicha fila en color rojo
        if(((Double)table.getValueAt(row, table.getColumnCount()-1)).compareTo(new Double(0))==-1){ 
            campoTexto.setBackground(new Color(0xFE899B)); 
            campoTexto.setOpaque(true); 
        }
        
        //Si el campo está seleccionado se establece un color gris para distinguir
        if(isSelected){ 
            campoTexto.setBackground(Color.lightGray); 
        }
        
        //Por último se devuelve el componente ya con el formato establecido para mostrarlo en la tabla
        return campoTexto;
    }
    
}
