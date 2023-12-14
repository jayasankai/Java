package com.design.pattern.prototype.serialization;

import org.apache.commons.lang3.SerializationUtils;

public class Demo {

	public static void main(String[] args) {
		Foo foo = new Foo(23, "TEST");
		
		Foo foo2 = SerializationUtils.roundtrip(foo);
		foo2.stuff = 10;
		foo2.whatever = "Test2";
		
		System.out.println(foo);
		System.out.println(foo2);

	}

}
