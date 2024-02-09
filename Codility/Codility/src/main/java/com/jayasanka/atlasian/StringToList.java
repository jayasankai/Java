package com.jayasanka.atlasian;

public class StringToList {

	public static void main(String[] args) {
		String s = "RRLLJ";
		
		String[] sArr = s.split("");
		
		for(String ss : sArr) {			
			System.out.print(ss + " ");
		}
		

	}

}
