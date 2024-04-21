package com.jayasanka.coderbyte.activateInteractive;

import java.util.ArrayList;
import java.util.List;

public class SeatingArrangment {

	public static void main(String[] args) {
		int totalAvailableCombinations = arrayChallenge(new int[] {12, 2, 5, 7, 10});
		System.out.println(totalAvailableCombinations);

	}
	
	public static int arrayChallenge(int[] arr) {
	    // Total combinations
	    int totalNoCombinations = arr[0]/2 + (arr[0]/2 - 1)*2;

	    // Seat occupied array
	    List<Integer> seatArr = new ArrayList<Integer>();
	    for (int i=1; i < arr.length; i++) {
	      seatArr.add(arr[i]);
	    }
	    
	    // Remove used combinations from all
	    for (int i=1; i <= arr[0]; i++) {
	      if (seatArr.contains(i) && (i == 1 || i == 2 || i == arr[0] -1 || i == arr[0])) {
	        totalNoCombinations = totalNoCombinations - 2;
	      } else if (seatArr.contains(i)) {
	        totalNoCombinations = totalNoCombinations - 3;
	      }
	    }

	    return totalNoCombinations;
	  }

}
