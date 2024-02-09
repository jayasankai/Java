package com.jayasanka.jar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarReader {

	private static final String CLASS_SUFFIX = ".class";

    public static void main(String[] args) throws IOException, SecurityException, ClassNotFoundException {

    	String jarName = "./src/main/resources/lib/mysql-connector-java-8.0.30.jar";
    	String targetClass = "com.mysql.cj.jdbc.ConnectionImpl";
        String targetMethod = "executeUpdate";
        
        new JarReader()
        	.searchMethodName(new JarFile(jarName), targetClass, targetMethod);
    }

    /**
     * Search target method name in one Jar file.
     */
    public void searchMethodName(JarFile jarFile, String targetClass, String targetMethod)
            throws SecurityException, ClassNotFoundException {
    	String targetClassJar = targetClass.replaceAll("\\.", "\\/") + CLASS_SUFFIX;
        Enumeration<JarEntry> entryEnum = jarFile.entries();
        
        ClassLoader classLoader = JarReader.class.getClassLoader();
        
        while (entryEnum.hasMoreElements()) {
        	JarEntry entry = entryEnum.nextElement();
        	if (targetClassJar.equals(entry.getName()) && entry.getName().endsWith(CLASS_SUFFIX) ) {        		
        		doSearchMethodName(classLoader, targetClass, targetMethod);
        	}
        }
    }

    private boolean doSearchMethodName(ClassLoader classLoader, String targetClass, String targetMethod) throws SecurityException, ClassNotFoundException {
    	boolean methodFound = false;
    	// Class aClass = classLoader.loadClass(targetClass);
        Method[] methods = Class.forName(targetClass, true, classLoader).getDeclaredMethods();
        for (Method m : methods) {
            if (targetMethod.equals(m.getName())) {
                System.out.println(String.format(
                        "Method [%s] is included in Class [%s]",
                        targetMethod, targetClass));
                break;
            }
        }
        return methodFound;
    }
}
