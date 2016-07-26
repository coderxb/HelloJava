package com.china.gavin.cienet;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class QuestionOne {

	/**
	 * 求三個數的立方和不小于十萬
	 */
	public static void threeNumberCubesLessLakh() {
		int num = (int) Math.cbrt(100000);
		int count = 1;
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j < num; j++) {
				for (int j2 = 1; j2 < num; j2++) {

					if (Math.pow(i, 3) * Math.pow(j, 3) * Math.pow(j2, 3) < 100000
							&& i <= j && j <= j2) {
						System.out.println("i: " + i + ", j: " + j + ", k: "
								+ j2);

						count++;
					}
				}
			}
		}
		System.out.println("Count : " + count);
	}

	/**
	 * List集合去重
	 */
	public static <T> ArrayList<T> removeDuplicateList(List<T> list) {
		return new ArrayList<T>(new LinkedHashSet<T>(list));
	}

	/**
	 * 測試去重方法
	 */
	public static void testRemoveDuplicateList() {
		List<Integer> originalnList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			originalnList.add((int) (1 + Math.random() * 10));
		}
		System.out.println("原始數據：");
		for (Integer num : originalnList) {
			System.out.println(num);
		}
		List<Integer> newList = removeDuplicateList(originalnList);
		System.out.println("去除重複后的數據：");
		for (Integer num : newList) {
			System.out.println(num);
		}
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		//
		testRemoveDuplicateList();

		threeNumberCubesLessLakh();
	}

}
