package com.jayasanka.varargs;

public class TestVarArgs {

	public static void main(String[] args) {
		printMe("Car", new int[] {12, 44, 51, 18});

	}
	
	public static void printMe(String item, int... prices) {
		int total = 0;
		
		for (int price : prices) {
			total += price;
		}
		
		System.out.println("Item Name: " + item + " of total price: " + total);
	}

}
