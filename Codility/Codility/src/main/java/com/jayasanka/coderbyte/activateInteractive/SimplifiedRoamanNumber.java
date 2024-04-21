package com.jayasanka.coderbyte.activateInteractive;

public class SimplifiedRoamanNumber {

	public static void main(String[] args) {
		String longRoaman = "CCXXXVIIIIIIIIIIIIIII";
		String roamanValue = stringChallenge(longRoaman);
		System.out.println(roamanValue);

	}

	public static String stringChallenge(String str) {
		String[] givenRomanArr = str.split("");
		int value = 0;
		for (String givenRomanChar : givenRomanArr) {
			if (givenRomanChar.equals("I")) {
				value += 1;
			} else if (givenRomanChar.equals("V")) {
				value += 5;
			} else if (givenRomanChar.equals("X")) {
				value += 10;
			} else if (givenRomanChar.equals("L")) {
				value += 50;
			} else if (givenRomanChar.equals("C")) {
				value += 100;
			} else if (givenRomanChar.equals("D")) {
				value += 500;
			} else if (givenRomanChar.equals("M")) {
				value += 1000;
			}
		}

		int[] romanValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanChars = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder resultSb = new StringBuilder();

		for (int i = 0; i < romanValues.length; i++) {
			while (value >= romanValues[i]) {
				value = value - romanValues[i];
				resultSb.append(romanChars[i]);
			}
		}

		return resultSb.toString();
	}

}
