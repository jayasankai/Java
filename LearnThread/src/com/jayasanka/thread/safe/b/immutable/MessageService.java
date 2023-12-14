package com.jayasanka.thread.safe.b.immutable;

/**
 * A class instance is immutable when its internal state can't be modified after it has been constructed.
 * 
 * The easiest way to create an immutable class in Java is by declaring all the fields private and final and not
 * providing setters
 *
 */
public class MessageService {
	private final String message;

	public MessageService(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
