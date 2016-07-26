package com.china.gavin.interview;

import java.util.Random;

public class SeekMaxAndMin {

	/**
	 * 对指定的10个整数,求出其中最大值和最小值
	 */
	public static void main(String[] args) {
		// int[] num = { 12, 25, 541, 6448, 548, 465, 456, 21, 321, 551 };
		int[] num = randomGeneralArray(9000);
		System.out.println(num.length);
		long startTime = System.currentTimeMillis();
		int maxNum = num[0];
		int minNum = num[0];
		for (int i = 0; i < num.length; i++) {
			if (num[i] > maxNum) {
				maxNum = num[i];
			}
			if (num[i] < minNum) {
				minNum = num[i];
			}
		}
		System.out.println("The Array of Maximum is : " + maxNum);
		System.out.println("The Array of Minimum is : " + minNum);
		System.out.println("use time : "
				+ (System.currentTimeMillis() - startTime));

		long startTime2 = System.currentTimeMillis();
		System.out.println("Recursion calculate Maximum is : "
				+ getMaximum(num, num.length));
		System.out.println("use time : "
				+ (System.currentTimeMillis() - startTime2));
	}

	public static int[] randomGeneralArray(int arrayLength) {
		int[] array = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}

	public static int getMaximum(int[] array, int arrayLength) {
		if (arrayLength == 2) {
			return array[0] > array[1] ? array[0] : array[1];
		} else {
			int x = getMaximum(array, arrayLength - 1);
			System.out.println(arrayLength - 1);
			return x > array[arrayLength - 1] ? x : array[arrayLength - 1];
		}
	}
}