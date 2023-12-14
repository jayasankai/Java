package com.jayasanka.thread.safe.k.volatileField;

/**
 * Synchronized methods and blocks are handy for addressing variable visibility problems among threads. Even so, the
 * values of regular class fields might be cached by the CPU. Hence, consequent updates to a particular field, even if
 * they're synchronized, might not be visible to other threads.
 * 
 * To prevent this situation, we can use volatile class fields:
 * 
 * With the volatile keyword, we instruct the JVM and the compiler to store the counter variable in the main memory.
 * That way, we make sure that every time the JVM reads the value of the counter variable, it will actually read it from
 * the main memory, instead of from the CPU cache. Likewise, every time the JVM writes to the counter variable, the
 * value will be written to the main memory.
 *
 */
public class VolatileTest {

	private volatile int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
