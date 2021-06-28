import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class weekdaysExample {
	 public static void main(String[] args){
		 
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        int count = 0;
	        try {
	            Date d1 = formatter.parse("2019-05-1");
	            Date d2 = formatter.parse("2019-05-8");
	            String weekday="FRIDAY";
	            count = saturdaysundaycount(d1,d2,weekday);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        System.out.println("Count of Sats & Sundays = "+count);
	    }

	    public static int saturdaysundaycount(Date d1, Date d2,String weekday) {
	    	
	    	
	    	
	        Calendar c1 = Calendar.getInstance();
	        c1.setTime(d1);

	        Calendar c2 = Calendar.getInstance();
	        c2.setTime(d2);

	        int sundays = 0;
	        int saturday = 0;
	        int monday=0;
	        int tuesday = 0;
	        int wednesday = 0;
	        int thursday=0;
	        int friday = 0;
	        
	        while (! c1.after(c2)) {
	            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ){
	            	if(weekday=="SATURDAY") {
	            		 saturday++;
	            	}
	                
	            }
	            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	            	if(weekday=="SUNDAY") {
	            		 sundays++;
	            	}
	               
	            }
	            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
	            	if(weekday=="MONDAY") {
	            		 monday++;
	            	}
	               
	            }
	            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
	            	if(weekday=="TUESDAY") {
	            		 tuesday++;
	            	}
	               
	            }
	            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
	            	if(weekday=="WEDNESDAY") {
	            		 wednesday++;
	            	}
	               
	            }
	            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
	            	if(weekday=="THURSDAY") {
	            		 thursday++;
	            	}
	               
	            }
	            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
	            	if(weekday=="FRIDAY") {
	            		 friday++;
	            	}
	               
	            }

	            c1.add(Calendar.DATE, 1);
	        }

	        System.out.println("Saturday Count = "+saturday);
	        System.out.println("Sunday Count = "+sundays);
	        return saturday + sundays+ monday+tuesday+wednesday+thursday+friday;	

}
}
