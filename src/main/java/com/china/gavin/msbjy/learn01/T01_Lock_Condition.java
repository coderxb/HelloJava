package com.china.gavin.msbjy.learn01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T01_Lock_Condition {

    public static void main(String[] args) {

        final char[] numberAry = "123456".toCharArray();
        final char[] alphabetAry = "ABCDEF".toCharArray();

        final Lock lock = new ReentrantLock();
        final Condition c1 = lock.newCondition();
        final Condition c2 = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    for (char num : numberAry) {
                        System.out.println(num);
                        c2.signal();
                        try {
                            c1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    c2.signal();
                } finally {
                    lock.unlock();
                }

            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();

                    for (char alphabet : alphabetAry) {
                        System.out.println(alphabet);
                        try {
                            c1.signal();
                            c2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    c1.signal();
                } finally {
                    lock.unlock();
                }

            }
        }, "t2").start();

    }
}
