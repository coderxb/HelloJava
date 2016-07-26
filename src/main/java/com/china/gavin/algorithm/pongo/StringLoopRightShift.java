package com.china.gavin.algorithm.pongo;

public class StringLoopRightShift {

	public static void main(String[] args) {
		int moveNum = 4;
		String originalStr = "abcdefgh";
		String newStr = simpleRightShift(originalStr, moveNum);
		System.out.println(newStr);
		String newStr1 = simpleRightShift1(originalStr, moveNum);
		System.out.println(newStr1);
	}

	private static String simpleRightShift(String str, int moveNum) {
		StringBuilder newStr = new StringBuilder(str);
		for (int i = 0; i < moveNum; i++) {
			newStr.insert(0, newStr.charAt(newStr.length() - i - 1));
		}
		newStr.delete(newStr.length() - moveNum, newStr.length());
		return newStr.toString();
	}

	private static String simpleRightShift1(String str, int moveNum) {
		StringBuilder newStr = new StringBuilder(str);
		newStr.insert(0, newStr.substring(str.length() - moveNum, str.length()));
		newStr.delete(newStr.length() - moveNum, newStr.length());
		return newStr.toString();
	}
}
