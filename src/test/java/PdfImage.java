import java.io.FileOutputStream;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfImage {
public static void main(String[] args) {
	String FILE_NAME = "D:/poiexcel/JoiningLetter.pdf";
	Document document = new Document();
	try
	{
	    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
	    document.open();
	 //Add Image
	    Image image1 = Image.getInstance("file:///E:/Vishwanth Sir/HRMS/main/webapp/resources/theme/assets/images/y.png");
	    //Fixed Positioning
	   image1.setAbsolutePosition(10f, 500f);
	    //Scale to new height and new width of image
	   image1.scaleAbsolute(100, 100);
	    //Add to document
	    document.add(image1);
	
	 
	    document.close();
	    writer.close();
	    System.out.println("Yes");
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
}
}
