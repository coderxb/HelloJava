package com.china.gavin.javabase.comparator.demo1;

import java.util.Comparator;

public class NameComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		Employee eOp1 = (Employee) o1;
		Employee eOp2 = (Employee) o2;

		// 按姓名排序
		return eOp1.getName().compareTo(eOp2.getName());
	}
}
