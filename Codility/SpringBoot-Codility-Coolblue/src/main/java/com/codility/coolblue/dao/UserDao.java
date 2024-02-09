package com.codility.coolblue.dao;

import java.io.Serializable;
import java.util.List;

public class UserDao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	List<ItemDao> items;
	
	public UserDao() {
	}

	public UserDao(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ItemDao> getItems() {
		return items;
	}

	public void setItems(List<ItemDao> items) {
		this.items = items;
	}
}
