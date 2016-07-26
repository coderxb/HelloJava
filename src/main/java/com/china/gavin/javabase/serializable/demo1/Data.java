package com.china.gavin.javabase.serializable.demo1;

import java.io.Serializable;

/**
 * 
 * 只是一个简单的类，用于测试序列化.
 * http://www.cnblogs.com/chenfei0801/archive/2013/04/05/3001149.html
 * 
 * @author xuebing
 * 
 */
public class Data implements Serializable {

	private static final long serialVersionUID = 8110487320347898032L;

	public int n;

	public Data(int n) {
		this.n = n;
	}

	public String toString() {
		return Integer.toString(n);
	}
}
