package com.jayasanka.hakkerRank;

public class IsAnagram {

	public static void main(String[] args) {
		
		String a = "anagram";
		String b = "margana";
		
		boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

	}
	
	static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        
        int[] aIntArr = a.toLowerCase().chars().sorted().toArray();
        int[] bIntArr = b.toLowerCase().chars().sorted().toArray();
        
        for (int i=0; i<a.length(); i++) {
            if (aIntArr[i] != bIntArr[i]) {
                return false;
            }
        }
        
        return true;
    }

}
