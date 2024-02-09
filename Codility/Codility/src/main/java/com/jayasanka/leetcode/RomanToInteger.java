package com.jayasanka.leetcode;

public class RomanToInteger {

	public static void main(String[] args) {
		String s = "DCXXI";
		int val = romanToInt(s);
		System.out.println(val);
	}

	public static int romanToInt(String s) {
		String[] romans = s.split("");
		int number = 0;
		String previousChar = null;

		for (String romanChar : romans) {
			if ("I".equals(romanChar)) {
				number++;
				previousChar = romanChar;
			} else if ("V".equals(romanChar)) {
				if (previousChar != null && previousChar.equals("I")) {
					number = number - 1 + (5 - 1);
				} else {
					number = number + 5;
				}
				previousChar = null;
			} else if ("X".equals(romanChar)) {
				if (previousChar != null && previousChar.equals("I")) {
					number = number - 1 + (10 - 1);
				} else {
					number = number + 10;
				}
				previousChar = "X";
			} else if ("L".equals(romanChar)) {
				if (previousChar != null && previousChar.equals("X")) {
					number = number - 10 + (50 - 10);
				} else {
					number = number + 50;
				}
				previousChar = null;
			} else if ("C".equals(romanChar)) {
				if (previousChar != null && previousChar.equals("X")) {
					number = number - 10 + (100 - 10);
				} else {
					number = number + 100;
				}
				previousChar = "C";
			} else if ("D".equals(romanChar)) {
				if (previousChar != null && previousChar.equals("C")) {
					number = number - 100 + (500 - 100);
				} else {
					number = number + 500;
				}
				previousChar = null;
			} else if ("M".equals(romanChar)) {
				if (previousChar != null && previousChar.equals("C")) {
					number = number - 100 + (1000 - 100);
				} else {
					number = number + 1000;
				}
				previousChar = null;
			}
		}

		return number;
	}

	private int translate(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public int romanToInt2(String s) {
		int sum = 0;
		int cur = translate(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			int next = translate(s.charAt(i));
			if (next > cur) {
				sum -= cur;
			} else {
				sum += cur;
			}
			cur = next;
		}
		sum += cur;
		return sum;
	}

}
