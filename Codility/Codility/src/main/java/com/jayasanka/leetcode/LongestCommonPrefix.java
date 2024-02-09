package com.jayasanka.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = new String[] {"flower","flow","flight"};
		String s = longestCommonPrefix2(strs);
		System.out.println(s);

	}
	
	/**
	 * Sort the array 
	 * take the first item and last item to decide the longest common prefix
	 * Optimized with while loop
	 */
	public static String longestCommonPrefix(String[] strs) {
		// Sorting array
		Arrays.sort(strs);
		
		// take the first item and last item to decide the longest common prefix
		String firstStr = strs[0];
		String lastSrt = strs[strs.length - 1];
		
		int index = 0;
		while (index < firstStr.length() && index < lastSrt.length()) {
			if (firstStr.charAt(index) != lastSrt.charAt(index)) {
				break;
			}
			index++;
		}
		
		return firstStr.substring(0, index);
    }
	
	/**
	 * Sort the array 
	 * take the first item and last item to decide the longest common prefix
	 */
	public static String longestCommonPrefix2(String[] strs) {
		// Sorting array
		Arrays.sort(strs);
		
		// take the first item and last item to decide the longest common prefix
		String firstStr = strs[0];
		String lastSrt = strs[strs.length - 1];
		
		int shortestSrt = Math.min(firstStr.length(), lastSrt.length());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < shortestSrt; i++) {
			if (firstStr.charAt(i) != lastSrt.charAt(i)) {
				break;
			}
			sb.append(firstStr.charAt(i));
		}
		
		return sb.toString();
    }

	/**
	 * 1. Find the smallest string to iterate through items
	 * 2. Compare each and every element of the array to find the common string
	 */
	public static String longestCommonPrefix3(String[] strs) {
		// Find the smallest word
		int smallestLengthArrIndex = 0;
		int smallestLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
        	if (smallestLength >= strs[i].length()) {
        		smallestLength = strs[i].length();
        		smallestLengthArrIndex = i;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        boolean isMatched = true;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            if (strs[smallestLengthArrIndex].length() < 0) {
                isMatched = false;
                break;
            }
            char c = strs[smallestLengthArrIndex].charAt(i);
            while (j < strs.length) {
                if (strs[j].length() < 0 || strs[j].charAt(i) != c) {
                    isMatched = false;
                    break;
                }
                j++;
            }
            if (isMatched) {
                sb.append(String.valueOf(c));
            }
        }

        return sb.toString();
    }
}
