package com.jayasanka.kafka.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class ConsumerService {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
	@Value(value = "${spring.kafka.kafka.topic.name}")
	private String topicName;

	@KafkaListener(topics = "${spring.kafka.kafka.topic.name}", groupId = "${spring.kafka.kafka.consumer.group.id.1}")
	public void listen(String message) {
		System.out.println("listen :: Received Message in group foo: " + message);
	}

	@KafkaListener(topics = "${spring.kafka.kafka.topic.name}", groupId = "${spring.kafka.kafka.consumer.group.id.2}")
	public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
		System.out.println("listenWithHeaders :: Received Message: " + message + "from partition: " + partition);
	}

	@KafkaListener(
			topicPartitions = @TopicPartition(
					topic = "${spring.kafka.kafka.topic.name}",
					partitions = { "0", "1" }
			), 
			containerFactory = "partitionsKafkaListenerContainerFactory",
			groupId = "${spring.kafka.kafka.consumer.group.id.3}")
	public void listenToPartition(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
		System.out.println("listenToPartition :: Received Message: " + message + "from partition: " + partition);
	}
	
	@KafkaListener(
			topicPartitions = @TopicPartition(
					topic = "${spring.kafka.kafka.topic.name}",
					partitionOffsets = {
							@PartitionOffset(partition = "0", initialOffset = "0"),
							@PartitionOffset(partition = "3", initialOffset = "0") 
					}
			), 
			containerFactory = "partitionsKafkaListenerContainerFactory",
			groupId = "${spring.kafka.kafka.consumer.group.id.4}")
	public void listenToPartitionWithOffset(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
		System.out.println("listenToPartitionWithOffset :: Received Message: " + message + "from partition: " + partition);
	}
}
