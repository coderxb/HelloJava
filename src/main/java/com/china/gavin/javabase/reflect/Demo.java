package com.china.gavin.javabase.reflect;

class TestDemo {
	public void printStr() {
		System.out.println("Hello World !");
	}
}

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.printthisClassName();
		printSeparation();

		TestDemo td = new TestDemo();
		System.out.println(td.getClass().getName());
		printSeparation();

		String name = "Optimus";
		Class<? extends String> stringClass = name.getClass();
		System.out.println("Class name:" + stringClass.getName());
		System.out.println("isInterface:" + stringClass.isInterface());
		System.out.println("isPrimitive:" + stringClass.isPrimitive());
		System.out.println("isArray:" + stringClass.isArray());
		System.out.println("Super Class name:"
				+ stringClass.getSuperclass().getName());
		printSeparation();

	}

	private void printthisClassName() {
		System.out.println(this.getClass().getName());
	}

	private static void printSeparation() {
		System.out.println("----------------------------------------------");
	}

}
