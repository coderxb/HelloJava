package com.china.gavin.interview;

import java.util.Random;

public class Averaging {
	public static void main(String[] args) {
		int[] score = new int[30];
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			// score[i] = (int) (Math.random() * 100);
			Random r = new Random();
			score[i] = r.nextInt(100);
			sum += score[i];
			System.out.print(score[i] + " , ");
		}
		double avg = sum / score.length;
		System.out.println("学生的平均成绩为：" + avg);
	}
}
