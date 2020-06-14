package com.china.gavin.msbjy.learn01;

import java.util.concurrent.CountDownLatch;

public class T01_synchronized {


    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

        final Object lock = new Object();


        final char[] numberAry = "123456".toCharArray();
        final char[] alphabetAry = "ABCDEF".toCharArray();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    for (char num : numberAry) {
                        System.out.println(num);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        }, "t1").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (char alphabet : alphabetAry) {
                        System.out.println(alphabet);
                        countDownLatch.countDown();
                        try {
                            lock.notify();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        }, "t2").start();
    }
}
