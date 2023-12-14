package com.design.pattern.singleton;

/**
 * 1. A private constructor
 * 2. A static field containing its only instance
 * 3. A static factory method for obtaining the instance
 */
public class ClassicSingleton {
	private static ClassicSingleton INSTANCE;
	
	private ClassicSingleton() {}
	
	public static ClassicSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ClassicSingleton();
		}
		return INSTANCE;
	}
}
