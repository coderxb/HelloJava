package com.china.gavin.javabase.init;

public class A {

	protected static int count = 0;
	static {
		System.out.println("static A load");
	}
	{
		System.out.println("initial A's object parameter");
	}

	public A() {
		System.out.println("A's Constructor");
	}

	public A(String test) {
		System.out.println("A's another Constructor");
	}

	static public void printStatic() {
		System.out.println("A's static function call");
	}

	public void printVirtual() {
		System.out.println("A's function call");
	}

	// there no public, protected, even private here
	void printSomething() {
		System.out.println("object A says hi");
	}
}