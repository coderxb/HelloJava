package com.china.gavin.javabase.comparator.demo1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class EmployeeTest {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testAgeComparator() {
		Collections.sort(genEmployeeData(), new AgeComparator());
		printDisplay(genEmployeeData());

	}

	private static List<Employee> genEmployeeData() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee("Andy", 21, 2000));
		employeeList.add(new Employee("Felix", 21, 3000));
		employeeList.add(new Employee("Bill", 35, 20000));
		employeeList.add(new Employee("Helen", 21, 10000));
		employeeList.add(new Employee("Cindy", 28, 8000));
		employeeList.add(new Employee("Douglas", 25, 5000));

		return employeeList;
	}

	private static void printDisplay(List<Employee> eList) {
		for (Employee e : eList) {
			System.out.println("雇员名=" + e.getName() + " 年龄=" + e.age + " 薪水="
					+ e.getSalary());
		}
		System.out.println();
	}
}
