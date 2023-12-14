package com.jayasanka.algo.search.binary;

/**
 * Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half. The
 * idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40, 50, 64, 71, 88, 90, 100 };
		int n = arr.length;
		int value = 88;
		int result = ob.binarySearch(arr, 0, n - 1, value);

		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);

	}

	/**
	 * Returns index of x if it is present in arr[l..r], else return -1
	 */
	int binarySearch(int[] arr, int leftIdx, int rightIdx, int value) {
		if (rightIdx >= leftIdx) {
			int midIdx = leftIdx + (rightIdx - 1) / 2;

			if (arr[midIdx] == value) {
				return midIdx;
			} else if (arr[midIdx] > value) {
				return binarySearch(arr, leftIdx, midIdx - 1, value);
			} else {
				return binarySearch(arr, midIdx + 1, rightIdx, value);
			}
		}

		return -1;
	}

}
