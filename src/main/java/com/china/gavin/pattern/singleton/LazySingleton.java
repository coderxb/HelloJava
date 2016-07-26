package com.china.gavin.pattern.singleton;

/**
 * 
 * Lazy Man Mode of Singleton Pattern.
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
        // TODO
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}