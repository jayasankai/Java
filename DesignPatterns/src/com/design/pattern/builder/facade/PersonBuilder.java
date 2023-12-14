package com.design.pattern.builder.facade;

public class PersonBuilder {
	protected Person person = new Person();

	public PersonBuilder withName(String name) {
		person.name = name;
		return this;
	}
	
	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}
	
	public PersonJobBuilder works() {
		return new PersonJobBuilder(person);
	}

	public Person build() {
		return person;
	}
}
