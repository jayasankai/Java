package com.jayasanka.codility.cart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	Money amount;
	Date orderDate;
	Date sentDate;
	Order order;
	
	@Before
	public void init() {
		amount = new Money(2, 120);
		
		// month, day, year
		orderDate = new Date(2, 1, 1984);
		sentDate = new Date(2, 3, 1984);
		
		order = new Order(amount, orderDate, "Cus01", "Item01");
	}
	
	@Test
	public void testAmount() {
		assertEquals(2, amount.getDollers());
		
	}

}
