package com.jayasanka.coderpad.cacib;

public class MultiplesSum {

	public static void main(String[] args) {
		int sum = computeMultiplesSum(11);
		System.out.println(sum);

	}
	
	private static int computeMultiplesSum(int n) {
		int sum = 0;
		for (int i = 0; i< n; i++) {
			if (i % 3 == 0) {
				sum += i;
			} else if (i % 5 == 0) {
				sum += i;
			} else if (i % 7 == 0) {
				sum += i;
			}
		}
		
		return sum;
	}

}
