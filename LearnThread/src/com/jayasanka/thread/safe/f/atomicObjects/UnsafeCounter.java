package com.jayasanka.thread.safe.f.atomicObjects;

public class UnsafeCounter {
	private int counter = 0;

	public void incrementCounter() {
		counter += 1;
	}

	public int getCounter() {
		return counter;
	}
}
