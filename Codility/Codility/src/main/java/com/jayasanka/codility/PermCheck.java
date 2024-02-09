package com.jayasanka.codility;

import java.util.Arrays;

/**
 * Counting Elements : [100%] PermCheck 
 * Check whether array A is a permutation.
 *
 */
public class PermCheck {

	public static void main(String[] args) {
		int[] A = new int[] {4, 1, 3, 2};
		
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		int ans = 1;
		if (A.length == 1 && A[0] != 1) {
			ans = 0;
		} else {
			Arrays.sort(A);
			
			for (int i = 0; i < A.length; i++) {
				if (i + 1 == A[i]) {
					continue;
				} else {
					ans = 0;
					break;
				}
			}
		}
		
		return ans;
	}

}
