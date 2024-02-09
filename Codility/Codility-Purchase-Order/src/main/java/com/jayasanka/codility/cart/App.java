package com.jayasanka.codility.cart;

public class App {

	public static void main(String[] args) {

		Money amount = new Money(2, 120);
		
		// month, day, year
		Date orderDate = new Date(2, 1, 1984);
		Date sentDate = new Date(2, 3, 1984);
		
		Order order = new Order(amount, orderDate, "Cus01", "Item01");
		System.out.println(order.isFulfilled());
		
		System.out.println(order.setFulFilled(sentDate));
		
		System.out.println(order);
		
		
		

	}
	
	static void testMoney() {
		Money m1 = new Money(2, 120);
		Money m2 = new Money(2, 110);
		
		System.out.println(m1.equals(m2));
		
		m1.add(1, 80);
		m1.add(m2);
		
		System.out.println(m1.equals(m2));
		
		System.out.println(m1.getMoney());
		System.out.println(m1.toString());
	}
	
	static void testDate() {
		Date d1 = new Date(2, 1, 1984);
		Date d2 = new Date(2, 3, 1984);
		
		System.out.println(d1.isAfter(d2));
		
		
		System.out.println(d1.toString());
	}

}
