package com.china.gavin.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 在n个整数中找到相加之和为t的所有组合
 * 
 * @author lixuebing
 * @version 给定一个数t，以及n个整数，在这n个整数中找到相加之和为t的所有组合，例如t = 4，n = 6，这6个数为[4, 3, 2, 2,
 *          1, 1]，这样输出就有4个不同的组合，它们的相加之和为4：4, 3+1, 2+2, and
 *          2+1+1。请设计一个高效算法实现这个需求。
 */
public class FindAddSum {
	public static void main(String[] args) {
		int fixedResult = 5;
		int arrayLength = 6;
		int[] array = randomGeneralArray(arrayLength, 10);
		List<Integer> saveCombination = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static int[] randomGeneralArray(int arrayLength, int seed) {
		int[] num = new int[arrayLength];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 10);
		}
		return num;
	}

}
