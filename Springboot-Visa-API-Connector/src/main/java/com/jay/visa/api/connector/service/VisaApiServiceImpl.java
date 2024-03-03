package com.jay.visa.api.connector.service;

import java.io.IOException;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jay.visa.api.connector.exception.ApiException;

/**
 * This Service Class is used to handle Visa API Services
 */
@Service
public class VisaApiServiceImpl implements VisaApiService {
	
	private Logger logger = LoggerFactory.getLogger(VisaApiServiceImpl.class);

	@Value("${visa.client.ssl.user-id}")
	private String clientUserId;
	
	@Value("${visa.client.ssl.user-password}")
	private String clientUserPassword;

	@Value("${visa.service.uri}")
	private String visaServiceUri;
	
	@Autowired
	CloseableHttpClient httpClient;

	/**
	 * Handle API request for Hello World
	 * 
	 * Returns : Response
	 * Throws : API Exception 
	 * 
	 * TODO: 
	 *  1. pending to add Validations as per the business logics
	 *  2. User IDs and passwords should be retrieved from DB layer
	 *  3. Files (Private key and other security files) should be stored in secure repository or byte stream in DB
	 * 
	 */
	@Override
	public String visaApiHelloWorld() {
		logger.info("Calling Visa API for Hello World");
		
		try {
			logger.info("Set basic authentication for {} url", visaServiceUri);
			HttpGet httpGet = new HttpGet(visaServiceUri + "/vdp/helloworld");
			httpGet.setHeader("Authorization", getBasicAuthenticationHeader(clientUserId, clientUserPassword));
			
			logger.info("Calling http '/vdp/helloworld' request");
			try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
				HttpEntity entity = response.getEntity();

				String responseString = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);

				logger.info("Response received for '/vdp/helloworld' ");
				logger.debug("Response: {}", responseString);
				return responseString;
			}
		} catch (IOException e) {
			logger.error("Exception :: API service exception!. Exception message :: {}", e.getMessage());
			throw new ApiException("Exception :: API service exception!");
		}
	}
	
	private String getBasicAuthenticationHeader(String username, String password) {
	    String valueToEncode = username + ":" + password;
	    return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	}

}
