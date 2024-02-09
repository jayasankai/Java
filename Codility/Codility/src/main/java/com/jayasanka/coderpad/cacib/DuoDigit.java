package com.jayasanka.coderpad.cacib;

import java.util.HashSet;
import java.util.Set;

public class DuoDigit {

	public static void main(String[] args) {
		String result = duoDigit(32233);
		System.out.println(result);
	}
	
	private static String duoDigit(int number) {
		char[] chars = String.valueOf(number).toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		
		for (char c : chars) {
			charSet.add(c);
		}
		
		if (charSet.size() > 2) {
			return "N";
		} else {
			return "Y";
		}
		
	}

}
