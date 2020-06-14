package com.china.gavin.javabase.thread;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xuebing on 2018/2/28.
 */
public class ScheduledThreadPoolDemo {

    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    private static void scheduleAtFixedRate(final ScheduledExecutorService service, final int sleepTime){
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.out.println("scheduleAtFixedRate 开始执行时间:" +
                        DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.out.println("scheduleAtFixedRate 执行花费时间=" + (end -start)/1000 + "m");
                System.out.println("scheduleAtFixedRate 执行完成时间：" + DateFormat.getTimeInstance().format(new Date()));
                System.out.println("======================================");
            }
        },1000,5000, TimeUnit.MILLISECONDS);
    }


    private static void threadtest() {
        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(1000);
                        System.out.println("执行线程[" + Thread.currentThread().getName() + "]=" + i);
                        if (1 == i) {
                            break;
                        } else {
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //executor.shutdown();
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        // scheduleAtFixedRate(service,1000);
        // scheduleAtFixedRate(service,1000);
        for (int i = 0; i < 10; i++) {
            threadtest();
        }
    }

}
