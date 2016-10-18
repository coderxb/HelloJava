package com.china.gavin.javabase.io;

import java.io.*;

/**
 * Created by LIXUEBING on 2016/10/18.
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws Exception {
        writeObj();
        readObj();
    }

    private static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
        //读取一个对象
        Object obj = ois.readObject();
        System.out.println(obj.toString());
    }

    private static void writeObj() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
        //写入一个对象
        oos.writeObject(new Person("lisi", 25));
        oos.close();
    }

    public static class Person implements Serializable {
        private static final long serialVersionUID =42L;
        private transient String name;
        public int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

    }

}
