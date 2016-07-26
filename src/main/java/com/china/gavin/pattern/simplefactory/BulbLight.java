package com.china.gavin.pattern.simplefactory;

public class BulbLight extends Light {

    @Override
    public void turnOff() {
        System.out.println("invoke turnOff method of BulbLight class");
    }

    @Override
    public void turnOn() {
        System.out.println("invoke turnOn method of BulbLight class");
    }

}
