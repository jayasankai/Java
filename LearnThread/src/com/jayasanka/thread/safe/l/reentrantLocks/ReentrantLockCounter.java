package com.jayasanka.thread.safe.l.reentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * With intrinsic locks, the lock acquisition model is rather rigid: One thread acquires the lock, then executes a
 * method or code block, and finally releases the lock so other threads can acquire it and access the method.
 * 
 * There's no underlying mechanism that checks the queued threads and gives priority access to the longest waiting
 * threads.
 * 
 * ReentrantLock instances allow us to do exactly that, preventing queued threads from suffering some types of resource
 * starvation
 * 
 * The ReentrantLock constructor takes an optional fairness boolean parameter. When set to true, and multiple threads
 * are trying to acquire a lock, the JVM will give priority to the longest waiting thread and grant access to the lock.
 *
 */
public class ReentrantLockCounter {
	private int counter;
	private final ReentrantLock reLock = new ReentrantLock(true);

	public void incrementCounter() {
		reLock.lock();
		try {
			counter += 1;
		} finally {
			reLock.unlock();
		}
	}
	
	public int getCounter() {
		return counter;
	}
}
