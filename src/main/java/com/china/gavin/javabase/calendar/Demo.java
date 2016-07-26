package com.china.gavin.javabase.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// String dateStr = "2011-8-3";
		// Date date = df.parse(dateStr);
		// for (int i = 0; i < 33; i++) {
		// Calendar cal = Calendar.getInstance();
		// // cal.setTime(date);
		// cal.setTimeInMillis(date.getTime());
		// cal.add(Calendar.DAY_OF_MONTH, i);
		// System.out.println(df.format(cal.getTime()));
		// }

		Calendar cal = Calendar.getInstance();
		cal.set(2012, 8, 5);
		Date start = cal.getTime();
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(Calendar.DAY_OF_MONTH);

		cal.set(2012, 9, 20);
		Date end = cal.getTime();
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(Calendar.DAY_OF_MONTH);
	}

}
