package com.jayasanka.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.jayasanka.kafka.dto.RebalanceObject;
import com.jayasanka.kafka.process.HavyLoadProcesser;
import com.jayasanka.kafka.util.ConsumerRebalanceListner;

@Component
public class KafkaConsumerService {

	private Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

	@Autowired
	ThreadPoolTaskExecutor executor;

	@KafkaListener(topics = "${kafka.consumer.topic.name:topic.high.message}", groupId = "${kafka.consumer.group.name:topic_high_message}", containerFactory = "kafkaListenerStringContainerFactory")
	public void listen(ConsumerRecord<String, String> consumerRecord, @Payload String message,
			Acknowledgment acknowledgment) {
		logger.info("ConsumeMessage: " + message + ", Topic:" + consumerRecord.topic());

		ConsumerRebalanceListner consumerRebalanceListner = RebalanceObject.getInstance();
		consumerRebalanceListner.addOffset(consumerRecord.topic(), consumerRecord.partition(), consumerRecord.offset());
		acknowledgment.acknowledge();

		executor.execute(getTask(message));
		
//		HavyLoadProcesser process = new HavyLoadProcesser();
//		process.doProcess(message);

	}

	private Runnable getTask(String message) {
		return () -> {
			HavyLoadProcesser process = new HavyLoadProcesser();
			process.doProcess(message);
		};
	}
}
