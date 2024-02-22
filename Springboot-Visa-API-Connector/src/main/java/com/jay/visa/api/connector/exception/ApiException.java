package com.jay.visa.api.connector.exception;

public class ApiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ApiException() {}
	
	public ApiException(String message) {
		super(message);
		this.message = message;
	}
}
