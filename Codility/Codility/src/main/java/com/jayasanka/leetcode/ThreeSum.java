package com.jayasanka.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = new int[] {-1,0,1,2,-1,-4};
		List<List<Integer>> result = threeSum(nums);
		
		System.out.println("Results:" );
		for (List<Integer> list : result) {
			System.out.println("[" + list.get(0) + "][" + list.get(1) + "][" + list.get(2) + "]");
		}

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int current = 0; current < nums.length - 2; current++) {

            // Skip duplicates for 'current' pointer
            if (current > 0 && nums[current] == nums[current - 1]) {
                continue;
            }

            int low = current + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[current] + nums[low] + nums[high];
                if (sum == 0) {
                    // Found a triplet with zero sum
                    result.add(Arrays.asList(nums[current], nums[low], nums[high]));

                    // Skip duplicates for 'low' pointer
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    // Skip duplicates for 'high' pointer
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    // Move the pointers
                    low++;
                    high--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment 'low' to increase the sum
                    low++;
                } else {
                   // Sum is grater than zero, increment 'high' to decrease the sum
                    high--; 
                }
            }

        }

        return result;
    }

}
