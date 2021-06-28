
import java.text.DateFormatSymbols;

public class getDay {
	

	    public static void main(String args[]){
	    	String name=getDay.getMonth(07);
	    	System.out.println(name);
	    	
	    	/*SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	 try {
	    	       Date myDate = inFormat.parse(2020+"-"+3+"-"+31);
	    	       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
	    	       String dayName=simpleDateFormat.format(myDate);
	    	       System.out.println(dayName);
	    	       
	    	 } catch (Exception e) {
	    	     e.printStackTrace();
	    	}*/
	    	
	}
	    public static String getMonth(int month) {
	        return new DateFormatSymbols().getMonths()[month-1];
	    }
	    
}


