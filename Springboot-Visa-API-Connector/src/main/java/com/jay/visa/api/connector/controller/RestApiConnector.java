package com.jay.visa.api.connector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.visa.api.connector.exception.ApiException;
import com.jay.visa.api.connector.service.VisaApiServiceImpl;

@RestController
public class RestApiConnector {
	
	@Autowired
	VisaApiServiceImpl apiService;
	
	@GetMapping("/vdp/helloworld")
	public String helloWorld() throws ApiException {
		return apiService.visaApiHelloWorld();
	}

}
