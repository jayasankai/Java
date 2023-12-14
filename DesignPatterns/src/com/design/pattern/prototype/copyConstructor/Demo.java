package com.design.pattern.prototype.copyConstructor;

public class Demo {
	public static void main(String[] args) {
		Employee john = new Employee("John", new Address("blk 23", "Senkang", "Singapore"));
		
		Employee jane = new Employee(john);
		jane.name = "Jane";
		
		System.out.println(john);
		System.out.println(jane);
	}
}