package com.jayasanka.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2: Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3: Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3.
 * 
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String s = "abcabcabbb";
		int max = lengthOfLongestSubstring(s);
		System.out.println(max);

	}

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		int left = 0;

		for (int right = 0; right < s.length(); right++) {
			while (!set.add(s.charAt(right))) {
				set.remove(s.charAt(left++));
			}
			
			max = Math.max(max, right - left + 1);
		}
		
		return max;
	}

}
