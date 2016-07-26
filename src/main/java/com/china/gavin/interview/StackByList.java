package com.china.gavin.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackByList<T> {
	private List<T> list;
	// private int minValue;

	public StackByList() {
		this.list = new ArrayList<T>();
	}

	public T push(T data) throws Exception {
		this.list.add(data);

		return data;
	}

	public T pop() throws Exception {
		int length = this.size();
		T data = peek();
		this.list.remove(length - 1);
		return data;
	}

	private T peek() throws Exception {
		int length = this.list.size();
		if (length == 0) {
			throw new Exception("Stack is Empty");
		}
		return this.list.get(length - 1);
	}

	public int size() {
		return this.list.size();
	}

	public boolean empty() {
		return this.list.size() == 0;
	}

	public int search(T data) {
		int index = this.list.indexOf(data);
		if (index >= 0) {
			return this.list.size() - index;
		}
		return -1;
	}

	public static void main(String[] args) {
		StackByList<Integer> sk = new StackByList<Integer>();
		Random rd = new Random();
		try {
			for (int i = 0; i < 10; i++) {
				sk.push(rd.nextInt(100));
			}
			System.out.println("the top number is : " + sk.peek());
			for (int i = 0; i < 10; i++) {
				int j = i + 1;
				System.out.println("The " + j + " number : " + sk.pop());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Stack is Empty : " + sk.empty());
	}

}
