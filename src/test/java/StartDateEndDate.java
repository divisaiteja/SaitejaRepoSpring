import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;

public class StartDateEndDate {
	public static void main(String[] args) {
		 /*LocalDate today = LocalDate.now();
	 LocalDate startDate = today.withDayOfMonth(1);
	 LocalDate EndDate = today.withDayOfMonth(today.lengthOfMonth());

		System.out.println("First day: " +startDate);
		System.out.println("Last day: " + EndDate);*/
		
		
		YearMonth yearMonth = YearMonth.of( 2020, 2 );  // January of 2015.
		LocalDate first = yearMonth.atDay( 1 );
		LocalDate last = yearMonth.atEndOfMonth();
	  java.sql.Date date=java.sql.Date.valueOf(first);
	  java.sql.Date date1=java.sql.Date.valueOf(last);
		
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		format.format(date);
		format.format(date1);
		System.out.println(format.format(date));
		System.out.println(format.format(date1));
		
		int dayOfMonth = first.getDayOfMonth();
		System.out.println(dayOfMonth);
		int dayOfMonth1 = last.getDayOfMonth();
		System.out.println(dayOfMonth1);
		
	}
}
