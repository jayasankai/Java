package com.jayasanka.algo.token.bucket;

public class TokenBucketTest {
	public static void main(String args[]) {
		TokenBucket b = new TokenBucket(10);
		Thread tokens = new AddTokenThread(b);
		Thread packets = new AddPacketThread(b);
		try {
			tokens.start();
			packets.start();
		} catch (Exception e) {
		}
	}
}
