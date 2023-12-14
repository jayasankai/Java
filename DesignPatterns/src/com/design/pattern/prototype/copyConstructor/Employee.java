package com.design.pattern.prototype.copyConstructor;

public class Employee {
	public String name;
	public Address address;
	
	public Employee(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public Employee(Employee other) {
		this(other.name, new Address(other.address));
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}
}
