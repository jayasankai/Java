package com.design.pattern.builder.facade;

public class Person {
	String name;
	int age;
	
	//Address
	String streetAddress, postCode, city;
	
	// Employee
	String companyName, position;
	int annualIncome;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", streetAddress=" + streetAddress + ", postCode=" + postCode
				+ ", city=" + city + ", companyName=" + companyName + ", position=" + position + ", annualIncome="
				+ annualIncome + "]";
	}
	

}
