package com.jayasanka;

public class Cat extends Animal {

	private static final long serialVersionUID = 1L;

	public Cat(String name) {
		this.setName(name);
	}
	
	@Override
	public void eat() {
		System.out.println("Cat is eating..");
	}

	@Override
	public String toString() {
		return "its a Cat";
	}

}
