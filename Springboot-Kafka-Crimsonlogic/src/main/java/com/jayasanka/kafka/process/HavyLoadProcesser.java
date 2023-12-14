package com.jayasanka.kafka.process;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HavyLoadProcesser {
	private Logger logger = LoggerFactory.getLogger(HavyLoadProcesser.class);
	
	public void doProcess(String message) {
		logger.info("START Process for message:{}", message);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			logger.error(e.getMessage());
		}
		
		logger.info("END Process for message:{}", message);
	}
}
