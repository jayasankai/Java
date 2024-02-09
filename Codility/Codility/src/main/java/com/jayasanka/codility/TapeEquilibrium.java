package com.jayasanka.codility;

/**
 * Time Complexity : [53%] TapeEquilibrium 
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 *
 */
public class TapeEquilibrium {

	public static void main(String[] args) {
		int[] A = new int[] {3, 1, 2, 4, 3};
		
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
		if (A.length == 0 || A.length == 1) {
			return 0;
		}
		
		int rightSize = 0;
		for (int i = 1; i < A.length; i++) {
			rightSize = rightSize + A[i];
		}
		
		int leftSize = A[0];
		
		int currentSize = Math.abs(Math.abs(rightSize) - Math.abs(leftSize));
		int minSize = currentSize;
		
		for (int i = 1; i < A.length; i++) {
			leftSize = Math.abs(leftSize) + A[i];
			rightSize = Math.abs(rightSize) - A[i];
			currentSize = Math.abs(leftSize - rightSize);
			
			if (currentSize < minSize) {
				minSize = currentSize;
			}
		}
		
		return minSize;
	}

}
