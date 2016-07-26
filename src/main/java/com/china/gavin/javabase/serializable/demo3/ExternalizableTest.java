package com.china.gavin.javabase.serializable.demo3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * http://www.cnblogs.com/chenfei0801/archive/2013/04/06/3002146.html
 * 
 * @author xuebing
 */
public class ExternalizableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("序列化之前");
		Blip b = new Blip("This String is ", 47);
		System.out.println(b);

		System.out.println("序列化操作，writeObject");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(b);
		System.out.println("反序列化之后,readObject");
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(in);
		Blip bb = (Blip) ois.readObject();
		System.out.println(bb);
	}

}
