package com.jayasanka.codility.cart;

public class Order {

	Money amount;
	Date orderDate;
	Date sentDate;
	String customer;
	String item;

	public Order(Money amount, Date orderDate, String customer, String item) {
		super();
		this.amount = amount;
		this.orderDate = orderDate;
		this.customer = customer;
		this.item = item;
	}

	public Order(Order toCopy) {
		this.amount = toCopy.amount;
		this.orderDate = toCopy.orderDate;
		this.sentDate = toCopy.sentDate;
		this.customer = toCopy.customer;
		this.item = toCopy.item;
	}

	public Money getAmount() {
		return amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getCustomer() {
		return customer;
	}

	public String getItem() {
		return item;
	}

	boolean isFulfilled() {
		return this.sentDate != null ? true : false;
	}

	boolean setFulFilled(Date sentDate) {
		boolean isFulFilled = false;
		if (sentDate != null && this.orderDate.isAfter(sentDate)) {
			this.sentDate = sentDate;
			isFulFilled = true;
		}

		return isFulFilled;
	}

	boolean setOrderDate(Date nextDate) {
		if (!isFulfilled()) {
			this.orderDate = nextDate;
			return true;
		}

		return false;
	}

	boolean setAmount(Money amount) {
		if (!isFulfilled()) {
			this.amount = amount;
			return true;
		}

		return false;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order [Amount=").append(amount);
		sb.append(", orderDate=").append(orderDate);
		if (isFulfilled()) {
			sb.append(", sentDate=").append(sentDate);
		}
		sb.append(", customer=").append(customer);
		sb.append(", item=").append(item).append("]");

		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			Order o = (Order) obj;
			return this.customer.equals(o.customer) && this.item.equals(o.item);
		}

		return false;
	}

}
