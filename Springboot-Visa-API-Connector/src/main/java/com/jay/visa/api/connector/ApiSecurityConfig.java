package com.jay.visa.api.connector;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jay.visa.api.connector.exception.ApiException;

@Configuration
public class ApiSecurityConfig {
	
	private Logger logger = LoggerFactory.getLogger(ApiSecurityConfig.class);

	@Value("${visa.client.ssl.trust-store}")
	private String keyStorePath;

	@Value("${visa.client.ssl.trust-store-password}")
	private String keyStorePassword;

	@Value("${visa.client.ssl.private-key-password}")
	private String privateKeyPassword;
	
	@Bean
	public CloseableHttpClient getCloseableHttpClient() throws IOException {
		logger.info("Load client certificate into key store");
		SSLContext sslcontext;
		try {
			sslcontext = SSLContexts.custom()
					.loadKeyMaterial(new File(keyStorePath), keyStorePassword.toCharArray(), privateKeyPassword.toCharArray())
					.loadTrustMaterial(new File(keyStorePath), keyStorePassword.toCharArray()).build();
		} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException
				| CertificateException e) {
			logger.error("Exception :: SSL key Store. Exception message :: {}", e.getMessage());
			throw new ApiException("Exception :: SSL key Store");
		}

		logger.info("Allow TLSv1.2 protocol only");
		SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslcontext,
				new String[] { "TLSv1.2" }, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());

		return HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
	}
}
