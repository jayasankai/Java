package com.jayasanka.codility.adyen;

import java.time.Instant;

public class Payment {
	private String paymentId;
	private Instant timestamp;
	private String hashedCardNumber;

	public Payment(String paymentId, Instant timestamp, String hashedCardNumber) {
		this.paymentId = paymentId;
		this.timestamp = timestamp;
		this.hashedCardNumber = hashedCardNumber;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public String getHashedCardNumber() {
		return hashedCardNumber;
	}

}
