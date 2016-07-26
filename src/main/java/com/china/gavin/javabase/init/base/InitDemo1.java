package com.china.gavin.javabase.init.base;

/**
 * 初始化的问题
 * @ClassName: InitDemo1
 * @Description: 静态块最先初始化，并且只初始化一次;块其次出初化;然后初始化构造方法
 * @author 李雪冰  Snowice Lee
 * @date 2011-8-6 上午09:53:29
 *
 */
public class InitDemo1 {
	static {
		System.out.println("Parent");
	}
	{
		System.out.println("Parent pice");
	}
	InitDemo1(){
		System.out.println("parent");
	}
	public static void main(String[] args) {
		InitDemo1 ab = new InitDemo1();
		System.out.println();
		ab = new A();
		System.out.println();
		ab = new A();
	}

}
class A extends InitDemo1 {
	static {
		System.out.println("Son");
	}
	{
		System.out.println("Son pice");
	}	
	A(){
		System.out.println("son");
	}	
}
