package com.china.gavin.javabase.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class EggQueue {

    private BlockingQueue<Object> eggQueue = new ArrayBlockingQueue<Object>(4);

    public void putEgg(Object egg) {
        try {
            eggQueue.put(egg);
            System.out.println("放入鸡蛋" + egg.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeEgg() {
        try {
            eggQueue.take();
            System.out.println("取出鸡蛋");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class PutEggThread extends Thread {
        private EggQueue eq;
        private Object egg = new Object();

        public PutEggThread(EggQueue eq) {
            this.eq = eq;
        }

        @Override
        public void run() {
            eq.putEgg(egg);
        }

    }

    static class TakeEggThread implements Runnable {
        private EggQueue eq;

        public TakeEggThread(EggQueue eq) {
            this.eq = eq;
        }

        @Override
        public void run() {
            eq.takeEgg();
        }
    }

    public static void main(String[] args) {
        EggQueue eq = new EggQueue();

        for (int i = 0; i < 5; i++) {
            new Thread(new PutEggThread(eq)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new TakeEggThread(eq)).start();
        }

    }
}
