package Controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.sql.rowset.CachedRowSet;

public class generarPDF {
    //Lo voy hacer con la libreria ireport y jaspertreport
    public void genera_PDF(CachedRowSet crs) {
        try {
            PdfPTable tabla = new PdfPTable(8);
            PdfPCell header = new PdfPCell(new Paragraph("Reporte General"));
            Image logo = Image.getInstance("src\\imagenesEmpresa\\logo.png");
            logo.scaleAbsolute(300, 125);
            logo.setAlignment(Image.ALIGN_CENTER);

            header.setBorder(Rectangle.NO_BORDER);
            header.setColspan(8);
            tabla.addCell(header);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{3, 3, 3});
            //se creo y se abrio el documento
            Document doc = new Document(PageSize.A4, 20, 20, 30, 30);
            //se obtine la ruta del proyecto en tiempo de ejecucion.
            String ruta = System.getProperty("user.dir");
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(ruta + "\\PDF\\" + "ReporteGeneral" + ".pdf"));
            doc.open();
            doc.add(logo);
            while (crs.next()) {
                
                PdfPCell celda = new PdfPCell();
                celda.setBorder(Rectangle.NO_BORDER);
                tabla.addCell(celda);
               
            }
            crs.close();
            header.setBorder(Rectangle.NO_BORDER);
            header.addElement(new Paragraph());
            header.setColspan(3);
            tabla.addCell(header);
            doc.add(tabla);
            doc.close();
        } catch (Exception e) {
        }
    }
}
