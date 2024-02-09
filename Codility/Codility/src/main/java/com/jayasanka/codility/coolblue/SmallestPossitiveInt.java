package com.jayasanka.codility.coolblue;

import java.util.Arrays;

public class SmallestPossitiveInt {

	public static void main(String[] args) {
		
		int [] A = new int[] {3};
		int [] B = new int[] {3};
		
		int [] C = new int[] {1, 2};
		int [] D = new int[] {1, 2};
		
		int [] E = new int[] {1, 2, 4, 3};
		int [] F = new int[] {1, 3, 2, 3};
		
		int [] X = new int[] {3, 2, 1, 6, 5};
		int [] Y = new int[] {4, 2, 1, 3, 3};
		
		int [] J = new int[] {3, 2, 6, 5, 7};
		int [] K = new int[] {4, 2, 3, 3, 8};
		
		
		System.out.println(solution(A, B));
		System.out.println(solution(C, D));
		System.out.println(solution(E, F));
		System.out.println(solution(X, Y));
		System.out.println(solution(J, K));
		
		System.out.println();
		
		System.out.println(solution2(A, B));
		System.out.println(solution2(C, D));
		System.out.println(solution2(E, F));
		System.out.println(solution2(X, Y));
		System.out.println(solution2(J, K));
	}

	private static int solution(int[] A, int[] B) {
		int [] C = new int[A.length];
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= B[i]) {
				C[i] = B[i];
			} else {
				C[i] = A[i];
			}
		}
			
		Arrays.stream(C).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		Arrays.sort(C);
		
		int answer = -1;
		for (int i = 0; i < C.length; i++) {
			if (C[0] + i != C[i]) {
				answer = C[0] + i;
				break;
			}
		}
		
		if (answer == -1) {
			answer = C[C.length -1] + 1;
		}
		
		return answer;
	}
	
	private static int solution2(int[] A, int[] B) {
		int [] C = new int[A.length];
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == B[i]) {
				C[i] = B[i];
			} else if (A[i] < B[i]) {
				C[i] = B[i];
				if (A[i] < answer) {
					answer = A[i];
				}
			} else {
				C[i] = A[i];
				if (B[i] < answer) {
					answer = B[i];
				}
			}
		}
			
		Arrays.stream(C).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
		Arrays.sort(C);
		
		if (answer == Integer.MAX_VALUE) {
			answer = C[C.length -1] + 1;
		}
		
		return answer;
	}

}
