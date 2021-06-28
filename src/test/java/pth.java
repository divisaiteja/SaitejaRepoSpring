import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;



public class pth {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		 System.out.println(System.getProperty("user.dir"));
		 String path=System.getProperty("user.dir")+"\\MessageTemplate.jsp";
		 //System.out.println("D:\\eclipse-jee-luna-R-win32-x86_64\eclipse\src\main\webapp\MessageTemplate.jsp");
		 System.out.println(path);
		 pth pth=new pth();
		 pth.getPath();
	}
	public void getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(path+">>");
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println(fullPath);
		System.out.println(pathArr[0]);
		fullPath = pathArr[0];
		String reponsePath = "";
		// to read a file from webcontent
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
		System.out.println(reponsePath);
		//return reponsePath;
		}
}
