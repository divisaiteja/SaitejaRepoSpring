import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TableColumnSpanDemo {

	public static void main(String[] args) {
		String FILE_NAME ="D:/poiexcel/nestedTables.pdf";
		Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
            document.open();

            // Creates a table with four column. The first rows
            // will have cell 1 to cell 4.
            PdfPTable table = new PdfPTable(3); // 3 columns.

            PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));

            PdfPTable nestedTable = new PdfPTable(2);
            nestedTable.addCell(new Paragraph("Nested Cell 1"));
            nestedTable.addCell(new Paragraph("Nested Cell 2"));

            cell3.addElement(nestedTable);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            document.add(table);

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        	document.close();
        }
    }

	}


