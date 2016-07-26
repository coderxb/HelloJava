package com.china.gavin.javabase.init;

public class B extends A {
	static {
		System.out.println("static B load");
	}
	{
		System.out.println("initial B's object parameter");
	}

	public B() {
		super("a");
		System.out.println("B's Constructor");
		count++;
	}

	public B(String b) {
		System.out.println("B's Parameter Constructor");
	}

	static public void printStatic() {
		System.out.println("B's static function call");
	}
}
