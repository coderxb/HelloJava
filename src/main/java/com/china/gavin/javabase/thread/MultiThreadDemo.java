package com.china.gavin.javabase.thread;

import java.util.concurrent.CountDownLatch;

public class MultiThreadDemo {

	// public static class Threads extends Thread {
	public static class Threads implements Runnable {
		private int threadId;
		private CountDownLatch countDownLatch;

		public Threads(int threadId) {
			this.threadId = threadId;
		}

		public Threads(int threadId, CountDownLatch countDownLatch) {
			this.threadId = threadId;
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			// super.run();
			// working(threadId);
			try {
				working(threadId);
			} catch (Exception e) {
				e.getMessage();
			} finally {
				countDownLatch.countDown();
			}

		}

		private void working(int threadId) {
			System.out.println("sub " + threadId + " thread start working.");
			busy();
			System.out.println("sub " + threadId + " thread stop working.");
		}

		private void busy() {
			try {
				System.out.println("sub " + threadId + " thread working.");
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("main thread working Start");
		mainThreadWork();
		System.out.println("sub thread Start.");

		int num = 3;
		CountDownLatch countDownLatch = new CountDownLatch(num);
		for (int i = 1; i <= num; i++) {
			Threads subT = new Threads(i, countDownLatch);
			new Thread(subT).start();
		}

		// Threads subT1 = new Threads(1);
		// Threads subT2 = new Threads(2);
		// Threads subT3 = new Threads(3);
		// subT1.start();
		// subT2.start();
		// subT3.start();
		// try {
		// subT1.join();
		// subT2.join();
		// subT3.join();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("sub thread End.");
		mainThreadWork();
		System.out.println("main thread working End");
	}

	private static void mainThreadWork() {
		System.out.println("main thread working");

	}

}
