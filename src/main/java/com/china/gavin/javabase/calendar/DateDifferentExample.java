package com.china.gavin.javabase.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Calculate time.
 * @see Mode 1 : Manual calculate.
 * @see Mode 2 : utilize TimeUnit class in java.util.concurrent package.
 */
public class DateDifferentExample {

    public static void main(String[] args) {
        String dateStart = "03/24/1985 00:00:01";
        String processDate = "01/15/2014 18:00:00";

        // HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            // TODO MODE 1
            d1 = format.parse(dateStart);
            d2 = format.parse(processDate);

            // in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");

            // TODO MODE 2
            long diffSeconds1 = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;
            long diffMinutes1 = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
            long diffHours1 = TimeUnit.MILLISECONDS.toHours(diff) % 24;
            long diffDays1 = TimeUnit.MILLISECONDS.toDays(diff);

            System.out.println();
            System.out.print(diffDays1 + " days, ");
            System.out.print(diffHours1 + " hours, ");
            System.out.print(diffMinutes1 + " minutes, ");
            System.out.print(diffSeconds1 + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
