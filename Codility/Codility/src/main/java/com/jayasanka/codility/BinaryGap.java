package com.jayasanka.codility;

/**
 * Iterations : [100%] BinaryGap
 * Find longest sequence of zeros in binary representation of an integer.
 *
 */
public class BinaryGap {

	public static void main(String[] args) {
		int binGap = solution(529);
		
		System.out.println(binGap);

	}
	
	
	public static int solution(int N) {
        String binStr = Integer.toBinaryString(N);

        int maxCount = 0;
        int currentCount = 0;
        boolean startCount = false;

        for (int i = 0; i < binStr.length(); i++) {
            char val = binStr.charAt(i);
            if (val == '1') {
                if (startCount) {
                    startCount = false;
                    if (maxCount < currentCount) {
                        maxCount = currentCount;
                    } else {
                        startCount = true;
                    }
                    currentCount = 0;
                }
                startCount = true;
            } else if (val == '0' && startCount) {
                currentCount++;
            }
        }

        return maxCount;
    }

}


