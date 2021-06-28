import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MultipleFileStore {
	public static void main(String[] args) throws Exception {
		String pdfFile="D:/poiexcel/App.pdf";
		FileInputStream input = new FileInputStream (pdfFile);
		ByteArrayOutputStream output = new ByteArrayOutputStream ();
		byte [] buffer = new byte [65536];
		int l;
		while ((l = input.read (buffer)) > 0)
		    output.write (buffer, 0, l);
		input.close ();
		byte [] pdfBytes = output.toByteArray ();
		System.out.println(pdfBytes);
	
	   
	}
	}


