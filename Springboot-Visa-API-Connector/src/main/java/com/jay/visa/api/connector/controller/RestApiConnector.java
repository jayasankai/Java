package com.jay.visa.api.connector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.visa.api.connector.exception.ApiException;
import com.jay.visa.api.connector.service.VisaApiServiceImpl;

/**
 * This class handles REST API calls which related to Visa APIs.
 * 
 * Service layer handle the authentication and returns validated responses.
 * TODO: pending to add request layer validations
 */
@RestController
public class RestApiConnector {
	private Logger logger = LoggerFactory.getLogger(RestApiConnector.class);
	
	@Autowired
	VisaApiServiceImpl apiService;
	
	@GetMapping("/vdp/helloworld")
	public String helloWorld() throws ApiException {
		logger.info("RestApiConnector calling 'helloWorld' API.");
		return apiService.visaApiHelloWorld();
	}

}
