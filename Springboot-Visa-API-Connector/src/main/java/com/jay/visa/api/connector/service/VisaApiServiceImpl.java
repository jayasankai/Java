package com.jay.visa.api.connector.service;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jay.visa.api.connector.exception.ApiException;

@Service
public class VisaApiServiceImpl implements VisaApiService {

	@Value("${visa.client.ssl.trust-store}")
	private String keyStorePath;

	@Value("${visa.client.ssl.trust-store-password}")
	private String keyStorePassword;

	@Value("${visa.client.ssl.private-key-password}")
	private String privateKeyPassword;
	
	@Value("${visa.client.ssl.user-id}")
	private String clientUserId;
	
	@Value("${visa.client.ssl.user-password}")
	private String clientUserPassword;

	@Value("${visa.service.uri}")
	private String visaServiceUri;

	@Override
	public String visaApiHelloWorld() throws ApiException {
		try {

			// Load client certificate into key store
			SSLContext sslcontext;
			try {
				sslcontext = SSLContexts.custom()
						.loadKeyMaterial(new File(keyStorePath), keyStorePassword.toCharArray(),
								privateKeyPassword.toCharArray())
						.loadTrustMaterial(new File(keyStorePath), keyStorePassword.toCharArray()).build();
			} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException
					| CertificateException e) {
				throw new ApiException("Exception :: SSL key Store");
			}

			// Allow TLSv1.2 protocol only
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslcontext,
					new String[] { "TLSv1.2" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());

			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			HttpGet httpGet = new HttpGet(visaServiceUri + "/vdp/helloworld");
			httpGet.setHeader("Authorization", getBasicAuthenticationHeader(clientUserId, clientUserPassword));
			
			try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
				HttpEntity entity = response.getEntity();

				String responseString = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);

				return responseString;
			}

		} catch (IOException e) {
			throw new ApiException("Exception :: API service exception!");
		}
	}
	
	private String getBasicAuthenticationHeader(String username, String password) {
	    String valueToEncode = username + ":" + password;
	    return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	}

}
