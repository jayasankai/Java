package com.jayasanka.jar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

public class MyClassLoader extends ClassLoader {
	public MyClassLoader(ClassLoader parent) {
		super(parent);
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		try {
			String url = "file:" + name + ".class";
			URL myUrl = new URL(url);
			URLConnection connection = myUrl.openConnection();
			
			File f = new File(name + ".class");
			InputStream input = new FileInputStream(f);
			
			
			// InputStream input = connection.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int data = input.read();

			while (data != -1) {
				buffer.write(data);
				data = input.read();
			}

			input.close();

			byte[] classData = buffer.toByteArray();

			return defineClass(name, classData, 0, classData.length);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public static List getClasseNames(String jarName) {
	    ArrayList classes = new ArrayList();

	    try {
	        JarInputStream jarFile = new JarInputStream(new FileInputStream(jarName));
	        JarEntry jarEntry;

	        while (true) {
	            jarEntry = jarFile.getNextJarEntry();
	            if (jarEntry == null) {
	                break;
	            }
	            if (jarEntry.getName().endsWith(".class")) {
	                    System.out.println("Found " + jarEntry.getName().replaceAll("/", "\\."));
	                classes.add(jarEntry.getName().replaceAll("/", "\\."));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return classes;
	}
	
	public static Class<?>[] getClasses(String packageName) throws IOException
    {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        
            System.out.println("Class Loader class is " + classLoader.getClass().getName());
        final String packagePath = packageName.replace('.', '/');
        final Enumeration<URL> resources = classLoader.getResources(packagePath);
        final List<Class<?>> classes = new ArrayList<Class<?>>();
        while (resources.hasMoreElements())
        {
            final URL resource = resources.nextElement();
            final String proto = resource.getProtocol();
            if ("jar".equals(proto))
            {
                classes.addAll(findJarClasses(resource));
            }
            else
            {
                System.err.println("Protocol " + proto + " not supported");
                continue;
            }
        }
        return classes.toArray(new Class[classes.size()]);
    }
	
	private static List<Class<?>> findJarClasses(URL packageResource)
    {
        final List<Class<?>> classes = new ArrayList<Class<?>>();
        try
        {
            System.out.println("Jar URL Path is " + packageResource.getPath());
            final URL fileUrl = new URL(packageResource.getPath());
            final String proto = fileUrl.getProtocol();
            if ("file".equals(proto))
            {
                final String filePath = fileUrl.getPath().substring(1); // skip leading /
                final int jarTagPos = filePath.indexOf(".jar!/");
                if (jarTagPos < 0)
                {
                    System.err.println("Non-conformant jar file reference " + filePath + " !");
                }
                else
                {
                    final String packagePath = filePath.substring(jarTagPos + 6);
                    final String jarFilename = filePath.substring(0, jarTagPos + 4);
                    System.out.println("Package " + packagePath);
                    System.out.println("Jar file " + jarFilename);

                    final String packagePrefix = packagePath + '/';
                    try
                    {
                        final JarInputStream jarFile = new JarInputStream(
                                new FileInputStream(jarFilename));
                        JarEntry jarEntry;

                        while (true)
                        {
                            jarEntry = jarFile.getNextJarEntry();
                            if (jarEntry == null)
                            {
                                break;
                            }
                            final String classPath = jarEntry.getName();
                            if (classPath.startsWith(packagePrefix) && classPath.endsWith(".class"))
                            {
                                final String className = classPath
                                        .substring(0, classPath.length() - 6).replace('/', '.');

                                System.out.println("Found entry " + jarEntry.getName());
                                try
                                {
                                    classes.add(Class.forName(className));
                                }
                                catch (final ClassNotFoundException x)
                                {
                                    System.err.println("Cannot load class " + className);
                                }
                            }
                        }
                        jarFile.close();
                    }
                    catch (final Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                System.err.println("Nested protocol " + proto + " not supprted!");
            }
        }
        catch (final MalformedURLException e)
        {
            e.printStackTrace();
        }
        return classes;
    }
	
	private static void extracted(String jarName, String targetClass, String targetMethod) {
		try {
			JarFile jarFile = new JarFile(jarName);
			String targetClassJar = targetClass.replaceAll("\\.", "\\/") + ".class";
	        Enumeration<JarEntry> entryEnum = jarFile.entries();
	        
	        while (entryEnum.hasMoreElements()) {
	        	JarEntry entry = entryEnum.nextElement();
	        	if (targetClassJar.equals(entry.getName()) && entry.getName().endsWith(".class") ) {  
	        		
	        		
	        		MyClassLoader clsLoader = new MyClassLoader(MyClassLoader.class.getClassLoader());
	        		Class<?> myObjectClass = clsLoader.loadClass(targetClass);
	                Method[] methods = myObjectClass.getDeclaredMethods();
	                for (Method m : methods) {
	                    if (targetMethod.equals(m.getName())) {
	                        System.out.println(String.format(
	                                "Method [%s] is included in Class [%s]",
	                                targetMethod, targetClass));
	                        break;
	                    }
	                }
	        		
	        	}
	        }
	        
		} catch (IOException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
    	String jarName = "./src/main/resources/lib/mysql-connector-java-8.0.30.jar";
    	String targetClass = "com.mysql.cj.jdbc.ConnectionImpl";
        String targetMethod = "executeUpdate";
        
        
        try {
			getClasses(targetClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
