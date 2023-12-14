package com.design.pattern.scatter_gather;

import java.util.Set;

public class Task implements Runnable {

	private String url;
	private String productId;
	private Set<Double> prices;

	public Task(String url, String productId, Set<Double> prices) {
		super();
		this.url = url;
		this.productId = productId;
		this.prices = prices;
	}

	@Override
	public void run() {
		try {
			System.out.println("Calling " + this.url + " service to get data..");
			Thread.sleep(1000 * 2);
			prices.add(12.25 + (Math.round((Math.random() * 1000))/100d));
			System.out.println("Data received from: " + this.url);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
