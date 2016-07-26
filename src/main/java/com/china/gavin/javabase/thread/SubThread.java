package com.china.gavin.javabase.thread;


public class SubThread implements Runnable {
	private MainThread mT;
	private int threadId;

	public SubThread(int threadId, MainThread mT) {
		this.threadId = threadId;
		this.mT = mT;
	}

	@Override
	public void run() {
		System.out.println("run thread :" + threadId);
		synchronized (mT) {
			if (mT.count == 3) {
				mT.notify();
			}
		}
		mT.count++;
	}
}
