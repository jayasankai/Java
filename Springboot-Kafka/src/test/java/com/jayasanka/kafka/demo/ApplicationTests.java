package com.jayasanka.kafka.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jayasanka.kafka.app.service.ProducerService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	ProducerService service;

	@Test
	void testProducerConsumerTest() {
		
		for (int i = 0; i < 10; i++) {
			service.sendMessage("Test" + i);
		}
		
	}

}
