package com.china.gavin.javabase.string;

public class Study_Constructor {

	private int a;
	private int b;
	
	public Study_Constructor(){
		System.out.println("无参的构造器");
	}
	public Study_Constructor(int _a,int _b){
		this.a = _a;
		this.b = _b;
	}
	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 参数
	 * @return void 返回类型
	 * @author 李雪冰  Snowice Lee
	 * @date 2011-8-30 下午07:08:44
	 * @throws
	 */
	public static void main(String[] args) {
		Study_Constructor s = new Study_Constructor(2,4);
		System.out.println(s.a);
	}

}
