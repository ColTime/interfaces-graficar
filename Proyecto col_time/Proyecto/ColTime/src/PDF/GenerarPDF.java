/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author comunicaciones03
 */
public class GenerarPDF {

    private Font fuente = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);
    private Font fuenteItalica = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);

    public void generarPDF(String header, String info, String footer, String rutaimagen, String salida) {
        try {
            Document doc = new Document(PageSize.A4, 36, 36, 10, 10);
            PdfWriter.getInstance(doc, new FileOutputStream(salida));
            doc.open();
            doc.add(getHeader(header));
            Image imagen = Image.getInstance(rutaimagen);
            imagen.scaleAbsolute(50, 50);
//            imagen.setAlignment(Element.ALIGN_LEFT);
            PdfPTable tableQR = new PdfPTable(2);
            PdfPCell col=new PdfPCell(new Paragraph("Title"));
            col.setColspan(4);
            col.setHorizontalAlignment(Element.ALIGN_CENTER);
            col.setBackgroundColor(BaseColor.GREEN);
            tableQR.addCell(col);
            tableQR.addCell(imagen);
            tableQR.addCell("conversor");
            tableQR.addCell(imagen);
            tableQR.addCell("Repujado");

            doc.add(getInfo(info));
            doc.add(tableQR);
            doc.add(getFooter(footer));
            doc.close();
        } catch (Exception e) {
        }

    }

    private Paragraph getHeader(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuente);
        p.add(c);
        return p;
    }

    private Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }

    private Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteItalica);
        p.add(c);
        return p;
    }
}
