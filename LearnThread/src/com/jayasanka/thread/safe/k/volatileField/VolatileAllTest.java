package com.jayasanka.thread.safe.k.volatileField;

/**
 * Moreover, the use of a volatile variable ensures that all variables that are visible to a given thread will be read
 * from the main memory as well.
 *
 * In this case, each time the JVM writes the age volatile variable to the main memory, it will write the non-volatile
 * name variable to the main memory as well. This assures that the latest values of both variables are stored in the
 * main memory, so consequent updates to the variables will automatically be visible to other threads.
 * 
 * Similarly, if a thread reads the value of a volatile variable, all the variables visible to the thread will be read
 * from the main memory too.
 * 
 * This extended guarantee that volatile variables provide is known as the full volatile visibility guarantee.
 * 
 */
public class VolatileAllTest {
	private String name;
	private volatile int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
