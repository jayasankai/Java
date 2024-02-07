package com.jayasanka.algo.token.bucket;

public class TokenBucket {
	public int tokens, maxsize;
	
	TokenBucket(int max){
		tokens = 0;
		maxsize = max;
	}
	
	synchronized void addToken(int n){
		if(tokens >= maxsize) return;
		tokens += 1;
		System.out.println("Added a token. Total:" + tokens);
	}
	
	synchronized void sendPacket(int n){
		System.out.println("Packet of size " + n + " arrived");
		if(n > tokens){
			System.out.println("Packet is non comformant, discarded");
		} else{
			tokens -= n;
			System.out.println("Forwarding packet");
		}
	}
}
