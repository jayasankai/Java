package com.jayasanka.thread.safe.c.threadLocal;

import java.util.Arrays;
import java.util.List;

/**
 * In both implementations, the classes have their own state, but it's not shared with other threads. So, the classes
 * are thread-safe.
 *
 */
public class ThreadA extends Thread {
    
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    @Override
    public void run() {
        numbers.forEach(System.out::println);
    }
}
