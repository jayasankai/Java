package com.jayasanka.lambda;

public class TestLambda {

	public static void main(String[] args) {
		
		// Used inner classes
		GreetMessage gm1 = new GreetMessage() {
			@Override
			public void greet(String name) {
				System.out.println("Hello " + name);
				
			}
		};
		gm1.greet("Jayasanka");
		
		// Used with Functional interface
		GreetMessage gm2 = name -> {
			System.out.println("Hello " + name);
		};
		gm2.greet("Test User");
		

	}

}
