package com.jayasanka.thread.safe.c.threadLocal;

public class StateHolder {
	private String state;

	public String getState() {
		return state;
	}

	public StateHolder(String state) {
		super();
		this.state = state;
	}
}
