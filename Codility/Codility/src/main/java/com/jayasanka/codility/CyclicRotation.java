package com.jayasanka.codility;

import java.util.Arrays;

/**
 * Arrays : [100%] CyclicRotation
 * Rotate an array to the right by a given number of steps.
 *
 */
public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = new int[] {3, 8, 9, 7, 6, 5};
		int K = 15;
		
		System.out.println(Arrays.toString(solution(A, K)));
	}
	
	public static int[] solution(int[] A, int K) {
		int[] newIntArr = new int[A.length];
		
		if (K == 0 || A.length == 0) {
			return A;
		}
		
		if (K > A.length) {
			K = K % A.length;
		}
		
		if (K == A.length) {
			return A;
		}
		
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
			
			if (i < A.length - K ) {				
				newIntArr[K+i] = A[i];
			} else {
				newIntArr[K - A.length + i] = A[i];
			}
			
		}
		
		return newIntArr;
	}

}
