package com.jayasanka.leetcode;

public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3 };
		int maxArea = maxArea(height);
		System.out.println(maxArea);

	}

	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			int currentHeight = Math.min(height[left], height[right]);
			int currentWidth = right - left;
			int currentArea = currentHeight * currentWidth;

			maxArea = Math.max(maxArea, currentArea);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}