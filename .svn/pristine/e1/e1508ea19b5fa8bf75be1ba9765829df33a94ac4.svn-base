import java.text.SimpleDateFormat;
import java.util.Date;

public class datesexample {
	
	public static void main(String[] args) {
		String date="05-01-2019";
		System.out.println(date.substring(0,2));
		System.out.println(date.substring(3,5));
		System.out.println(date.substring(6,10));
		
		String dateFormate=date.substring(6,10)+"-"+date.substring(0,2)+"-"+date.substring(3,5);
		
		SimpleDateFormat	format = new SimpleDateFormat("yyyy-MM-dd");
		
		String fromdate="2018-02-02";
		String todate="2018-02-04";
		Date d1 = null;
		Date d2 = null;
		int retunFunction=0;
		try {
			d1 = format.parse(fromdate);
			d2 = format.parse(todate);
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			System.out.print(diffDays);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
