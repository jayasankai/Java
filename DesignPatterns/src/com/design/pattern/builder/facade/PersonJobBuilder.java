package com.design.pattern.builder.facade;

public class PersonJobBuilder extends PersonBuilder {
	public PersonJobBuilder(Person person) {
		this.person = person;
	}
	
	public PersonJobBuilder at(String companyName) {
		this.person.companyName = companyName;
		return this;
	}
	
	public PersonJobBuilder asA(String position) {
		this.person.position = position;
		return this;
	}
	
	public PersonJobBuilder earning(int annualIncome) {
		this.person.annualIncome = annualIncome;
		return this;
	}
}
