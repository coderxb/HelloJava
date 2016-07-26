package com.china.gavin.javabase.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoThread extends Thread {

	private int threadId;

	public DemoThread(int id) {
		this.threadId = id;
		System.out.println("create thread : " + id);
	}

	@Override
	public void run() {
		// super.run();
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current thread " + threadId + " get time is : "
				+ df.format(new Date()));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DemoThread(1).start();
		new DemoThread(2).start();
		new DemoThread(3).start();
	}

}
