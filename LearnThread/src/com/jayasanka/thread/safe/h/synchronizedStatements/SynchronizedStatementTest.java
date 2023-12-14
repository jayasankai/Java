package com.jayasanka.thread.safe.h.synchronizedStatements;

/**
 * Unlike synchronized methods, synchronized statements must specify the object that provides the intrinsic lock,
 * usually the this reference.
 * 
 * Synchronization is expensive, so with this option, we are able to only synchronize the relevant parts of a method.
 *
 */
public class SynchronizedStatementTest {

	int counter;

	public void incrementCounter() {
		// additional unsynced operations
		synchronized (this) {
			counter += 1;
		}
	}
}
