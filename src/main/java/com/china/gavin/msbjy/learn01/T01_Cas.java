package com.china.gavin.msbjy.learn01;

import java.util.concurrent.atomic.AtomicInteger;

public class T01_Cas {

    enum ReadyToRun {T1, T2};

    private static Thread t1, t2;

    private static volatile ReadyToRun r = ReadyToRun.T1;
    private static AtomicInteger threadNo = new AtomicInteger(1);

    public static void main(String[] args) {
        final char[] numberAry = "123456".toCharArray();
        final char[] alphabetAry = "ABCDEF".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char num : numberAry) {
                    while (threadNo.get() != 1) {}
                    //while (r != ReadyToRun.T1) {}
                    System.out.println(num);
                    //r = ReadyToRun.T2;
                    threadNo.set(2);
                }
            }
        }, "t1");


        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char alphabet : alphabetAry) {
                    while (threadNo.get() != 2) {}
                    //while (r != ReadyToRun.T2) {}
                    System.out.println(alphabet);
                    //r = ReadyToRun.T1;
                    threadNo.set(1);
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
