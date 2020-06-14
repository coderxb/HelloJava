package com.china.gavin.msbjy.learn01;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class T01_BlockingQueue {

    private static Thread t1, t2;

    private static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    private static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        final char[] numberAry = "123456".toCharArray();
        final char[] alphabetAry = "ABCDEF".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char num : numberAry) {
                    System.out.println(num);
                    try {
                        q1.put("ok");
                        q2.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, "t1");

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char alphabet : alphabetAry) {
                    try {
                        q1.take();
                        System.out.println(alphabet);
                        q2.put("ok");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
