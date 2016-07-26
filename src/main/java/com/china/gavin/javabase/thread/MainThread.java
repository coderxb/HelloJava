package com.china.gavin.javabase.thread;


public class MainThread {
	public boolean flag = false;
	public int count = 1;

	public static void main(String[] args) {
		System.out.println("main thread start");
		MainThread mT = new MainThread();
		// int count = 3;
		for (int i = 1; i <= 3; i++) {
			SubThread subT = new SubThread(i, mT);
			new Thread(subT).start();
		}

		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		// System.out.println("sleep complete");
		for (int i = 0; i < 500; i++) {
			System.out.println("num : " + i);
		}
		synchronized (mT) {
			try {
				// while (true) {
				mT.wait();
				System.out.println("main thread end 1111");
				// }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("main thread end");
	}
}
