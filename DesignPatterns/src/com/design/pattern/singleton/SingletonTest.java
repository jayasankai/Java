package com.design.pattern.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		ClassicSingleton instance1 = ClassicSingleton.getInstance();
		ClassicSingleton instance2 = ClassicSingleton.getInstance();
		
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
	}

}
