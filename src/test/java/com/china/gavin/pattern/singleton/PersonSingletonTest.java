package com.china.gavin.pattern.singleton;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonSingletonTest {

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void testGetPersonInfo() {
		PersonSingleton psOne = PersonSingleton.getInstance();
		psOne.setName("小李");
		System.out.println(psOne.getName());

		PersonSingleton psTwo = PersonSingleton.getInstance();
		psTwo.setName("小 王");
		System.out.println(psOne.getName());

		psOne.getPersonInfo();
		psTwo.getPersonInfo();

		if (psOne == psTwo) {
			System.out.println("same object");
		} else {
			System.out.println("different object");
		}
	}
}
