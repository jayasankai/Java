package com.design.pattern.singleton;

public class DoubleCheckLockingSingleton {
	
	private static volatile DoubleCheckLockingSingleton INSTANCE;

	private DoubleCheckLockingSingleton() {}
	
	public static DoubleCheckLockingSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckLockingSingleton.class) {
				if (INSTANCE == null) {					
					INSTANCE = new DoubleCheckLockingSingleton();
				}
			}
		}
		
		return INSTANCE;
	}
}
