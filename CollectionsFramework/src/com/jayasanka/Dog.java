package com.jayasanka;

public class Dog extends Animal {

	private static final long serialVersionUID = 1L;
	
	public Dog(String name) {
		this.setName(name);
	}

	@Override
	public void eat() {
		System.out.println("Dog is eating..");
	}

	@Override
	public String toString() {
		return "its a Dog.";
	}

}