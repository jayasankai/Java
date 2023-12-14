package com.design.pattern.scatter_gather;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class Task2 implements Runnable {
	
	private String url;
	private String productId;
	private volatile Set<Double> prices;
	private CountDownLatch latch;
	
	public Task2(String url, String productId, Set<Double> prices, CountDownLatch latch) {
		super();
		this.url = url;
		this.productId = productId;
		this.prices = prices;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println("Calling " + this.url + " service to get data..");
			Thread.sleep(1000 * 2);
			prices.add(12.25 + (Math.round((Math.random() * 1000))/100d));
			System.out.println("Data received from: " + this.url);
			latch.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
