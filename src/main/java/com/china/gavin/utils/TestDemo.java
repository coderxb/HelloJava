package com.china.gavin.utils;

public class TestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Math.round(0.5));
		System.out.println(Math.round(1.4));
		System.out.println(Math.round(1.5));
		System.out.println(Math.round(2.6));
		System.out.println(Math.round(11.3));
        String notificationPathUrl = "ftp://bbs.csdn.net/topics/10189671";
        String notificationUrl = notificationPathUrl.toLowerCase();
        System.out.println("Notification URL = " + notificationUrl);
        if (!(notificationUrl.startsWith("http://") || notificationUrl.startsWith("https://"))) {
            System.out.println("NO");
        }
        System.out.print("--------------------------------------------");
        String aaa = null;
        if (aaa.equals("ss")) {
            System.out.print("222222222222");
        }

	}
}
