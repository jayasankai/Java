package com.jayasanka.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		int val = 1534236469;
		System.out.println(reverse(val));

	}
	
	public static int reverse(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x = -x;

		}
		long reverse = 0;
		while (x > 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;

		}
		if (reverse > Integer.MAX_VALUE) {
			return 0;
		}
		return (int) (isNegative ? -reverse : reverse);

	}

	public static int reverse2(int x) {
		StringBuilder strBuilder = new StringBuilder();
		if (x < -Math.pow(2, 31) || x > Math.pow(2, 31) - 1) {
			return 0;
		}

		int inputVal = Math.abs(x);
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
		}

		int[] digits = Integer.toString(inputVal).chars().map(c -> c - '0').toArray();

		for (int i = digits.length - 1; i >= 0; i--) {
			strBuilder.append(digits[i]);
		}

		int result = 0;
		try {
			result = Integer.parseInt(strBuilder.toString());
		} catch (NumberFormatException e) {
			return 0;
		}
		if (isNegative) {
			result = -1 * result;
		}

		if (result < -Math.pow(2, 31) || result > Math.pow(2, 31) - 1) {
			return 0;
		}

		return result;

	}



}
