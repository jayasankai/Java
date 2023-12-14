package com.jayasanka.generics;

import java.io.Serializable;

import com.jayasanka.Animal;

public class AnimalPrinter<T extends Animal & Serializable> {

	private T thingToPrint;

	public AnimalPrinter(T thingToPrint) {
		this.thingToPrint = thingToPrint;
	}
	
	public void print() {
		System.out.println(this.thingToPrint);
	}
	
	public <A extends Animal, B extends Animal> void print(A animal1, B animal2) {
		System.out.println(animal1.getName() + " and " +  animal2.getName() + " are friends!");
	}

}
