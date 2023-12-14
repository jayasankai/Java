package com.design.pattern.scatter_gather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PriceGatterApp2 {

	private ExecutorService executer = Executors.newFixedThreadPool(4);

	public static void main(String[] args) throws InterruptedException {
		PriceGatterApp2 app = new PriceGatterApp2();
		Set<Double> prices = app.getPrices();

		prices.forEach(System.out::println);
	}

	public Set<Double> getPrices() throws InterruptedException {
		Set<Double> prices = Collections.synchronizedSet(new HashSet<>());
		CountDownLatch latch = new CountDownLatch(3);

		executer.submit(new Task2("url1", "prodId", prices, latch));
		executer.submit(new Task2("url2", "prodId", prices, latch));
		executer.submit(new Task2("url3", "prodId", prices, latch));

		latch.await(3, TimeUnit.SECONDS);

		return prices;

	}

}
