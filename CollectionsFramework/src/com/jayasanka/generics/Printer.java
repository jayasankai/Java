package com.jayasanka.generics;

public class Printer<T> {

	private T thingToPrint;

	public Printer(T thingToPrint) {
		this.thingToPrint = thingToPrint;
	}
	
	public void print() {
		System.out.println(this.thingToPrint);
	}

}
