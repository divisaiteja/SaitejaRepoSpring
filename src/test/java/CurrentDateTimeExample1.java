import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;  
public class CurrentDateTimeExample1 {  
  public static void main(String[] args) {  
  /* DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
   LocalDateTime now = LocalDateTime.now();
   System.out.println(dtf.format(now));*/
   
   /*Format formatter = new SimpleDateFormat("dd-MMMM-yyyy"); 
   String s = formatter.format(new Date());
   System.out.println(s);*/
   
  /* Date date = new Date();  
   SimpleDateFormat formatter1 = new SimpleDateFormat("MMM-yyyy");  
   String strDate= formatter1.format(date);  
   System.out.println(strDate);*/  
	  
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
	  Date date = new Date(); 
	  System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48

  }  
}  