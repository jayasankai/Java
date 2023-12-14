package com.jayasanka.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayasanka.kafka.dto.ProducerDTO;
import com.jayasanka.kafka.service.KafkaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	@Autowired
	private KafkaProducerService producer;
	
	@PostMapping(value = "/publish")
	public void publish(@RequestParam("message") String message) {
		
		ProducerDTO<String> producerDto = new ProducerDTO<>();
		producerDto.setTopicName("springboot.kafka.topic");
		producerDto.setConsumerGroupId("springboot_kafka_topic");
		producerDto.setType("STRING");
		producerDto.setRetryCount(1);
		producerDto.setKey("key");
		producerDto.setData(message);
		
		producer.sendToTopic(producerDto);
	}
}
