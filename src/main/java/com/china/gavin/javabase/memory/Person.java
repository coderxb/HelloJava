package com.china.gavin.javabase.memory;

import java.io.Serializable;

public class Person implements Serializable {
	static final long serialVersionUID = 1L;
	String name;
	Person friend;

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}
}
