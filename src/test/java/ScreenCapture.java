
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;
 
public class ScreenCapture {
	
	static boolean stop = false;
	//Image width same as screen width
	static int imageWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	//Image height same as screen height
	static int imageHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Screen Capturing... press q to quit");
		startCapturing();
		do{
			String response = scn.next();
			if(response.equalsIgnoreCase("q")){
				stopCapturing();
				break;
			}
		}while(true);
		System.out.println("Screen Capturing Stopped!");
			
	}
	
	public static void startCapturing(){
		new Thread(){
			@Override
			public void run(){
				Robot robot;
				try{
					robot = new Robot();
					File f = new File("temp");
					if(!f.exists()){
						f.mkdir(); //create temp directory on current location in which all images will be stored if not exists
					}
					while(!stop){
						BufferedImage img = robot.createScreenCapture(new Rectangle(imageWidth,imageHeight));
						ImageIO.write(img, "jpeg", new File("temp/"+System.currentTimeMillis() + ".jpeg"));						
						// interval between each image captured
						Thread.sleep(50);//50 milliseconds that means 20 frames per second
					}
				} catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}.start();
	}
	
	public static void stopCapturing(){
		stop = true;
	}
}