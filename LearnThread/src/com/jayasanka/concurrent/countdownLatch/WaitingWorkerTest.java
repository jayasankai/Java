package com.jayasanka.concurrent.countdownLatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WaitingWorkerTest {
	public static void main(String[] args) throws InterruptedException {
		
		List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch readyThreadCounter = new CountDownLatch(5);
		CountDownLatch callingThreadBlocker = new CountDownLatch(1);
		CountDownLatch completedThreadCounter = new CountDownLatch(5);
		
		List<Thread> workers = Stream.generate(() -> new Thread(
				new WaitingWorker(
						outputScraper, 
						readyThreadCounter, 
						callingThreadBlocker, 
						completedThreadCounter)))
				.limit(5).collect(Collectors.toList());

		workers.forEach(Thread::start);
		readyThreadCounter.await();
		// boolean completed = countDownLatch.await(3L, TimeUnit.SECONDS);
		outputScraper.add("Workers ready");
		
		callingThreadBlocker.countDown();
		
		completedThreadCounter.await();
		outputScraper.add("Workers complete");
	}
}
