package com.china.gavin.javabase.gc;

/**
 * After testGC() method execatue, objA and objB will be GC collection? Briefly
 * describe what this class does.
 */
public class ReferenceCountingGC {

	public Object instance = null;

	private static final int _1MB = 1024 * 1024;

	private byte[] bigSize = new byte[2 * 1024];

	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		// 假设在这行发生ＧＣ，那么objA and objB 是否能被回收？

		System.gc();
	}
}
