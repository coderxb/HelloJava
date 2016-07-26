package com.china.gavin.javabase.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CarReflectorPrivate {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:" + loader);
        System.out.println("parent loader:" + loader.getParent());
        System.out.println("grandparent loader:" + loader.getParent().getParent());

        Class<?> clazz = loader.loadClass("com.china.gavin.javabase.reflect.Car");

        Car car = (Car) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        // ①取消Java语言访问检查以访问private变量
        colorFld.setAccessible(true);
        colorFld.set(car, "Blue");

        // ②取消Java语言访问检查以访问protected方法
        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);
        // Method driveMtd = clazz.getDeclaredMethod("drive", null);
        driveMtd.setAccessible(true);
        driveMtd.invoke(car, (Object[]) null);
    }

}
