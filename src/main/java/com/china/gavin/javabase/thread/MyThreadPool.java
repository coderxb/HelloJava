package com.china.gavin.javabase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {

	public static void main(String[] args) {
		// create two thread in ThreadPool
		int threadNum = 2;
		ExecutorService exec = Executors.newFixedThreadPool(threadNum);
		// create hundred thread target object
		for (int i = 0; i < 100; i++) {
			Runnable run = new Runner(i);
			// exec thread target object
			exec.execute(run);
		}
		exec.shutdown();
	}

}

class Runner implements Runnable {
	private int threadId;

	public Runner(int threadId) {
		this.threadId = threadId;
	}

	@Override
	public void run() {
		long time = (long) (Math.random() * 1000);
		System.out.println("Thread : " + Thread.currentThread().getName()
				+ "[Target thread object-" + this.threadId + "]"
				+ " Sleeping Time : " + time + "ms");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}