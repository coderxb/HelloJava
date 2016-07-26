package com.china.gavin.javabase.init;

public class ExecClass {
	/**
	 * Please switch between newObject() and staticCall() by yourself. try to
	 * understand the loading order of A, B, C, and D. You can also use debug
	 * mode to execute it line by line to see the change.
	 * 
	 * @param args
	 */
	static public void main(String[] args) {

		newObject();
		// staticCall();
	}

	static void staticCall() {
		B.printStatic();
		C.printStatic();
	}

	static void newObject() {
		System.out.println("----B----");
		B a1 = new B();
		System.out.println("----C----");
		C a2 = new C();
		System.out.println("---------");
		B.printStatic();
		System.out.println("---------");
		a1.printVirtual();
		System.out.println("---------");
		C.printStatic();
		System.out.println("---------");
		a2.printVirtual();
		System.out.println("---------");
		System.out.println(A.count);
		new D();
	}

	private static class D {
		public D() {
			// TODO Auto-generated constructor stub
		}

		static {
			System.out.println("static D load");
		}

		{
			System.out.println("object D load");
		}

	}
}