package com.china.gavin.algorithm;

import java.util.Random;

public class Assistant {
	/**
	 * @Title: buildArray
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 参数
	 * @return int[] 返回类型
	 * @author Administrator 
	 * @date 2011-6-19 上午10:51:47
	 * @throws
	 */
	public static int[] buildArray(){
		int[] data = new int[10];
		Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(100) - random.nextInt(1000);
		}
		return data;
	}
	
	public static void printArray(int[] data){
		System.out.println("============== 原始数组  ==============");
		for (int i : data) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
