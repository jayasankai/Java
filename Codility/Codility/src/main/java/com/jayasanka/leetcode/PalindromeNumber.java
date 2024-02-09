package com.jayasanka.leetcode;

public class PalindromeNumber {

	public static void main(String[] args) {
		boolean isPalindrome = isPalindrome(123);
		System.out.println(isPalindrome);
	}
	
	/**
	 * Reverse the integer and compare with the initial value
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
		int originalX = x;
		int reverseX = 0;
		
		while (x > 0) {
			int rem = x % 10;
			reverseX = reverseX * 10 + rem;
			x = x/ 10;
		}

		return originalX == reverseX;
	}

	/**
	 * Convert integer to String
	 * Compare the each chars in the string start from beginning and last
	 */
	public static boolean isPalindrome2(int x) {
		if (x < 0) {
			return false;
		}

		String number = Integer.toString(x);
		String[] values = number.split("");

		int start = 0;
		int end = values.length - 1;
		int mid = (end + 1) / 2;

		if (values.length % 2 == 0) {
			mid = end / 2;
		}

		for (int i = start; i <= mid; i++) {
			if (!values[i].equals(values[end])) {
				return false;
			}
			end--;
		}

		return true;
	}
}
