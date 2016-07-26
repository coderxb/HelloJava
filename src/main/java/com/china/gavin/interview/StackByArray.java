package com.china.gavin.interview;

import java.util.EmptyStackException;
import java.util.Random;

public class StackByArray<T> {

	Object[] array;
	int top;
	int maxLength;
	int minValue;

	public StackByArray(int maxLength) {
		this.maxLength = maxLength;
		this.array = new Object[maxLength];
		this.top = -1;
	}

	public Object push(Object data) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is Full.");
		}
		this.array[++top] = data;
		return data;
	}

	public Object pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return array[top--];
	}

	public Object peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return this.array[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top + 1 == maxLength;
	}

	public static void main(String[] args) {
		StackByArray<Integer> sk = new StackByArray<Integer>(1000);
		Random rd = new Random();
		try {
			for (int i = 0; i < 20; i++) {
				sk.push(rd.nextInt(100));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = 0;
		while (sk.top >= 0) {
			System.out.println("The " + ++count + " : " + sk.pop());
		}
		System.out.println("Stack is Empty : " + sk.isEmpty());
		System.out.println("Stack is Full : " + sk.isFull());
	}

}