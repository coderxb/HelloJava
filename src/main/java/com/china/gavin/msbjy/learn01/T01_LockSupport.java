package com.china.gavin.msbjy.learn01;

import java.util.concurrent.locks.LockSupport;

public class T01_LockSupport {

    private static Thread t1, t2;

    public static void main(String[] args) {
        final char[] numberAry = "123456".toCharArray();
        final char[] alphabetAry = "ABCDEF".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char num : numberAry) {
                    System.out.println(num);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        }, "t1");


        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char alphabet : alphabetAry) {
                    LockSupport.park();
                    System.out.println(alphabet);
                    LockSupport.unpark(t1);
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
