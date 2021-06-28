import java.util.Calendar;
import java.util.GregorianCalendar;

public class example {

	public static void main(String[]  args) {
		
		int iYear = 1999;
		int iMonth = 0; // 1 (months begin with 0)
		int iDay = 1;

		// Create a calendar object and set year and month
		Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

		// Get the number of days in that month
		int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
		System.out.println(daysInMonth);
		
		
			String s1=">>>>>>>>.your OTP IS<b style=\"color:red\"> OTP IS:12345 </b>. this otp is valid till only 5 minutes.\r\n";
			String replaceString=s1.replaceAll("OTP IS:12345","56");//replaces all occurrences of "is" to "was"  
			System.out.println(replaceString);  
			
	}
}
