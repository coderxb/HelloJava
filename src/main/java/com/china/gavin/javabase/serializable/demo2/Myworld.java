package com.china.gavin.javabase.serializable.demo2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * Briefly describe what this class does.
 * 
 * @author xuebing
 * 
 */
public class Myworld {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		House house = new House();
		System.out.println("序列化前");
		Animal animal = new Animal("test", house);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(animal);
		oos.flush();
		oos.close();

		System.out.println("反序列化后");
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(in);
		Animal animal1 = (Animal) ois.readObject();
		ois.close();
	}

}
