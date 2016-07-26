package com.china.gavin.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date today = new Date();

		Calendar cal = Calendar.getInstance();
		// cal.setTime(today);
		cal.set(2013, 0, 22);

		System.out.println(cal.getTime().before(today));

		System.out.println(cal.get(Calendar.HOUR_OF_DAY) + ":"
				+ cal.get(Calendar.MINUTE));

		System.out.println("四舍五入取整:Math.rint(2.3)=" + (int) Math.rint(2.3));
		System.out.println("四舍五入取整:Math.rint(2.5)=" + (int) Math.rint(2.5));
		System.out.println("四舍五入取整:Math.rint(2.56)=" + (int) Math.rint(2.56));
		System.out.println("四舍五入取整:Math.rint(2.9)=" + (int) Math.rint(2.9));

		loop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 2) {
					break loop;
				}
				System.out.println(j);
			}
		}
	}

	public static String dateToTwStr(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		String str = String.valueOf(cal.get(Calendar.YEAR) - 1911)
				+ new SimpleDateFormat("年MM月dd日").format(cal.getTime());
		return str;
	}

	/**
	 * Convert from Calendar to 民國時間 (yyy年mm月dd日) String
	 */
	public static String dateToTwStr(Calendar cal) {
		String str = String.valueOf(cal.get(Calendar.YEAR) - 1911)
				+ new SimpleDateFormat("年MM月dd日").format(cal.getTime());
		return str;
	}
}
