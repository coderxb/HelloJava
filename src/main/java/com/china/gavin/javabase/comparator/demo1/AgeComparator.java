package com.china.gavin.javabase.comparator.demo1;

import java.util.Comparator;

public class AgeComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Employee eOp1 = (Employee) o1;
		Employee eOp2 = (Employee) o2;

		// 按年龄排序
		return eOp1.getAge() - (eOp2.getAge());
	}
}
