package com.jayasanka.kafka.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.jayasanka.kafka.controller.KafkaProducerController;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class ApplicationTests {
	
	@Autowired
	KafkaProducerController producerController;

	@Test
	public void contextLoads() {
		
		for (int i=0; i < 500; i++) {			
			producerController.publish("Message_" + i);
		}
	}

}
