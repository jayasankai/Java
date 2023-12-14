package com.jayasanka.thread.safe.g.synchronizedMethods;

/**
 * Synchronized methods rely on the use of “intrinsic locks” or “monitor locks.” An intrinsic lock is an implicit
 * internal entity associated with a particular class instance.
 * 
 * When a thread calls a synchronized method, it acquires the intrinsic lock. After the thread finishes executing the
 * method, it releases the lock, which allows other threads to acquire the lock and get access to the method.
 * 
 * We can implement synchronization in instance methods, static methods and statements (synchronized statements)
 *
 */
public class SynchronizedMethodsTest {

	int counter;

	public synchronized void incrementCounter() {
		counter += 1;
	}

}
