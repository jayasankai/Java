package com.jay.auth.jwt.controller;

public class AuthenticationResponse {
	private String jwt;
	
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return this.jwt;
	}
}
