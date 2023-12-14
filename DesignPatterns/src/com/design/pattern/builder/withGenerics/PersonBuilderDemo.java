package com.design.pattern.builder.withGenerics;

public class PersonBuilderDemo {

	public static void main(String[] args) {
		EmployeeBuilder pb = new EmployeeBuilder();
		
		Person person = pb
				.withName("Jayasanka")
				.worksAt("Crimson")
				.build();
		
		System.out.println(person);

	}

}
