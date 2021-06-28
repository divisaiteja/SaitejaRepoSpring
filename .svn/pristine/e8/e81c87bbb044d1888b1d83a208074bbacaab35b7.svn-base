package com.hrms.commons;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class example {
	//private static SessionFactory factory;
	public static void main(String[] args){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2018-05-05";

        try {

            Date date = formatter.parse(dateInString);
            System.out.println(formatter.format(date));
            Calendar cal = Calendar.getInstance();
            cal.setTime ( date ); // convert your date to Calendar object
            int daysToDecrement = -1;
            cal.add(Calendar.DATE, daysToDecrement);
            date = cal.getTime();
            System.out.println(formatter.format(date));

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
