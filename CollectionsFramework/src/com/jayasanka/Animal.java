package com.jayasanka;

import java.io.Serializable;

public abstract class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;

	public void eat() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
