package com.china.gavin.javabase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CarReflector {

    public static Car initByDefaultConstructor() {
        Car car = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> clazz = loader.loadClass("com.china.gavin.javabase.reflect.Car");
            Constructor<?> cons = clazz.getDeclaredConstructor((Class[]) null);
            car = (Car) cons.newInstance();

            Method setBrand = clazz.getMethod("setBrand", String.class);
            setBrand.invoke(car, "BMW");

            Method setColor = clazz.getMethod("setColor", String.class);
            setColor.invoke(car, "Black");

            Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
            setMaxSpeed.invoke(car, 200);

            return car;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return car;
    }

    public static void main(String[] args) {
        Car car = initByDefaultConstructor();
        car.introduce();
    }
}
