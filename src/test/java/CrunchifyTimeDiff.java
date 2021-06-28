import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CrunchifyTimeDiff {

	
	public static void main(String[] args) {
		String start = "2019-03-14 09:30:00";
		String end = "2019-03-14 11:00:00";

		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

		Date d1 = null;
		Date d2 = null;
		try {
		    d1 = format.parse(start);
		    d2 = format.parse(end);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    

		// Get msec from each, and subtract.
		long diff = d2.getTime() - d1.getTime();
		/*long diffSeconds = diff / 1000;         */
		long diffMinutes = diff / (60 * 1000);         
	/*	long diffHours = diff / (60 * 60 * 1000);  */                    
		 
		System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
		
	}
	
}
