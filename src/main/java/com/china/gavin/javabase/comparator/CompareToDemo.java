package com.china.gavin.javabase.comparator;

import java.util.Calendar;
import java.util.Date;

public class CompareToDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		Calendar otherDay = Calendar.getInstance();
		otherDay.set(2012, 9, 9);
		Date tempDate = otherDay.getTime();

		System.out.println(tempDate.after(today.getTime()));

		System.out.println(tempDate.after(new Date()));
		System.out.println(new Date());

		System.out.println(today);
		otherDay.setTime(tempDate);
		System.out.println(otherDay);

		if (otherDay.compareTo(today) > 0) {
			System.out.println("otherDay > today");
		} else {
			System.out.println("otherDay <= today");
		}
	}
}
