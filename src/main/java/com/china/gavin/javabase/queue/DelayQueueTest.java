package com.china.gavin.javabase.queue;

import com.mysql.jdbc.TimeUtil;

import java.util.Calendar;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by LIXUEBING on 2016/12/29.
 */
public class DelayQueueTest {


    public static void main(String[] args) {
        System.out.println("Test delay queue.......");

        DelayQueue delayQueue = new DelayQueue();
        DelayedElement el1 = new DelayedElement(5000L);
        DelayedElement el2 = new DelayedElement(3000L);

        delayQueue.offer(el1);
        delayQueue.offer(el2);

        Delayed poll = null;

        while (poll == null) {
            poll = delayQueue.poll();
            System.out.println("poll result \n" + poll);
            System.out.println("poll result \n" + delayQueue.peek());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class DelayedElement implements Delayed {
        private Long delay = null;
        private Long expire = null;

        public DelayedElement(Long delay) {
            this.delay = delay;
            this.expire = Calendar.getInstance().getTimeInMillis() + delay;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return expire - Calendar.getInstance().getTimeInMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            Long res = this.delay - o.getDelay(TimeUnit.MICROSECONDS);
            return res.intValue();
        }

        @Override
        public String toString() {
            return "DelayedElement is " + delay + "\n" + Calendar.getInstance().getTime().toString() + "\n elapsed time is " + getDelay(TimeUnit.DAYS);
        }
    }
}

