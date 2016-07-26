package com.china.gavin.pattern.simplefactory;

public class LightSimpleFactory {

    public Light verifyLight(String concreteLight) {
        Light light = null;
        if ("Bulb" == concreteLight) {
            light = new BulbLight();
        } else if ("Tube" == concreteLight) {
            light = new TubeLight();
        }
        return light;
    }
}
