package com.jayasanka.records;

import java.security.InvalidParameterException;

public record Person(String name, String address) {
	
	public Person {
		if (name == null || name.isEmpty()) {
			throw new InvalidParameterException("Name should be not null");
		}
	}
	
	public Person (String name) {
		this(name, "Unknown");
	}
}
