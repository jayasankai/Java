package com.design.pattern.singleton;

public class DoubleCheckLockingEnhancedSingleton {
	
	private static volatile DoubleCheckLockingEnhancedSingleton INSTANCE;

	private DoubleCheckLockingEnhancedSingleton() {}
	
	public static DoubleCheckLockingEnhancedSingleton getInstance() {
		DoubleCheckLockingEnhancedSingleton instance = INSTANCE;
		if (instance == null) {
			synchronized (DoubleCheckLockingEnhancedSingleton.class) {
				instance = INSTANCE;
				if (instance == null) {					
					INSTANCE = instance = new DoubleCheckLockingEnhancedSingleton();
				}
			}
		}
		
		return instance;
	}
}
