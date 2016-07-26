package com.china.gavin.pattern.singleton;

/**
 * 
 * Hungry Man Mode of Singleton Pattern.
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        // TDDO
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
