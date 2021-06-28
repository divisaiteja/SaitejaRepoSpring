import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetCurrentDate {

	public static void main(String[] args) {
		//getting current date and time using Date class
	     /*  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	       Date dateobj = new Date();
	       System.out.println(df.format(dateobj));*/
		// Get today as a Calendar
		Calendar today = Calendar.getInstance();
		// Subtract 1 day
		today.add(Calendar.DATE, -1);
		// Make an SQL Date out of that
		java.sql.Date yesterday = new java.sql.Date(today.getTimeInMillis());
		System.out.println(">>>>>>>>"+yesterday);
	}

}
