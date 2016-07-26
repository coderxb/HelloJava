package com.china.gavin.utils;

public class BitTricks {
	public static void main(String[] args) {
		int maxInt = getMaxInt();
		int minInt = getMinInt();
		long maxLong = getMaxLong();
		long minLong = getMinLong();
		int num = 4;
		System.out.println("get Max Int = " + maxInt);
		System.out.println("get Min Int = " + minInt);
		System.out.println("get Max Long = " + maxLong);
		System.out.println("get Min Long = " + minLong);
		System.out.println(num + " 乘以 2 = " + multiplyTwo(num));
		System.out.println(num + " 除以 2 = " + dividedTwo(num));
		System.out.println(num + " 是否為奇數 = " + isOddNumber(num));
		swapTwoNumber(50005, -69465);
	}

	/**
	 * 获得int型最大值
	 */
	private static int getMaxInt() {
		return (1 << 31) - 1;
		// return ~(1 << 31);
	}

	/**
	 * 获得int型最小值
	 */
	private static int getMinInt() {
		return 1 << 31;
		// return 1 << -1;
	}

	/**
	 * 获得long型最大值
	 */
	private static long getMaxLong() {
		return ((long) 1 << 127) - 1;
	}

	/**
	 * 获得long型最小值
	 */
	private static long getMinLong() {
		return ((long) 1 << 127);
	}

	/**
	 * 乘以2運算 ：利用左移1位，相當于乘以2;左移N位，相當于乘以2^n
	 */
	private static int multiplyTwo(int num) {
		return num << 1;
	}

	/**
	 * 除以2運算 ：利用右移1位，相當于除以2;移N位，相當于除以2^n
	 */
	private static int dividedTwo(int num) {
		return num >> 1;
	}

	/**
	 * 乘以2的m次方
	 */
	private static int multiplyTwoPower(int num, int m) {
		return num << m;
	}

	/**
	 * 除以2的m次方
	 */
	private static int dividedTwoPower(int num, int m) {
		return num >> m;
	}

	/**
	 * 判断一个数的奇偶性; true為奇數，false為偶數
	 */
	private static boolean isOddNumber(int num) {
		return (num & 1) == 1;
	}

	/**
	 * 不用临时变量交换两个数
	 */
	private static void swapTwoNumber(int x, int y) {
		int num1 = x;
		int num2 = y;
		x ^= y;
		y ^= x;
		x ^= y;
		System.out.println("x = " + num1 + ", y = " + num2);
		System.out.println("swaped : ");
		System.out.println("x = " + x + " ,y = " + y);
	}

	/**
	 * 取绝对值（某些机器上，效率比n>0 ? n:-n 高）
	 */
	private static int abs(int n) {
		return (n ^ (n >> 31)) - (n >> 31);
		/*
		 * n>>31 取得n的符号，若n为正数，n>>31等于0，若n为负数，n>>31等于-1 若n为正数
		 * n^0=0,数不变，若n为负数有n^-1 需要计算n和-1的补码，然后进行异或运算， 结果n变号并且为n的绝对值减1，再减去-1就是绝对值
		 */
	}

	/**
	 * 取两个数的最大值（某些机器上，效率比a>b ? a:b高）
	 */
	private static int max(int a, int b) {
		/* 如果a>=b,(a-b)>>31为0，否则为-1 */
		return b & ((a - b) >> 31) | a & (~(a - b) >> 31);

		/* 如果a>=b,(a-b)>>31为0，否则为-1 */
		// return a & ((a-b) >> 31) | b & (~(a-b) >> 31);
	}

	/**
	 * 取两个数的最小值（某些机器上，效率比a>b ? b:a高）
	 */
	private static int min(int a, int b) {
		/* 如果a>=b,(a-b)>>31为0，否则为-1 */
		return a & ((a - b) >> 31) | b & (~(a - b) >> 31);

		/* 如果x<y x<y返回1，否则返回0， 与0做与运算结果为0，与-1做与运算结果不变 */
		// return y ^ ((x ^ y) & -(x < y));
	}

	/**
	 * 判断符号是否相同
	 */
	private boolean isSameSign(int x, int y) {
		return (x ^ y) >= 0; // true 表示 x和y有相同的符号， false表示x，y有相反的符号。
	}

	/**
	 * 
	 * 计算2的n次方
	 */
	private int getFactorialofTwo(int n) {
		// n > 0 ,2的n次方
		return 2 << (n - 1);
	}

	/**
	 * 
	 * 判断一个数是不是2的幂
	 */
	private boolean isFactorialofTwo(int n) {
		/* 如果是2的幂，n一定是100... n-1就是1111.... 所以做与运算结果为0 */
		return n > 0 ? (n & (n - 1)) == 0 : false;
	}

	/**
	 * 对2的n次方取余
	 */
	private int quyu(int m, int n) {
		/* 如果是2的幂，n一定是100... n-1就是1111.... 所以做与运算结果保留m在n范围的非0的位 */
		return m & (n - 1);
	}

	/**
	 * 求两个整数的平均值
	 */
	private int getAverage(int x, int y) {
		return (x + y) >> 1;

		/* (x^y) >> 1得到x，y其中一个为1的位并除以2， x&y得到x，y都为1的部分，加一起就是平均数了 */
		// return ((x ^ y) >> 1) + (x & y);
	}

	/**
	 * 从低位到高位,取n的第m位
	 */
	private int getBit(int n, int m) {
		return (n >> (m - 1)) & 1;
	}

	/**
	 * 从低位到高位.将n的第m位置1
	 */
	private int setBitToOne(int n, int m) {
		/* 将1左移m-1位找到第m位，得到000...1...000 n在和这个数做或运算 */
		return n | (1 << (m - 1));
	}

	/**
	 * 从低位到高位,将n的第m位置0
	 */
	private int setBitToZero(int n, int m) {
		/* 将1左移m-1位找到第m位，取反后变成111...0...1111 n再和这个数做与运算 */
		return n & ~(1 << (m - 1));
	}
}
