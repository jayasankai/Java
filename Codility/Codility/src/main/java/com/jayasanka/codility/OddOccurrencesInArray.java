package com.jayasanka.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Arrays : [100%] OddOccurrencesInArray
 * Find value that occurs in odd number of elements.
 *
 */
public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = new int[] {3, 7, 82, 82, 3, 5, 3, 5, 3, 7, 22};
		
		System.out.println(solution(A));

	}
	
	public static int solution(int[] A) {
		Map<Integer, Boolean> numberVsOddEven = new HashMap<>();
		Boolean isOdd = Boolean.TRUE;
		for(int val : A) {
			isOdd = Boolean.TRUE;
			if (numberVsOddEven.containsKey(val)) {
				isOdd = !numberVsOddEven.get(val);
			}
			
			numberVsOddEven.put(val, isOdd);
		}
		
		for (Map.Entry<Integer, Boolean> entry : numberVsOddEven.entrySet()) {
			Integer key = entry.getKey();
			Boolean val = entry.getValue();
			
			if (val) {
				return key;
			}
		}
		
		return 0;
	}

}
