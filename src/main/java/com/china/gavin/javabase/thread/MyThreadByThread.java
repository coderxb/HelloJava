package com.china.gavin.javabase.thread;

public class MyThreadByThread extends Thread {

	public MyThreadByThread() {

	}

	public MyThreadByThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		super.run();
		// output thread name and count
		for (int i = 0; i < 20; i++) {
			System.out.println("Thread Name : " + this.getName() + " : " + i);
		}
	}

	public static void main(String[] args) {
		// Create three thread
		for (int i = 0; i < 3; i++) {
			new MyThreadByThread().start();
			new MyThreadByThread("thread-" + i).start();
		}
	}

}