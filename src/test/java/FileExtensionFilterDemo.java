import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
 * Demo of file extension filter. Applied since Java 1.6
 * @author www.codejava.net
 *
 */
public class FileExtensionFilterDemo {
 
    public static void main(String[] args) {
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
             
                    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
                    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", "docx", "xlsx", "pptx"));
                    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
             
                    fileChooser.setAcceptAllFileFilterUsed(true);
             
                    int result = fileChooser.showSaveDialog(fileChooser);
             
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
                        System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    }
                }
            });
        } catch (Exception e) { 
        	
        	e.printStackTrace();
        }
 
    }
 
   
}