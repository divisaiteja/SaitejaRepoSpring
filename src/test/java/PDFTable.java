import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

public class PDFTable {

	public static void main(String[] args) throws Exception {
		String FILE_NAME = "D:/poiexcel/OfferLetter.pdf";
		 Document document = new Document();
		 PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
		 document.open();
		Chunk glue = new Chunk(new VerticalPositionMark());
		Paragraph p = new Paragraph("Text to the left");
		p.add(new Chunk(glue));
		p.add("Text to the right");
		document.add(p);
		System.out.println(">>>>>>>>>>>>>>>>");
}
}