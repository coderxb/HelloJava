package com.china.gavin.javabase.thread;

public class MyThreadByRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			// Create thread target
			Runnable r = new MyThreadByRunnable();
			// The target Object to Thread
			new Thread(r, "thread-" + i).start();
		}
	}

}
