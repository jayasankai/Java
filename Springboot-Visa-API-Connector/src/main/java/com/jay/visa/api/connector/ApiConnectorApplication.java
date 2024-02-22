package com.jay.visa.api.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application for the Visa API connector
 * 
 * TODO:
 * 	1. Url authentication filters to be added.
 *  2. Security features like rate limiters to be implemented or handle via Saas level.
 *  3. Rest Application authentication layer is minimal as of now.
 */
@SpringBootApplication
public class ApiConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiConnectorApplication.class, args);
	}

}
