package com.china.gavin.cienet;

/**
 * reverse sort string and drop repeat/reduplicate place.
 * 
 * @author lixuebing
 * 
 */
public class StringReverse {

	public static void reverseSort(String str) {
		if (str.trim() == "") {
			System.out.println("str不可為空");
		}
		for (int i = str.length(); i >= 1; i--) {
			str.charAt(i);
			System.out.print(str.charAt(i));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reverseSort("");
	}

}
