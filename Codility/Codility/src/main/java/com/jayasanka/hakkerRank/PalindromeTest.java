package com.jayasanka.hakkerRank;

public class PalindromeTest {

	public static void main(String[] args) {
		
		String A = "WelcleW";
		
		boolean isPalindrome = false;
        
        if (A.length() == 1) {
            isPalindrome = true;
        }
        
        for (int i =0; i< A.length()/2; i++) {
            // System.out.println(A.charAt(i) + " and " +  A.charAt(A.length() - (i + 1)));
            if (A.charAt(i) == A.charAt(A.length() - (i + 1))) {
                isPalindrome = true;
            } else {
                if (A.length()%2 == 0) {
                    isPalindrome = false;
                }
            }
        }
        
        if (isPalindrome) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

	}

}
