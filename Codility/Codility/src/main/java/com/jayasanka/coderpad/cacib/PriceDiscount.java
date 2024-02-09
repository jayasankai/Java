package com.jayasanka.coderpad.cacib;

public class PriceDiscount {

	public static void main(String[] args) {
		int total = calculateTotalPrice(new int[] {100, 200, 400, 50, 300}, 20);
		System.out.println(total);

	}
	
	private static int calculateTotalPrice(int[] prices, int discount) {
		int totalPrice = 0;
		int maxPrice = 0;
		float discountedPrice = 0;
		
		for (int i = 0; i < prices.length; i++) {
			if (maxPrice < prices[i]) {
				maxPrice = prices[i];
				discountedPrice = (maxPrice * discount)/100;
			}
			
			totalPrice += prices[i];
		}
		
		return totalPrice - Math.round(discountedPrice);
	}

}
