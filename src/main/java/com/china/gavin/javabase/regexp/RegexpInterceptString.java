package com.china.gavin.javabase.regexp;

public class RegexpInterceptString {

	/**
	 * 截取字符串的方式
	 */
	public static void main(String[] args) {
		String str = "[Type=UPC-A][Final=10][Nnmber=9]";
		regexpMethodInterceptString(str);
		splitMethodInterceptString(str);
	}

	/**
	 * Regexp Method
	 */
	public static void regexpMethodInterceptString(String data) {
		String str = "[Type=UPC-A][Final=10][Nnmber=9]";
		System.out.println("以Regexp 的方式，獲取需要的字符");
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("\\[Type=(.*)\\]\\[Final=(.*)\\]\\[Nnmber=(.*)\\]");
		java.util.regex.Matcher mt = pattern.matcher(str);
		if (mt.matches()) {
			System.out.println(mt.group(1));
			System.out.println(mt.group(2));
			System.out.println(mt.group(3));
		}
	}

	/**
	 * Split Method
	 */
	public static void splitMethodInterceptString(String data) {
		String[] strArray = data.split("]");
		System.out.println("以 String下Split()方法的方式，獲取需要的字符");
		for (String string : strArray) {
			System.out.println(string.split("=")[1].trim());
		}
	}

}
