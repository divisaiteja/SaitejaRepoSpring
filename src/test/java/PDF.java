import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		 String filename = "D:/poiexcel/DDD.pdf";
		Document document=new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		document.open();
		Font f=new Font(Font.FontFamily.COURIER,40,Font.ITALIC);
		Paragraph p = new Paragraph("APPOINTMENT ORDER");
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);
		document.close();
	}

}
