package com.design.pattern.scatter_gather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriceGatterApp {

	private ExecutorService executer = Executors.newFixedThreadPool(4);

	public static void main(String[] args) throws InterruptedException {
		PriceGatterApp app = new PriceGatterApp();
		Set<Double> prices = app.getPrices();

		prices.forEach(System.out::println);
	}

	public Set<Double> getPrices() throws InterruptedException {
		Set<Double> prices = Collections.synchronizedSet(new HashSet<>());

		executer.submit(new Task("url1", "prodId", prices));
		executer.submit(new Task("url2", "prodId", prices));
		executer.submit(new Task("url3", "prodId", prices));

		Thread.sleep(1000 * 3);

		return prices;

	}

}
