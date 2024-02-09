package com.jayasanka.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * Counting Elements : [100%] FrogRiverOne
 * Find the earliest time when a frog can jump to the other side of a river.
 *
 */
public class FrogRiverOne {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 3, 1, 4, 2, 3, 5, 4 };
		int X = 5;

		System.out.println(solution(X, A));
	}

	public static int solution(int X, int[] A) {
		Set<Integer> leavesLoc = new HashSet<>();
		int shortestTime = -1;

		for (int timeIdx = 0; timeIdx < A.length; timeIdx++) {
			if (A[timeIdx] <= X) {
				leavesLoc.add(A[timeIdx]);
				if (leavesLoc.size() == X) {
					shortestTime = timeIdx;
					break;
				}
			}
		}

		return shortestTime;
	}

}
