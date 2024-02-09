package com.jayasanka.leetcode;

public class RemoveDuplicatesInSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2 };
		int size = removeDuplicates(nums);
		System.out.println(size);

	}

	public static int removeDuplicates(int[] nums) {
		int k = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[k] = nums[i + 1];
				k++;
			}
		}
		return k;
	}

}
