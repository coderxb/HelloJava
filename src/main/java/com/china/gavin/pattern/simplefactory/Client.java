package com.china.gavin.pattern.simplefactory;

public class Client {

    public static void main(String[] args) {
        LightSimpleFactory lsf = new LightSimpleFactory();
        // Light light = lsf.verifyLight("Bulb");
        Light light = lsf.verifyLight("Tube");
        if (light != null) {
            light.turnOn();
            light.turnOff();
        }
    }

}
