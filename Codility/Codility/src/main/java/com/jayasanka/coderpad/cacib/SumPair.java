package com.jayasanka.coderpad.cacib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPair {

	public static void main(String[] args) {
		List<Integer> result = findSumPair(Arrays.asList(3, 4, 2, 5, 6, 10), 12);
		result.forEach(System.out::println);

	}
	
	private static List<Integer> findSumPair(List<Integer> numbers, int k) {
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size(); j++) {
				if ( i != j && numbers.get(i) + numbers.get(j) == k) {
					result.add(i);
					result.add(j);
					
					return result;
				}
			}
		}
		
		if (result.isEmpty()) {
			result.add(0);
			result.add(0);
		}
		
		
		return result;
	}

}
