package com.china.gavin.interview;

public class ArrayOperation {

	public static void main(String [] args){
		int[] a = {1,3,-4,5,6,333,345};
		ArrayOperation.getArrayNSumMax(a, 6);
	}
	/**
	 * @Title: getArrayNSumMax
	 * @Description: TODO(SoHu面试题：有一个一维数组，元素都为整数(可能为负数)，长度为n,
	 * 					请找出连续元素和最大是多少数;是那些元素;并分析算法的时间复杂度
	 * 				    注：时间频度是(1+1+1+1+1+n^2+1+1+n）
     *						该程序的时间复杂度T(n)=O(n^2)
	 * 
	 * 本算法的时间复杂度为：O(n^2).)
	 * @param @param array  数据
	 * @param @param n 连续元素的长度
	 * @return void 返回类型
	 * @author Administrator 
	 * @date 2011-5-12 下午09:49:46
	 * @throws
	 */
	public static void getArrayNSumMax(int array[],int n){
		if (array.length<n) { 
			System.out.println("");   
			return;
		}
		int max = 0;       
		int index = 0;
		int useLength = array.length - n + 1;
		for (int i = 0; i < useLength; i++) {
			int sum = 0;
			for (int j = i; j < i + n; j++) {
				sum += array[j];
			}
			if(i==1){
				max = sum;
			}else{
				if (max<sum) {
					max = sum;
					index = i;
				}				
			}
		}
		
		System.out.println("连续元素和的最大值为：" + max);
		System.out.print("求和的那些元素分别是：");
		for (int i = index; i < index + n; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
