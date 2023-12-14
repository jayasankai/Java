package com.jayasanka.records;

public class TestRecords {

	public static void main(String[] args) {
		Person person = new Person("Jayasanka", "High Park residencies");
		
		System.out.println(person.name() + " stay at " + person.address());
	}

}
