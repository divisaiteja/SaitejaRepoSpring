import java.io.File; 
import javax.swing.JFileChooser; 
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException; 
public class DynamicPath 
{ 
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException { 
		 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	// parent component of the dialog 
	JFrame parentFrame = new JFrame();
	JFileChooser fileChooser = new JFileChooser(); 
	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	fileChooser.setDialogTitle("window"); 
	
	int userSelection = fileChooser.showSaveDialog(parentFrame); 
	if (userSelection == JFileChooser.APPROVE_OPTION) 
	{
		File fileToSave = fileChooser.getSelectedFile();
		System.out.println("Save as file: " + fileToSave.getAbsolutePath()); 
		} 
	} 

}
