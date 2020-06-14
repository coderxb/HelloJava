package com.china.gavin.javabase.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步生产者与消费者的问题
 * 使用Synchnosied/Wait/notify/notifyAll/Lock/Condition等方式
 * Created by xuebing on 2018/3/5.
 */
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        /**
         * 使用Wait和Notify的方式
         Resource r = new Resource_Notify();
         Producer p = new Producer(r);
         Consumer c = new Consumer(r);
         Thread pt = new Thread(p);
         Thread ct = new Thread(c);
         pt.start();
         ct.start();
         */

        /**
         * 使用Wait和Notify的方式
         */
        // Resource r = new Resource_NotifyAll();
        Resource r = new Resource_Condition();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(pro);
        Thread t4 = new Thread(con);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

interface Resource {
    void set(String name);

    void out();
}

class Resource_Notify implements Resource {

    private String name;
    private int count = 1;
    private boolean flag = false;

    @Override
    public synchronized void set(String name) {
        if (flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.name = name + "---" + count++;
        System.out.println("Thread[" + Thread.currentThread().getName() + "] 生产者 " + this.name);
        flag = false;
        this.notify();
    }

    @Override
    public synchronized void out() {
        if (!flag) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread[" + Thread.currentThread().getName() + "] 消费者 " + this.name);
        flag = false;
        this.notify();
    }

}

class Resource_NotifyAll implements Resource {

    private String name;
    private int count = 1;
    private boolean flag = false;

    @Override
    public synchronized void set(String name) {
        // 原先是if,现在改成while，这样生产者线程从冻结状态醒来时，还会再判断flag.
        while (flag)
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        this.name = name + "---" + count++;
        System.out.println("Thread[" + Thread.currentThread().getName() + "] 生产者 " + this.name);
        flag = true;
        // 原先是notity(), 现在改成notifyAll(),这样生产者线程生产完一个商品后可以将等待中的消费者线程唤醒，
        // 否则只将上面改成while后，可能出现所有生产者和消费者都在wait()的情况
        this.notifyAll();
    }

    @Override
    public synchronized void out() {
        // 原先是if,现在改成while，这样消费者线程从冻结状态醒来时，还会再判断flag.
        while (!flag)
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("Thread[" + Thread.currentThread().getName() + "] 消费者 " + this.name);
        flag = false;
        // 原先是notity(), 现在改成notifyAll(),这样消费者线程消费完一个商品后可以将等待中的生产者线程唤醒，
        // 否则只将上面改成while后，可能出现所有生产者和消费者都在wait()的情况
        this.notifyAll(); /*。*/
    }

}

class Resource_Condition implements Resource {

    private String name;
    private int count = 1;
    private boolean flag = false;
    // Lock是一个接口，ReentrantLock是该接口的一个直接子类
    private Lock lock = new ReentrantLock();
    // 创建代表生产者方面的Condition对象
    private Condition condition_pro = lock.newCondition();
    // 使用同一个锁，创建代表消费者方面的Condition对象
    private Condition condition_con = lock.newCondition();

    @Override
    public void set(String name) {
        // 锁住此语句与lock.unlock()之间的代码
        lock.lock();
        try {
            while (flag)
                // 生产者线程在conndition_pro对象上等待
                condition_pro.await();
            this.name = name + "---" + count++;
            System.out.println("Thread[" + Thread.currentThread().getName() + "] 生产者 " + this.name);
            flag = true;
            condition_con.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // unlock()要放在finally块中
            lock.unlock();
        }
    }

    @Override
    public void out() {
        // 锁住此语句与lock.unlock()之间的代码
        lock.lock();
        try {
            while (!flag)
                // 消费者线程在conndition_con对象上等待
                condition_con.await();
            System.out.println("Thread[" + Thread.currentThread().getName() + "] 消费者 " + this.name);
            flag = false;
            // 唤醒所有在condition_pro对象下等待的线程，也就是唤醒所有生产者线程
            condition_pro.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {

    private Resource res;

    Producer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.set("商品");
        }
    }

}

class Consumer implements Runnable {

    private Resource res;

    Consumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.out();
        }
    }

}