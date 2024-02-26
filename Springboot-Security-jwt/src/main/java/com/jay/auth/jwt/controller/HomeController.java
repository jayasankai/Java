package com.jay.auth.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jay.auth.jwt.service.CustomUserDetailsService;
import com.jay.auth.jwt.utils.JwtUtils;

@RestController
public class HomeController {

	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping("/hello")
	public String getHello() {
		return "Hello";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authRequest) {
		final UserDetails userDetails = new CustomUserDetailsService().loadUserByUsername(authRequest.getUserName());

		final String jwtToken = jwtUtils.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
	}
}
