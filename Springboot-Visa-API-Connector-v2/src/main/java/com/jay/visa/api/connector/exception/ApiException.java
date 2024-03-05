package com.jay.visa.api.connector.exception;

/**
 * Generic API Exception class
 */
public class ApiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	
	public ApiException() {}
	
	public ApiException(String message) {
		super(message);
		this.message = message;
	}
}
