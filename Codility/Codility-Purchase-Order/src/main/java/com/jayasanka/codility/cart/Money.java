package com.jayasanka.codility.cart;

public class Money {
	int doller;
	int cent;

	public Money() {
		this.doller = 0;
		this.cent = 0;
	}

	public Money(int doller) {
		this.doller = doller;
		this.cent = 0;
	}

	public Money(int doller, int cent) {
		this.doller = doller;
		this.cent = cent;
	}

	public Money(Money other) {
		this.doller = other.doller;
		this.cent = other.cent;
	}

	int getDollers() {
		return this.doller;
	}

	int getCents() {
		return this.cent;
	}

	void setMoney(int doller, int cent) {
		this.doller = doller;
		this.cent = cent;
	}

	double getMoney() {
		return (double) (this.doller + (double) this.cent / 100);
	}

	void add(int doller) {
		this.doller += doller;
	}

	void add(int doller, int cent) {
		this.doller += doller;
		this.cent += cent;
	}

	void add(Money other) {
		this.doller += other.doller;
		this.cent += other.cent;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Money) {
			return this.getMoney() == ((Money)obj).getMoney();			
		}
		
		return false;
		
	}

	@Override
	public String toString() {
		return String.format("$%.2f", this.getMoney());
	}

}
