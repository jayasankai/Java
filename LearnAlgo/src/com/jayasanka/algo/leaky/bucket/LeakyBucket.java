package com.jayasanka.algo.leaky.bucket;

public class LeakyBucket {

	public static void main(String[] args) {
		int bucketSize = 10;
		int inputRate = 4;
		int outputRate = 1;
		
		int numOfIterations = 10;
		int currentSizeInBucket = 0;
		int sizeLeftInBucket;
		
		for(int i = 0; i < numOfIterations; i++) {
			sizeLeftInBucket = bucketSize - currentSizeInBucket;
			
			if (inputRate <= sizeLeftInBucket) {
				currentSizeInBucket += inputRate;
				System.out.println("Added " + inputRate + " to bucket. Current Bucket Size " + currentSizeInBucket);
			} else {
				System.out.println("Packet loss = " + inputRate);
			}
			
			currentSizeInBucket -= outputRate;
			System.out.println("Removed " + outputRate + " from bucket. Current Bucket Size " + currentSizeInBucket);
		}

	}

}
