package com.china.gavin.pattern.simplefactory;

public class TubeLight extends Light {

    @Override
    public void turnOff() {
        System.out.println("invoke turnOff method of TubeLight class");
    }

    @Override
    public void turnOn() {
        System.out.println("invoke turnOn method of TubeLight class");
    }

}
