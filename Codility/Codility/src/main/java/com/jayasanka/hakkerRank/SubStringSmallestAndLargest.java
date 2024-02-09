package com.jayasanka.hakkerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubStringSmallestAndLargest {

	public static void main(String[] args) {
		String s = "welcometojava";
		int k = 3;

		String answer = getSmallestAndLargest(s, k);
		String answer2 = getSmallestAndLargest2(s, k);

		System.out.println(answer);
		System.out.println(answer2);

	}
	
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s;
        String largest = "";
        
        for (int i = 0; i < s.length() - k + 1; i++) {
            String sub = s.substring(i, i + k);

            if (smallest.compareTo(sub) >= 0) {
                smallest = sub;
            } 
            
            if (largest.compareTo(sub) <= 0) {
                largest = sub;
            }
        }
        
        return smallest + " " + largest;
    }
	
    public static String getSmallestAndLargest2(String s, int k) {
        String smallest = s;
        String largest = "";
        
		List<String> sList = new ArrayList<>();

		for (int i = 0; i < s.length() - k + 1; i++) {
			String sub = s.substring(i, i + k);
			sList.add(sub);
		}

		Collections.sort(sList);

		smallest = sList.get(0);
		largest = sList.get(sList.size() - 1);
        
        return smallest + " " + largest;
    }

}
