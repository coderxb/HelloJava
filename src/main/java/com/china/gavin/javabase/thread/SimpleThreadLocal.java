package com.china.gavin.javabase.thread;

public class SimpleThreadLocal {
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		@Override
		public Integer initialValue() {
			return 0;
		}
	};

	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	/**
	 * define a inner thread class
	 * 
	 * @author lixuebing
	 * 
	 */
	private static class TestClient extends Thread {
		private SimpleThreadLocal sn;

		public TestClient(SimpleThreadLocal sn) {
			this.sn = sn;
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println("thread[" + Thread.currentThread().getName()
						+ "] sn[" + sn.getNextNum() + "]");
			}
		}
	}

	public static void main(String[] args) {
		SimpleThreadLocal sn = new SimpleThreadLocal();
		// set three thread , output seqNum
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}

}
