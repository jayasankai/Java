package com.jayasanka.algo.token.bucket;

public class AddTokenThread extends Thread {
	TokenBucket b;

	AddTokenThread(TokenBucket b) {
		this.b = b;
	}

	public void run() {
		while (true) {
			b.addToken(1);
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
	}
}
