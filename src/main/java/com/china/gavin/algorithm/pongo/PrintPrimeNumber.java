package com.china.gavin.algorithm.pongo;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeNumber {
	public static void main(String[] args) {
		int num = 1000;
		List<Integer> primes = simpleAlgorithm(num);
		// print primes
		System.out.println("Prime number total is : " + primes.size());
		for (Integer prime : primes) {
			System.out.println(prime);
		}
	}

	private static List<Integer> simpleAlgorithm(int num) {
		List<Integer> primes = new ArrayList<Integer>();
		int i, j = 0;

		for (i = 2; i <= num; i++) {
			for (j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					break;
				}
			}
			if ((i != 0 && i != 1) && j > i / 2) {
				primes.add(i);
			}
		}
		return primes;
	}

	private static boolean isPrimeNumber(int num) {
		int minPrime = 2;
		while (minPrime <= num) {
			if (num % minPrime++ == 0)
				break;
			if (minPrime != num)
				return true;
		}
		return false;
	}
}
