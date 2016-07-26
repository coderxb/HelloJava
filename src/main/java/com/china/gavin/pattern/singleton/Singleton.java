package com.china.gavin.pattern.singleton;

/**
 * 
 * Classic Singleton Pattern
 * 
 * @author lixuebing
 * 
 */
public class Singleton {
	private static Singleton uniqueInstance = null;

	private Singleton() {
		// Exists only to defeat instantiation.
	}

	// public synchronized static Singleton getInstance() {
	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
}
