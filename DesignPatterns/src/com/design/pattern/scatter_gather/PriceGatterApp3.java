package com.design.pattern.scatter_gather;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PriceGatterApp3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		PriceGatterApp3 app = new PriceGatterApp3();
		Set<Double> prices = app.getPrices();

		prices.forEach(System.out::println);
	}

	public Set<Double> getPrices() throws InterruptedException, ExecutionException, TimeoutException {
		Set<Double> prices = Collections.synchronizedSet(new HashSet<>());
		
		CompletableFuture<Void> task1 = CompletableFuture.runAsync(new Task("url1", "prodId", prices));
		CompletableFuture<Void> task2 = CompletableFuture.runAsync(new Task("url2", "prodId", prices));
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(new Task("url3", "prodId", prices));


		CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
		allTasks.get(3, TimeUnit.SECONDS);

		return prices;

	}

}
