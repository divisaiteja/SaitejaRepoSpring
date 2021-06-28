package com.hrms.utitlities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class dateUtils {

	public static int dateFunctionCalucation(String dateStart, String dateStop) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		int retunFunction = 0;
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			retunFunction = (int) ((diffDays * 24 * 60) + (diffHours * 60) + (diffMinutes));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retunFunction;
	}

	public static int calculateDifferenceBTWNDates(String fromdate, String todate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date d1 = null;
		Date d2 = null;
		int returndays = 0;
		try {
			d1 = format.parse(fromdate);
			d2 = format.parse(todate);
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			returndays = (int) diffDays;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returndays + 1;

	}

	public static int getWeekDaysFunction(String fromdate, String todate, String weekday) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		int count = 0;
		try {
			Date d1 = formatter.parse(fromdate);
			Date d2 = formatter.parse(todate);
			count = saturdaysundaycount(d1, d2, weekday);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public static int saturdaysundaycount(Date d1, Date d2, String weekday) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);

		int sundays = 0;
		int saturday = 0;
		int monday = 0;
		int tuesday = 0;
		int wednesday = 0;
		int thursday = 0;
		int friday = 0;

		while (!c1.after(c2)) {
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				if (weekday == "sat") {
					saturday++;
				}

			}
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				if (weekday.equalsIgnoreCase("sun")) {
					sundays++;
				}

			}
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				if (weekday == "mon") {
					monday++;
				}

			}
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
				if (weekday == "tue") {
					tuesday++;
				}

			}
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
				if (weekday == "wed") {
					wednesday++;
				}

			}
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
				if (weekday == "thu") {
					thursday++;
				}

			}
			if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
				if (weekday == "fri") {
					friday++;
				}

			}

			c1.add(Calendar.DATE, 1);
		}
		return saturday + sundays + monday + tuesday + wednesday + thursday + friday;
	}

	public static String getCurrentDateAndtime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String dateAndTime = dtf.format(now);
		return dateAndTime;
	}
}
