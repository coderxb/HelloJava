package com.china.gavin.algorithm;

import java.util.ArrayList;
import java.util.List;

public class FullSort {
	// 将NUM设置为待排列数组的长度即实现全排列
	private static final int NUM = 6;
	static List<List<Integer>> result = new ArrayList<List<Integer>>();

	/**
	 * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列
	 * 
	 * @param datas
	 * @param target
	 */
	private static void fullSort(List<Integer> list, List<Integer> target) {
		boolean flag = true;
		if (target.size() == NUM) {
			for (int i = 0; i < target.size() - 1; i++) {
				if (i + 1 < target.size()) {
					if ((target.get(2) == 4 || target.get(i) + target.get(i + 1) == 8))
						flag = false;
				}
			}
			if (flag)
				result.add(target);
			return;
		}

		boolean isRe = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 2 && isRe)
				continue;
			ArrayList<Integer> newDates = new ArrayList<Integer>(list);
			List<Integer> newTarget = new ArrayList<Integer>(target);
			if (list.get(i) == 2)
				isRe = true;
			newTarget.add(newDates.get(i));
			newDates.remove(i);
			fullSort(newDates, newTarget);
		}
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		int[] arr = { 1, 2, 2, 3, 4, 5 };
		List<Integer> list = new ArrayList<Integer>();
		for (int i : arr)
			list.add(i);
		fullSort(list, new ArrayList<Integer>());
		for (List<Integer> l : result) {
			for (int i : l)
				System.out.print(i + " ");
			System.out.println();
		}

		System.out.println("一共有" + result.size() + "种排序");
		System.out.println(System.currentTimeMillis() - time + "ms");
	}

}