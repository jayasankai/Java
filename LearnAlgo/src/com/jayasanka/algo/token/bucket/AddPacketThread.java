package com.jayasanka.algo.token.bucket;

public class AddPacketThread extends Thread {
	TokenBucket b;

	AddPacketThread(TokenBucket b) {
		this.b = b;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500 + (int) (Math.random() * 3000));
			} catch (Exception e) {
			}
			b.sendPacket(1 + (int) (Math.random() * 9));
		}
	}
}