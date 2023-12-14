package com.design.pattern.builder.facade;

public class Demo {
	public static void main(String[] args) {
		
		PersonBuilder pb = new PersonBuilder();
		Person person = pb.withName("Jayasanka")
				.lives()
					.at("Blk 23")
					.in("Senkang")
					.withPostCode("797638")
				.works()	
					.asA("Software Engineer")
					.at("Crimsonlogic")
					.earning(10000)
				.build();
		
		System.out.println(person);

	}
}
