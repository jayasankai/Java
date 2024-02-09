package com.jayasanka.jar;

public class JarReader2 {

	public static void main(String[] args) {
		
		ClassLoader classLoader = JarReader2.class.getClassLoader();
		
		try {
	        Class aClass = classLoader.loadClass("com.jenkov.MyClass");
	        System.out.println("aClass.getName() = " + aClass.getName());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

}
