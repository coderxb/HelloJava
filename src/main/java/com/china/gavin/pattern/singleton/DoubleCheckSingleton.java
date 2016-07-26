package com.china.gavin.pattern.singleton;

/**
 * 
 * Double-check Mode of Singleton Pattern.
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {
        // TODO
    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}