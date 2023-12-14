package com.jayasanka.kafka.dto;

import java.io.Serializable;

public class PublishDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	String id;
	String message;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
