package com.china.gavin.javabase.thread;

public class ThreadInterrupt extends Thread {
	static int result = 0;

	public ThreadInterrupt(String name) {
		super(name);
	}

	public static void main(String[] args) {
		System.out.println("Main Thread exacute");
		ThreadJoin subT = new ThreadJoin("Sub Thread");
		subT.start();
		System.out.println("result value = " + result);
		try {
			long startTime = System.nanoTime();
			subT.join(20);
			long endTime = System.nanoTime();
			subT.interrupt();
			long spendTime = (endTime - startTime) / 1000000;
			System.out.println("Spend Time = " + spendTime
					+ " , Random Result = " + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		super.run();
		System.out.println(this.getName() + " Start ...");
		// proposal one
		for (int i = 0; i < 100000; i++) {
			result++;
			if (Thread.interrupted()) {
				System.out.println(this.getName() + " Interrupted");
				return;
			}
		}

		// proposal two
		// try {
		// System.out.println("Sub Thread sleep 5000 millisecond");
		// Thread.sleep(5000);
		//
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		result = (int) (Math.random() * 10000);
		System.out.println(this.getName() + " End ...");
	}
}
