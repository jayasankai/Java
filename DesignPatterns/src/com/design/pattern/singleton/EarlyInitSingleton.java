package com.design.pattern.singleton;

public class EarlyInitSingleton {
	
	private static final EarlyInitSingleton INSTANCE = new EarlyInitSingleton();
	
	private EarlyInitSingleton() {}
	
	public static EarlyInitSingleton getInstance() {
		return INSTANCE;
	}

}
