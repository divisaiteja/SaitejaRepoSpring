import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Opennew {
	public static void main(String[] args) throws IOException {
		if (Desktop.isDesktopSupported()) {
		    try {
		        File myFile = new File("D:/poiexcel/AppointmentOrder.pdf");
		        Desktop.getDesktop().open(myFile);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
		}
	}
}
