package com.jay.visa.api.connector;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jay.visa.api.connector.service.VisaApiService;

@SpringBootTest
public class VisaApiTest {
	
	@Autowired
	VisaApiService apiService;
	
	CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
	
	@Test
	void contextLoads() throws ClientProtocolException, IOException {
		
		CloseableHttpResponse response = mock(CloseableHttpResponse.class);
		HttpEntity entity = mock(HttpEntity.class);
	    when(httpClient.execute(Mockito.any(HttpGet.class))).thenReturn(response);
	    when(response.getEntity()).thenReturn(entity);
	    
		apiService.visaApiHelloWorld();
		
	}

}
