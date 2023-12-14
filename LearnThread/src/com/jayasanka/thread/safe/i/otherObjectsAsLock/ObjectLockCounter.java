package com.jayasanka.thread.safe.i.otherObjectsAsLock;

public class ObjectLockCounter {
	private int counter = 0;
    private final Object lock = new Object();
    
    public void incrementCounter() {
        synchronized(lock) {
            counter = getCounter() + 1;
        }
    }

	public int getCounter() {
		return counter;
	}
    
}
