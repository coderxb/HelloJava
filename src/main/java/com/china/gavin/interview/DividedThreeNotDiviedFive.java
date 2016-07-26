package com.china.gavin.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 编程输出1~100中能被3整除但不能被5整除的数,并统计有多少个这样的数。
 * 
 * @author lixuebing
 * 
 */
public class DividedThreeNotDiviedFive {
	public static void main(String[] args) {
		List<Integer> dividedNum = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 != 0) {
				dividedNum.add(i);
				System.out.print(i + " , ");
			}
		}
		System.out.println("1~100中能被3整除但不能被5整除的数有： " + dividedNum.size() + "个");
	}
}
