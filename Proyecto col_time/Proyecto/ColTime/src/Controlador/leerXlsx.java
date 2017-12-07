package Controlador;

import com.itextpdf.text.pdf.hyphenation.TernaryTree;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class leerXlsx {

//    public leerXlsx(File fileName) {
//        List cellData = new ArrayList();
//
//        try {
//            //Un FileInputStream obtiene los bytes de entrada desde un archivo en us sistema de archivos
//            FileInputStream fileInput = new FileInputStream(fileName);
//            XSSFWorkbook workBook = new XSSFWorkbook(fileInput);
//            //XSSFSheet es la parte central de nunstro documento
//            XSSFSheet hssfSheet = workBook.getSheetAt(0);
//            //RowIterator es un interactor de filas o hileras 
//            Iterator rowIterator = hssfSheet.rowIterator();
//            //Recorremos todas las filas que tenga el documento xlsx
//            //El hasNext devuleve verdadero si la interacion tiene mas elementos
//            while (rowIterator.hasNext()) {
//                //Esta line nos va a permitir hacer salto de linia a la siguiente fila
//                XSSFRow hssRow = (XSSFRow) rowIterator.next();
//                //Almacenamos los datos de la interaccion
//                Iterator interator = hssRow.cellIterator();
//                List cellTemp = new ArrayList();
//                //Nos movemos por todas las columnas que tenga la fila
//                while (interator.hasNext()) {
//                    //Almacenaremos los datos en el hssFcell
//                    XSSFCell hssFcell = (XSSFCell) interator.next();
//                    //Y almacenaremos los datos en una lista temporal
//                    cellTemp.add(hssFcell);
//                }
//                //Y despues todos los datos almacenados en la variable temporal las asignaremos al cellData
//                cellData.add(cellTemp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //Llamamos al metodo obtener para poder utilizar la información
//        obtener(cellData);
//    }
//
//    public void obtener(List cellDataList) {
//        for (int i = 0; i < cellDataList.size(); i++) {
//            //Obtenemos los datos de el cellDataList y los almacenamos en una variable temporal
//            List CellTemporal = (List) cellDataList.get(i);
//            for (int j = 0; j < CellTemporal.size(); j++) {
//                XSSFCell hssCell = (XSSFCell) CellTemporal.get(j);
//                //Convertimos el dato obtenido a String
//                String stringCellValue = hssCell.toString();
//                System.out.print(stringCellValue + "  ");
//            }
//            System.out.println();
//            System.out.println();
//        }
//    }

//    public static void main(String[] args) {
//        File obj = new File("C:\\Users\\Aprendiz\\Desktop\\actual\\prueba.xlsx");
//        if (obj.exists()) {
//            leerXlsx probando = new leerXlsx(obj);
//        }
//    }

}
