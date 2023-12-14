package com.jayasanka.thread.safe.d.synchronizedCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Note : synchronized collections use intrinsic locking in each method
 * 
 * This means that the methods can be accessed by only one thread at a time, while other threads will be blocked until
 * the method is unlocked by the first thread.
 * 
 * Thus, synchronization has a penalty in performance, due to the underlying logic of synchronized access.
 *
 */
public class WrapperCollectionsTest {

	public static void main(String[] args) {
		Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		
		method1();
	}

	private static void method1() {
		Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

		Thread thread1 = new Thread(() -> syncCollection.addAll(Arrays.asList(1, 2, 3, 4, 5, 6)));
		Thread thread2 = new Thread(() -> syncCollection.addAll(Arrays.asList(7, 8, 9, 10, 11, 12)));

		thread1.start();
		thread2.start();
	}

}
