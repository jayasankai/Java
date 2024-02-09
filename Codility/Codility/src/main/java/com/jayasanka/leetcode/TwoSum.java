package com.jayasanka.leetcode;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 4, 3, 0 };
		int[] rowSum = twoSum(nums, 0);

		for (int i : rowSum) {
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] rowSum = new int[2];

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					rowSum[0] = i;
					rowSum[1] = j;

					break;
				}
			}
		}
		return rowSum;
	}

	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> a = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (a.containsKey(target - nums[i]))
				return new int[] { a.get(target - nums[i]), i };

			a.put(nums[i], i);
		}
		return new int[] {};
	}
}
