package com.jayasanka.kafka.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
	@Value(value = "${spring.kafka.kafka.topic.name}")
	private String topicName;
	
	@Value(value = "${spring.kafka.kafka.topic.numOfPartitions}")
	private int numOfPartitions;
	
	@Value(value = "${spring.kafka.kafka.topic.replicationFactor}")
	private short replicationFactor;

	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return new KafkaAdmin(configs);
	}

	@Bean
	public NewTopic topic1() {
		return new NewTopic(topicName, numOfPartitions, replicationFactor);
	}
}
