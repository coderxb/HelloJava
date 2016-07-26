package com.china.gavin.pattern.singleton;

public class PersonSingleton {
	private static PersonSingleton instance = null;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private PersonSingleton() {

	}

	public static PersonSingleton getInstance() {
		if (instance == null) {
			instance = new PersonSingleton();
		}
		return instance;
	}

	public void getPersonInfo() {
		System.out.println("output person message " + getName());
	}
}
