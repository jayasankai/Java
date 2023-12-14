package com.design.pattern.singleton;

public class InitOnDemandSingleton {
	
	private InitOnDemandSingleton() {}
	
	private static class InstanceHolder {
		private static final InitOnDemandSingleton INSTANCE = new InitOnDemandSingleton();
	}
	
	public static InitOnDemandSingleton getInstance() {
		return InstanceHolder.INSTANCE;
	}
}
