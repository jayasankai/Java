package com.jayasanka.thread.safe.l.reentrantLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Another powerful mechanism that we can use for achieving thread-safety is the use of ReadWriteLock implementations.
 * 
 * A ReadWriteLock lock actually uses a pair of associated locks, one for read-only operations and the other for writing
 * operations.
 * 
 * As a result, it's possible to have many threads reading a resource, as long as there's no thread writing to it.
 * Moreover, the thread writing to the resource will prevent other threads from reading it.
 *
 */
public class ReentrantReadWriteLockCounter {
	private int counter;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    
    public void incrementCounter() {
        writeLock.lock();
        try {
            counter += 1;
        } finally {
            writeLock.unlock();
        }
    }
    
    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }
}
