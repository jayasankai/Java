package com.design.pattern.prototype.serialization;

import java.io.Serializable;

public class Foo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	int stuff;
	String whatever;
	
	public Foo(int stuff, String whatever) {
		this.stuff = stuff;
		this.whatever = whatever;
	}

	@Override
	public String toString() {
		return "Foo [stuff=" + stuff + ", whatever=" + whatever + "]";
	}
}
