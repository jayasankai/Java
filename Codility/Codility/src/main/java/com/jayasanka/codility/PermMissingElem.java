package com.jayasanka.codility;

import java.util.Arrays;

/**
 * Time Complexity : [100%] PermMissingElem 
 * Find the missing element in a given permutation.
 *
 */
public class PermMissingElem {

	public static void main(String[] args) {
		int[] A = new int[] {};
		int missingEle = solution(A);
		
		System.out.println(missingEle);

	}
	
	public static int solution(int[] A) {	
		Arrays.sort(A);
		
		for(int i = 0; i < A.length; i++) {
			if (i+1 != A[i]) {
				return i+1;
			}
		}
		
		return A.length + 1;
	}

}
