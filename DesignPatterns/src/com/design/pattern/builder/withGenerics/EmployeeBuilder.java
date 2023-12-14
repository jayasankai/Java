package com.design.pattern.builder.withGenerics;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
	public EmployeeBuilder worksAt(String possition) {
		person.possition = possition;
		return self();
	}
	
	@Override
	protected EmployeeBuilder self() {
		return this;
	}
}
