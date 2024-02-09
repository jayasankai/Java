package com.jayasanka.codility;

/**
 * Time Complexity : [100%] FrogJmp 
 * Count minimal number of jumps from position X to Y.
 *
 */
public class FrogJmp {

	public static void main(String[] args) {
		int jumps = solution(10, 85, 30);
		System.out.println(jumps);

	}
	
	public static int solution(int X, int Y, int D) {
		int jumps = 0;
		int distance = Y - X;
		
		if (distance == 0) {
			return jumps;
		}
		
		if (distance > 0) {
			jumps = (distance / D) + ((distance % D) > 0 ? 1 : 0);
		}
		
		return jumps;
	}

}
