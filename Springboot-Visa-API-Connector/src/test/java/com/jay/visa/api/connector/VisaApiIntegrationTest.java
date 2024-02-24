package com.jay.visa.api.connector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jay.visa.api.connector.service.VisaApiService;

/**
 * Integration tests for API module
 */
@SpringBootTest
public class VisaApiIntegrationTest {
	
	@Autowired
	VisaApiService apiService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	void visaApiConnectorTest() throws ClientProtocolException, IOException {
	    
	    String response = apiService.visaApiHelloWorld();
	    Map<String,String> responseMap = mapper.readValue(response, new TypeReference<HashMap<String,String>>() {});
	    
	    if (responseMap != null && !responseMap.isEmpty()) {
	    	assertEquals((String)responseMap.get("message"), "helloworld");
	    }
	}

}
