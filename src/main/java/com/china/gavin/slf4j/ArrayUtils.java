package com.china.gavin.slf4j;

import java.util.Random;

public class ArrayUtils {

	public static int[] createIntArray(int count) {
		Random random = new Random();
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			// Ensure that there is a negative number generated
			array[i] = random.nextInt(100) - random.nextInt(100);
		}
		System.out.println("==========Original Array==========");
		printArray(array);
		return array;
	}

	public static void printArray(int[] array) {
		for (int data : array) {
			System.out.print(data + " ");
		}
		System.out.println();
	}

	public static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	public static void main(String[] args) {
		createIntArray(10);
	}

}
