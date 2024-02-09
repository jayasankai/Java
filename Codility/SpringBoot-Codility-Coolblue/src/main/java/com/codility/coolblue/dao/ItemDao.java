package com.codility.coolblue.dao;

import java.io.Serializable;

public class ItemDao implements Serializable {
	private static final long serialVersionUID = 1L;

	String name;
	String type;
	
	public ItemDao() {
	}
	
	public ItemDao(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
