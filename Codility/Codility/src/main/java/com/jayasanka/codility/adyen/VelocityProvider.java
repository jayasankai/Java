package com.jayasanka.codility.adyen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface VelocityProvider {
	int getCardUsageCount(Payment payment, Duration duration);

	void registerPayment(Payment payment);

	static VelocityProvider getProvider() {
		return new VelocityProvider() {

			Map<String, List<Payment>> paymentCache = new HashMap<>();

			@Override
			public void registerPayment(Payment payment) {
				if (!paymentCache.containsKey(payment.getHashedCardNumber())) {
					paymentCache.put(payment.getHashedCardNumber(), new ArrayList<>());
				}
				paymentCache.get(payment.getHashedCardNumber()).add(payment);
			}

			@Override
			public int getCardUsageCount(Payment payment, Duration duration) {
				long count = paymentCache.get(payment.getHashedCardNumber())
						.stream()
						.filter(p -> (p.getTimestamp().isAfter(payment.getTimestamp().minus(duration))))
						.count();
				return (int) count;
			}
		};
	}
}
