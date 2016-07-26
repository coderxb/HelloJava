package com.china.gavin.javabase.serializable.demo1;

import java.io.Serializable;
import java.util.Random;

/**
 * 
 * 用于测试序列化，每个对象Worm对象都与worm中的下一段链接，同时又有属于不同类（Data）的对象引用数组链接.
 * http://www.cnblogs.com/chenfei0801/archive/2013/04/05/3001149.html
 * 
 * @author xuebing
 * 
 */
public class Worm implements Serializable {

	private static final long serialVersionUID = -4013708153955855028L;

	private Data[] d = { new Data(random.nextInt(10)), new Data(random.nextInt(10)), new Data(random.nextInt(10)) };

	private static Random random = new Random(47);

	private Worm next;

	private char c;

	public Worm(int i, char x) {
		System.out.println("Worm constructor:" + i);
		c = x;
		if (--i > 0) {
			next = new Worm(i, (char) (x + 1));
		}
	}

	public Worm() {
		System.out.println("Default constructor!");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(":");
		sb.append(c);
		sb.append("(");
		for (Data data : d) {
			sb.append(data);
		}
		sb.append(")");
		if (next != null) {
			sb.append(next);
		}
		return sb.toString();
	}
}
