package com.jayasanka.codility.bank;

public class Bank {
	private String name;
	private String countryCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Bank(String name, String countryCode) {
		super();
		this.name = name;
		this.countryCode = countryCode;
	}
	
}
