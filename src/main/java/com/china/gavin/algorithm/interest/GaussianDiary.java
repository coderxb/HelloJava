package com.china.gavin.algorithm.interest;

public class GaussianDiary {

    /**
     * 
     * Whether is a leap year.
     * <p>If necessary, describe how it does and how to use it.</P>
     * @param year
     * @return 
     */
    public boolean isLeapYear(int year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }
    
    /**
     * 
     * Get someday max days.
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     * @param year
     * @param month
     * @param day
     * @return
     */
    public int getMaxDays(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            default:
                return -1;
        }
    }

    public void getXDays(int year, int month, int day, int X) {
        for (int i = 1; i <= X; i++) {
            if (day != getMaxDays(year, month)) {
                day++;
            } else {
                if (month != 12) {
                    month++;
                    day = 1;
                } else {
                    month = day = 1;
                    year++;
                }
            }

        }
        System.out.println(X + "天后的日期是" + year + "/" + month + "/" + day);
    }

    public static void main(String[] args) {
        GaussianDiary gd = new GaussianDiary();
        gd.getXDays(2013, 11, 2, 3);
    }
}
