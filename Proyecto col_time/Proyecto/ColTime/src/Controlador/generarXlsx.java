package Controlador;

import java.io.File;
import javax.sql.rowset.CachedRowSet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class generarXlsx {

    public boolean generarExcel(CachedRowSet crs, String ruta) {
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            WritableWorkbook woorBook = Workbook.createWorkbook(new File(ruta + "\\ReporteGeneral.xls"));

            WritableSheet sheet = woorBook.createSheet("Reporte General", 0);
            WritableFont h = new WritableFont(WritableFont.COURIER, 16, WritableFont.NO_BOLD);
            WritableCellFormat hFormat = new WritableCellFormat(h);
            int i = 0;
            //Numero de orden
            sheet.addCell(new jxl.write.Label(0, i, "Numero de orden", hFormat));
            //Nombre del cliente
            sheet.addCell(new jxl.write.Label(1, i, "Nombre del cliente", hFormat));
            //Nombre del proyecto
            sheet.addCell(new jxl.write.Label(2, i, "Nombre del proyecto", hFormat));
            //Cantidad
            sheet.addCell(new jxl.write.Label(3, i, "Cantidad", hFormat));
            //Área de negocio
            sheet.addCell(new jxl.write.Label(4, i, "Área", hFormat));
            //Tipo negocio
            sheet.addCell(new jxl.write.Label(5, i, "Tipo de negocio", hFormat));
            //Tiempo total unidad 
            sheet.addCell(new jxl.write.Label(6, i, "Timepo total unidad", hFormat));
            //Timepo total
            sheet.addCell(new jxl.write.Label(7, i, "Timepo total", hFormat));
            i++;
            while (crs.next()) {
                //Numero de orden
                sheet.addCell(new jxl.write.Label(0, i, crs.getString(1), hFormat));
                //Nombre del cliente
                sheet.addCell(new jxl.write.Label(1, i, crs.getString(2), hFormat));
                //Nombre del proyecto
                sheet.addCell(new jxl.write.Label(2, i, crs.getString(3), hFormat));
                //Cantidad
                sheet.addCell(new jxl.write.Label(3, i, crs.getString(4), hFormat));
                //Área de negocio
                sheet.addCell(new jxl.write.Label(4, i, crs.getString(5), hFormat));
                //Tipo negocio
                sheet.addCell(new jxl.write.Label(5, i, crs.getString(6), hFormat));
                //Tiempo total unidad 
                sheet.addCell(new jxl.write.Label(6, i, crs.getString(7), hFormat));
                //Timepo total
                sheet.addCell(new jxl.write.Label(7, i, crs.getString(8), hFormat));
                i++;
            }

//            for (int i = 0; i < info.length; i++) {
//                for (int j = 0; j < info.length; j++) {
//                    sheet.addCell(new jxl.write.Label(i, j, info[i][j], hFormat));
//                }
//            }
            woorBook.write();

            woorBook.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
