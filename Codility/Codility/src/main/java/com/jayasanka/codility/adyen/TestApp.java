package com.jayasanka.codility.adyen;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class TestApp {

	public static void main(String[] args) {
		VelocityProvider2 velocityProvider = VelocityProvider2.getProvider();

		for (int i = 0; i < 15; i++) {
			velocityProvider.registerPayment(
					new Payment(
							UUID.randomUUID().toString(), 
							Instant.now().minusMillis(i * 10), 
							"c"+ i%5));
		}
		
		System.out.println(velocityProvider.getCardUsageCount(new Payment(
							UUID.randomUUID().toString(), 
							Instant.now().minusMillis(10), 
							"c2"), Duration.ofSeconds(20)));

	}

}
