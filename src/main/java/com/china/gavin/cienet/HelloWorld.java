package com.china.gavin.cienet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1 = "string";
		String str2 = new String("string");
		System.out.println(str1.equals(str2));

		System.out.println("这是第一个Hello World !");
		// String str = "Init";
		// System.out.println(("Init").equals(str));

		List<String> strList1 = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			strList1.add("list" + i);
			System.out.println(strList1.get(i));
		}
		System.out.println("-----------------------");

		List<String> strList2 = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			strList2.add("list" + i);
			System.out.println(strList2.get(i));
		}
		System.out.println("-----------------------");
		strList1.removeAll(strList2);
		for (String string : strList1) {
			System.out.println(string);
		}
		// System.out.println(strList.size());
		//
		// for (String str1 : strList.subList(0, 4)) {
		// System.out.println(str1);
		// }
		// System.out.println("--------------------------");
		// for (String string : strList.subList(4, strList.size())) {
		// System.out.println(string);
		// }

		String s = "a,b,c,,,";
		// 长度为3的数组
		System.out.println(s.split(",").length);
		// 长度为6的数组
		System.out.println(s.split(",", 6).length);

	}
}
