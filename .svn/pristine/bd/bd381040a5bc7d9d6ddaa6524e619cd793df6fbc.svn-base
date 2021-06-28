import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class gettingweekday {
	
	public static void main(String[] args) {
		// Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date now;
		try {
			now = formatter.parse("2019-05-1");
			SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
	        System.out.println(simpleDateformat.format(now));
	 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 String[] monthName = {"January", "February",
	                "March", "April", "May", "June", "July",
	                "August", "September", "October", "November",
	                "December"};

	        Calendar cal = Calendar.getInstance();
	        String month = monthName[cal.get(Calendar.MONTH)];
	        String prev="";
	        if(cal.get(Calendar.MONTH)==0) {
	        	prev = monthName[11];
	        }else{
	        	prev = monthName[cal.get(Calendar.MONTH)-1];
	        }
	        System.out.println(month);
	        System.out.println(prev);
	        int currentmonth=cal.get(Calendar.MONTH)+1;
	        System.out.println(currentmonth);
	        int prevmonth=0;
	        System.out.println("Month name: " + month); 
	        if(cal.get(Calendar.MONTH)==0) {
	        	prevmonth=12;
	        	
	        }else {
	        	 prevmonth= cal.get(Calendar.MONTH);
	        }
	        System.out.println(currentmonth);
	        System.out.println(prevmonth);
		
	}

}
