package com.china.gavin.javabase.memory;

/**
 * VM Args : -Xss2M
 * 
 * @author xuebing
 * 
 *         On window OS, Java thread is map to OS‘s core, so the operation is
 *         rask, maybe make the pc is suspended animation.
 */
public class JavaVmStackOOM {

	static void dontStop() {
		while (true) {
			// TODO
		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) {
		JavaVmStackOOM oom = new JavaVmStackOOM();
		oom.stackLeakByThread();
	}
}
