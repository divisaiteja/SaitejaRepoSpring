package com.hrms.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class timesdiff {
	
	public static void main(String[] args) {
		List li=new ArrayList<>();
		li.add("2018-06-10 08:00:00");
		li.add("2018-06-10 09:50:00");
		
		List li1=new ArrayList<>();
		li1.add("2018-06-10 08:30:40");
		li1.add("2018-06-10 10:50:00");
		
		System.out.println(li+""+li1);
		
		for(int i=0;i<2;i++) {
			
			System.out.println(li.get(i)+">>"+li1.get(i));
		
		}
		
	//	System.out.println(li.size());
		
		System.out.println(li.get(0)+"-"+li1.get(0));
		String dateStart =(String)li.get(0);
		String dateStop=(String)li1.get(0);
		//dateStart = "01/14/2012 09:29:58";
		//String dateStop = "01/15/2012 10:31:48";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;
		
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			System.out.print(diffDays*24*60 + " days ");
			System.out.print(diffHours*60 + " Minutes ");
			System.out.print(diffMinutes + " minutes, ");
			//System.out.print(diffSeconds + " seconds.");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
