package com.jayasanka.hakkerRank;

public class StringFormatter {

	public static void main(String[] args) {
		System.out.println("================================");
		String s1 = "Java";
		int x = 3;
		double d = 12.5;
		System.out.println(
				String.format("|%-15s|", s1) + 
				String.format("%03d|", x) + 
				String.format("%03d|", x) + 
				String.format("$%.2f|", d) + 
				String.format("%02d/%02d/%04d|", 12, 31, 2023));
		System.out.println("================================");

	}

}
