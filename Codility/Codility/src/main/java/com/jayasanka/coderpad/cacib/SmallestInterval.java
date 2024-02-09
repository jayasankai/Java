package com.jayasanka.coderpad.cacib;

public class SmallestInterval {

	public static void main(String[] args) {
		int[] smallestPair = smallestInterval(new int[] {1, 6, 4, 8, 12, 13});
		
		System.out.println(smallestPair[0] + " and " + smallestPair[1]);

	}
	
	private static int[] smallestInterval (int[] arr) {
		
		int smallestVal = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (i != j && smallestVal > Math.abs(arr[i] - arr[j])) {
					smallestVal = Math.abs(arr[i] - arr[j]);
					smallestPair[0] = arr[i];
					smallestPair[1] = arr[j];
				}
			}
		}
		
		return smallestPair;
	}

}
