/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

/**
 *
 * @author comunicaciones03
 */
public class ejecutarPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GenerarPDF gr= new GenerarPDF();
        gr.generarPDF("QR del proyecto 28400","En este formato se generaran todos lo QR para cada proyecto"+"\n"
                + "--------------------------------------------------------------------------------------------------------"
                 , "Juan David Marulanda P", "C://Users/comunicaciones03/28401.png", "C:\\Users\\comunicaciones03\\Proyecto28400.pdf");
    }
    
}
