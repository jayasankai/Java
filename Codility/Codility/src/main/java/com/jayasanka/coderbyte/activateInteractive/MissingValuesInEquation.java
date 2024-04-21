package com.jayasanka.coderbyte.activateInteractive;

public class MissingValuesInEquation {

	public static void main(String[] args) {
		String result = mathChallenge("126?4 * 34 = 43?256");
		System.out.println(result);

	}

	public static String mathChallenge(String str) {
		String[] nums = str.split("[+-/*=]");
		String num1Str = nums[0].trim();
		String num2Str = nums[1].trim();
		String num3Str = nums[2].trim();

		String operator = str.substring(nums[0].length(), nums[0].length() + 1);

		String result = "";

		for (int i = 0; i < 10; i++) {
			int num1 = Integer.parseInt(num1Str.replace("?", i + ""));
			for (int j = 0; j < 10; j++) {
				int num3 = Integer.parseInt(num3Str.replace("?", j + ""));

				if (operator.equals("+")) {
					if (num1 + Integer.parseInt(num2Str) == num3) {
						result = i + " " + j;
					}
				} else if (operator.equals("-")) {
					if (num1 - Integer.parseInt(num2Str) == num3) {
						result = i + " " + j;
					}
				} else if (operator.equals("*")) {
					if (num1 * Integer.parseInt(num2Str) == num3) {
						result = i + " " + j;
					}
				} else if (operator.equals("/")) {
					if (num1 / Integer.parseInt(num2Str) == num3) {
						result = i + " " + j;
					}
				}
			}
		}

		return result;
	}

}
