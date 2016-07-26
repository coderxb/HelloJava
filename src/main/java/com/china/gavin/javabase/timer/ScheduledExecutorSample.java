/**
 * ScheduledExecutorSample.java   2013-8-12 下午11:24:18 by gavin 
 *
 * Copyright (c) 2000 - 2013 Gavin Lee. All rights reserved.
 * 
 */
package com.china.gavin.javabase.timer;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorSample {
    public static ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(10);

    class Schedule implements Runnable {
        private String name;

        public Schedule(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println("Schedule " + name);
        }
    }

    class FixedSchedule implements Runnable {
        private int count = 1;
        public void run() {
            System.out.println("Fixed period schedule");
            if (count++ > 10) {
                se.shutdown();
            }
        }
    }

    public void schedule(String name) {
        // 设定值执行一次的runnable  
        se.schedule(new Schedule(name), 0, TimeUnit.SECONDS);
    }

    public void fixedPeriodSchedule() {
        // 设定可以循环执行的runnable,任务的间隔为5秒  
        se.scheduleAtFixedRate(new FixedSchedule(), 0, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {

        ScheduledExecutorSample ss = new ScheduledExecutorSample();
        ss.schedule("begin");
        ss.fixedPeriodSchedule();
        ss.schedule("end");

    }
}
