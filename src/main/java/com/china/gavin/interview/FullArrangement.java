package com.china.gavin.interview;

import java.util.ArrayList;

public class FullArrangement {

	/**
	 * @see 全排列 有递归和非递归两种方法
	 */
	public static void main(String[] args) {
		String num[] = { "1", "2", "3", "4", "5" };
		FullArrangement fa = new FullArrangement();

		fa.perm(num, 0, num.length - 1);

		for (int i = 0; i < fa.getArrangeList().size(); i++) {
			System.out.println(fa.getArrangeList().get(i));
		}
		System.out.println("total:" + fa.getArrangeList().size());
	}

	private ArrayList<String> arrangeList = new ArrayList<String>();

	private static void swap(String list[], int k, int i) {
		String c3 = list[k];
		list[k] = list[i];
		list[i] = c3;
	}

	public void perm(String list[], int k, int m) {
		if (k > m) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i <= m; i++) {
				sb.append(list[i]).append(",");
			}
			if (sb.length() > 0) {
				sb.setLength(sb.length() - 1);
			}
			arrangeList.add(sb.toString());
		} else {
			for (int i = k; i <= m; i++) {
				swap(list, k, i);
				perm(list, k + 1, m);
				swap(list, k, i);
			}
		}
	}

	public ArrayList<String> getArrangeList() {
		return arrangeList;
	}

}
