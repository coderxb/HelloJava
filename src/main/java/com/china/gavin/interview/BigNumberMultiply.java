package com.china.gavin.interview;

import java.math.BigInteger;

/**
 * 
 * @author lixuebing
 * @version 题目详情: 两个大数相乘：char*multiply(char*,char*)。
 *          给了两个字符串，每个都是代表了一个很长的10进制表示的数， 比如 String str1 =
 *          "23456789009877666555544444"； String str2 =
 *          "346587436598437594375943875943875"，
 *          最后求出它们的乘积。不用jdk的数学运算包BigInteger.或者类似的包。
 */
public class BigNumberMultiply {
	public static void main(String[] args) {
		String str1 = "23456789009877666555544444";
		String str2 = "346587436598437594375943875943875";

		BigInteger big1 = new BigInteger(str1);
		BigInteger big2 = new BigInteger(str2);
		BigInteger result = big1.multiply(big2);
		System.out.println(result);

		String product = multiply(str1, str2);
		System.out.print(str1 + " * " + str2 + " = ");
		System.out.println(product);
	}

	public static String multiply(String str1, String str2) {
		StringBuilder result = new StringBuilder();
		int strOneLength = str1.length();
		int strTwoLength = str2.length();
		int arrayLength = strOneLength + strTwoLength;
		int[] product = new int[arrayLength];
		for (int i = 0; i < strOneLength; i++) {
			int multiplier = Integer.parseInt(str1.substring(strOneLength - i
					- 1, strOneLength - i));
			for (int j = 0; j < strTwoLength; j++) {
				int multiplicand = Integer.parseInt(str2.substring(strTwoLength
						- j - 1, strTwoLength - j));
				int sum = product[i + j] + multiplier * multiplicand;
				product[i + j] = sum % 10;
				product[i + j + 1] = product[i + j + 1] + sum / 10;
			}
		}

		boolean flag = true;
		for (int i = product.length; i > 0; i--) {
			if (flag == true && product[i - 1] == 0) {
				continue;
			}
			flag = false;
			result.append(product[i - 1]);
		}
		return result.toString();
	}
}
