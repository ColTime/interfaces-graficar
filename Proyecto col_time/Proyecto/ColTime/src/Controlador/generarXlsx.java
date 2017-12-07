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

    public void generarExcel(String[][] info, String ruta) {
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            WritableWorkbook woorBook = Workbook.createWorkbook(new File(ruta));

            WritableSheet sheet = woorBook.createSheet("Reporte General", 0);
            WritableFont h = new WritableFont(WritableFont.COURIER, 16, WritableFont.NO_BOLD);
            WritableCellFormat hFormat = new WritableCellFormat(h);

            for (int i = 0; i < info.length; i++) {
                for (int j = 0; j < info.length; j++) {
                    sheet.addCell(new jxl.write.Label(i, j, info[i][j], hFormat));
                }
            }
            woorBook.write();

            woorBook.close();

        } catch (Exception e) {
            //Mensaje de exepción...
        }

    }
}
