/**
 * ThreadTimer.java   2013-8-12 下午11:19:34 by gavin 
 *
 * Copyright (c) 2000 - 2013 Gavin Lee. All rights reserved.
 * 
 */
package com.china.gavin.javabase.timer;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Replaces the out-dated java.util.Timer. This implementation relies on a {@link ScheduledExecutorService} and
 * therefore has a more efficient use of threads. It also allows naming the threads, making profiling a more pleasant
 * experience.
 * 
 * Xu Panpan in RIM Project.
 */
public class ThreadTimer {
    /**
     * The pool executor for executing when timeout.
     */
    private ScheduledThreadPoolExecutor executor;

    /**
     * Stores all timer tasks.
     */
    private Set<ScheduledFuture<?>> allTasks = new HashSet<ScheduledFuture<?>>();

    /**
     * Stores task map.
     */
    private Map<Runnable, ScheduledFuture<?>> taskMap = new ConcurrentHashMap<Runnable, ScheduledFuture<?>>();

    /**
     * The lock is for avoiding non-sync between allTasks and taskMap.
     */
    private final Object lock = new Object();

    /**
     * The water mark means the highest capacity the pool ever reached.
     */
    private int waterMark = 0;

    /**
     * The time when water mark occurs.
     */
    private Date warterMarkChangeTime = new Date();

    /**
     * Creates a new timer with the specified pool size. This constructor also sets a base name for all created
     * threads.<br> If <code>threadName</code> is set to 'MyThread' all threads in the pool will be named 'MyThread-X'
     * where X is the id of the thread.
     * 
     * @param threadName what this timer thread should be named (to allow easy identification)
     * @param corePoolSize the number of threads to keep in the pool, even if they are idle
     */
    //    public ThreadTimer(String threadName, int corePoolSize) {
    //        if (threadName == null) {
    //            throw new IllegalArgumentException("ThreadName must not be null");
    //        }
    //        this.executor = new ScheduledThreadPoolExecutor(corePoolSize, new NamedThreadFactory(threadName));
    //    }

    /**
     * Schedules the task to be executed every interval (milliseconds) after a first initialDelay.
     * 
     * @param task the task to execute
     * @param initialDelay when should this task first run
     * @param interval after the first run, how long before each next run
     */
    public void scheduleAtFixedRate(Runnable task, long initialDelay, long interval) {
        if (task == null) {
            throw new IllegalArgumentException("Fixed Rate Task must not be null");
        }
        if (initialDelay < 0) {
            throw new IllegalArgumentException("Initial delay must not be negative");
        }
        if (interval <= 0) {
            throw new IllegalArgumentException("Interval must be greater than 0");
        }
        ScheduledFuture<?> futureTask = this.executor.scheduleAtFixedRate(task, initialDelay, interval,
            TimeUnit.MILLISECONDS);
        synchronized (lock) {
            this.taskMap.put(task, futureTask);
            this.allTasks.add(futureTask);
        }
        changeWaterMark();
    }

    /**
     * 
     * Schedules the task to be executed after the given delay
     * 
     * @param task the task to run
     * @param delay the delay for when to run the task (starting from current time)
     */
    public void schedule(Runnable task, long delay) {
        if (task == null) {
            throw new IllegalArgumentException("Scheduled Task must not be null");
        }
        if (delay < 0) {
            throw new IllegalArgumentException("Delay must not be negative:" + delay);
        }
        ScheduledFuture<?> futureTask = this.executor.schedule(task, delay, TimeUnit.MILLISECONDS);
        synchronized (lock) {
            this.taskMap.put(task, futureTask);
            this.allTasks.add(futureTask);
        }
        changeWaterMark();
    }

    private void changeWaterMark() {
        int currentQueueSize = executor.getQueue().size();
        if (currentQueueSize > waterMark) {
            waterMark = currentQueueSize;
            warterMarkChangeTime = new Date();
        }
    }

    /**
     * Cancel all scheduled tasks
     */
    public void cancelAll() {
        doCancel(false);
    }

    /**
     * Stops the executor and all scheduled tasks are discarded. If <code>force</code> is <code>true</code> the
     * currently executing task will be interrupted, otherwise it will be allowed to complete.
     * 
     * @param force forced stop or graceful stop?
     */
    //    public void stop(boolean force) {
    //        doCancel(force);
    //        try {
    //            if (force) {
    //                this.executor.shutdownNow();
    //            } else {
    //                this.executor.shutdown();
    //            }
    //
    //            executor.awaitTermination(ThreadConfig.SHUTDOWN_TIMEOUT, TimeUnit.SECONDS);
    //        } catch (Exception e) {
    //            // ignore
    //        }
    //    }

    /**
     * Cancel all timer tasks that have been scheduled
     * 
     * @param force if true, if the timer is currently executing, allow it to finish
     */
    private void doCancel(boolean force) {
        synchronized (lock) {
            for (ScheduledFuture<?> futureTask : this.allTasks) {
                futureTask.cancel(force);
            }
            this.allTasks.clear();
            this.taskMap.clear();
            this.executor.getQueue().clear();
        }
    }

    /**
     * 
     * Cancel the given timer task.
     * 
     * @param task - the timer task
     * @param force - true if the thread executing this task should be interrupted; otherwise, in-progress tasks are
     * allowed to complete
     */
    public void cancel(Runnable task, boolean force) {
        synchronized (lock) {
            ScheduledFuture<?> future = taskMap.remove(task);
            if (future != null) {
                future.cancel(force);
                allTasks.remove(future);
                this.executor.remove((Runnable) future);
            }
        }
    }

    /**
     * Return the max task counts ever in the Queue of ThreadPool
     */
    public int getWaterMark() {
        return waterMark;
    }

    /**
     * Return the warterMark changeTime
     */
    public Date getWaterMarkChangeTime() {
        return warterMarkChangeTime;
    }

    public String toString() {
        return " allTasks size: " + allTasks.size() + ", taskMap size: " + taskMap.size() + ", Queue size2: "
            + executor.getQueue().size() + ", waterMark:" + getWaterMark();
    }

    public void rescheduleAtFixedRate4AllTaks(long initialDelay, long interval) {
        if (initialDelay < 0) {
            throw new IllegalArgumentException("Initial delay must not be negative");
        }
        if (interval <= 0) {
            throw new IllegalArgumentException("Interval must be greater than 0");
        }

        synchronized (lock) {
            for (Entry<Runnable, ScheduledFuture<?>> task : taskMap.entrySet()) {
                task.getValue().cancel(true);
                ScheduledFuture<?> futureTask = this.executor.scheduleAtFixedRate(task.getKey(), initialDelay,
                    interval, TimeUnit.MILLISECONDS);
                this.allTasks.remove(task.getValue());

                task.setValue(futureTask);
                this.allTasks.add(futureTask);
            }
        }
    }
}
