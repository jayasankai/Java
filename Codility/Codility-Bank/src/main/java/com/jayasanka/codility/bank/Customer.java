package com.jayasanka.codility.bank;

public class Customer {
	private String name;
	private Account account;

	public String getName() {
		return name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Customer(String name) {
		this.name = name;
	}
}
