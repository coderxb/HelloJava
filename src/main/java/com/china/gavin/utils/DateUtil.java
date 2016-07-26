/**
 * DateUtil.java   2015年5月18日 下午9:14:22 by Xuebing 
 *
 * Copyright (c) 2000 - 2015 gordon.Li. All rights reserved.
 * 
 */
package com.china.gavin.utils;

public class DateUtil {

    public static int getDayOfYear(int year, int month, int day) {
        verifyDate(year, month, day);
        int days = 0;
        boolean isLeapYear = isLeapYear(year);
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                days += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
            } else {
                if (isLeapYear) {
                    days += 29;
                } else {
                    days += 28;
                }
            }
        }
        return days + day;
    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            isLeapYear = true;
        }
        return isLeapYear;
    }

    private static void verifyDate(int year, int month, int day) {
        if (year <= 0) {
            throw new IllegalArgumentException("year is error, year = " + year);
        }
        if (month < 0 || month > 12) {
            throw new IllegalArgumentException("month is error, month = " + month);
        }
        boolean isLeapYear = isLeapYear(year);
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day < 0 || day > 31) {
                throw new IllegalArgumentException("day is error, month = " + month + ", day = " + day);
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day < 0 || day > 30) {
                throw new IllegalArgumentException("day is error, month = " + month + ", day = " + day);
            }
        } else {
            if (isLeapYear) {
                if (day < 0 || day > 29) {
                    throw new IllegalArgumentException("day is error, month = " + month + ", day = " + day);
                }
            } else {
                if (day < 0 || day > 28) {
                    throw new IllegalArgumentException("day is error, month = " + month + ", day = " + day);
                }
            }
        }
    }

    public static void main(String[] args) {
        int days = getDayOfYear(2015, 2, 28);
        System.out.println("Total days = " + days);
    }
}
