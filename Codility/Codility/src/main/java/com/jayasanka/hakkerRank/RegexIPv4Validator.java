package com.jayasanka.hakkerRank;

public class RegexIPv4Validator {

	public static void main(String[] args) {
		String ipv4 = "000.012.012.034";
		String regex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.\\b){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?\\b)";
		
		System.out.println(ipv4.matches(regex));

	}

}
