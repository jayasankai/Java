package com.jayasanka.thread.safe.c.threadLocal;

import java.util.Arrays;
import java.util.List;

/**
 * In both implementations, the classes have their own state, but it's not shared with other threads. So, the classes
 * are thread-safe.
 *
 */
public class ThreadB extends Thread {

	private final List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");

	@Override
	public void run() {
		letters.forEach(System.out::println);
	}
}
