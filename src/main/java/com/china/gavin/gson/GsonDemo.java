package com.china.gavin.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonDemo {

	public void printInteger() {
		Gson gson = new Gson();
		int num = 6;
		String printNum = gson.toJson(num);
		System.out.println(printNum);

	}

	public void printString() {
		Gson gson = new Gson();
		String strToJson = gson.toJson("hello, world"); // 输出: "hello, world"
		System.out.println(strToJson);

		String jsonToString = gson.fromJson("\"hello, world\"", String.class);
		System.out.println(jsonToString);
	}

	public void printArray() {
		Gson gson = new Gson();
		int[] ints = { 1, 2, 3, 4, 5 };
		String[] strings = { "abc", "def", "ghi" };

		String intArray = gson.toJson(ints);
		String stringArray = gson.toJson(strings);
		System.out.println(intArray);
		System.out.println(stringArray);

		int[] jsonToIntArray = gson.fromJson("[101, 102]", int[].class); // intArray
																			// =
																			// {101,
																			// 102}.
																			// 单纯数据类型可以这样.
		int[] jsonToIntArray2 = gson.fromJson("[101, 102]",
				new TypeToken<int[]>() {
				}.getType()); // intArray2 = {101, 102}. 也可以这样做, 不过针对复杂数据类型可以这样.
	}

	public String printPerson() {
		Gson gson = new Gson();
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setName("name" + i);
			p.setAge(i * 5);
			persons.add(p);
		}
		String personObj = gson.toJson(persons);
		return personObj;
	}

	public void jsonToPerson(String personsJson) {
		Gson gson = new Gson();
		List<Person> ps = gson.fromJson(personsJson,
				new TypeToken<List<Person>>() {
				}.getType());
		for (int i = 0; i < ps.size(); i++) {
			Person p = ps.get(i);
			System.out.println(p.toString());
		}
	}

	public static void main(String[] args) {
		GsonDemo gd = new GsonDemo();
		gd.printInteger();
		gd.printArray();

		String persons = gd.printPerson();
		System.out.println(persons);
	}
}
