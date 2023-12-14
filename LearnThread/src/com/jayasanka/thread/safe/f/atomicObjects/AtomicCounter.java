package com.jayasanka.thread.safe.f.atomicObjects;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * It's also possible to achieve thread-safety using the set of atomic classes that Java provides, including
 * AtomicInteger, AtomicLong, AtomicBoolean and AtomicReference.
 * 
 * Atomic classes allow us to perform atomic operations, which are thread-safe, without using synchronization. An atomic
 * operation is executed in one single machine-level operation.
 * 
 * This is thread-safe because while incrementation, ++, takes more than one operation, incrementAndGet is atomic.
 *
 */
public class AtomicCounter {
	private final AtomicInteger counter = new AtomicInteger();

	public void incrementCounter() {
		counter.incrementAndGet();
	}

	public int getCounter() {
		return counter.get();
	}
}
