package com.jayasanka.codility.adyen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	external API calling to 
 *  data analytics -> Adyen as a middleware -> fraud detection | transaction limiting
 *	- card usage
 *	- 
 *
 */
interface VelocityProvider2 {
	int getCardUsageCount(Payment payment, Duration duration);

	void registerPayment(Payment payment);

	static VelocityProvider2 getProvider() {
		return new VelocityProvider2() {

			Map<String, List<Payment>> paymentCache = new HashMap<>();

			@Override
			public void registerPayment(Payment payment) {
				// With compute if absent
				paymentCache.computeIfAbsent(payment.getHashedCardNumber(), item -> new ArrayList<Payment>()).add(payment);
				
				// 
//				if (!paymentCache.containsKey(payment.getHashedCardNumber())) {
//					paymentCache.put(payment.getHashedCardNumber(), new ArrayList<>());
//				}
//				paymentCache.get(payment.getHashedCardNumber()).add(payment);
			}

			@Override
			public int getCardUsageCount(Payment payment, Duration duration) {
				// With binary search
				long count = paymentCache.get(payment.getHashedCardNumber())
						.stream()
						.takeWhile(p -> (p.getTimestamp().isAfter(payment.getTimestamp().minus(duration))))
						.count();
				
				
				// takeWhile java 9
				long count2 = paymentCache.get(payment.getHashedCardNumber())
						.parallelStream()
						.takeWhile(p -> (p.getTimestamp().isAfter(payment.getTimestamp().minus(duration))))
						.count();
				
				// With Parallel streams
				long count3 = paymentCache.get(payment.getHashedCardNumber())
						.parallelStream()
						.filter(p -> (p.getTimestamp().isAfter(payment.getTimestamp().minus(duration))))
						.count();
				
				
				// With streams
				long count4 = paymentCache.get(payment.getHashedCardNumber())
						.stream()
						.filter(p -> (p.getTimestamp().isAfter(payment.getTimestamp().minus(duration))))
						.count();
				return (int) count;
			}
			
		};
	}
}
