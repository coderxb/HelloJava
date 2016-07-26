package com.china.gavin.algorithm.pongo;

import java.util.Scanner;

public class YoungTableau {
	public static void main(String[] args) {
		System.out.println("please row num and column num :");
		Scanner sn = new Scanner(System.in);
		String str = sn.nextLine();
		int key = 80;
		int row = Integer.valueOf(str.split(",")[0]);
		int column = Integer.valueOf(str.split(",")[1]);
		int[][] youngs = initMatrix(row, column);
		printYoungsTableau(row, column, youngs);
		System.out.println("search 80 : " + search(youngs, row, column, key));
	}

	private static void printYoungsTableau(int row, int column, int[][] youngs) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(youngs[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static int[][] initMatrix(int row, int column) {
		int[][] youngs = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				youngs[i][j] = 10 * (i + j + 1);
			}
		}
		return youngs;
	}
	
	public static boolean search(int[][] youngs, int row, int column, int key) {
		int rowR, colR;
		rowR = 0;
		colR = column - 1;
		while (rowR <= row - 1 && colR >= 0) {
			if (youngs[rowR][colR] == key)
				return true;
			else if (youngs[rowR][colR] > key)
				colR--;
			else
				rowR++;
		}
		return false;
	}

}
