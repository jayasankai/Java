package com.jayasanka.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.jayasanka.kafka.dto.PublishDTO;
import com.jayasanka.kafka.util.ConsumerRebalanceListner;

@Configuration
public class KafkaConsumerConfig {
	
	private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
	
	@Value(value = "${kafka.consumer.c1.brockers:localhost:9092}")
	private String bootstrapConfig1;

	@Value(value = "${kafka.consumer.concurrency:5}")
	private int concurrency;
	
	@Value(value = "${kafka.consumer.max.pool.record:100}")
	private int maxPoolRecordConfig;
	
	@Value(value = "${kafka.consumer.max.pool.interval.ms:90000}")
	private int maxPoolInterval;
	
	@Value(value = "${kafka.consumer.request.timeout.ms:300000}")
	private int reqTimeout;
	
	@Value(value = "${kafka.consumer.heartbeat.interval.ms:1000}")
	private int heartbeatInterval;
	
	@Value(value = "${kafka.consumer.session.timeout.ms:1000}")
	private int sessionTimeout;
	
	@Value(value = "${kafka.consumer.enable.auto.commit:true}")
	private String enableAutoCommit;
	
	@Value(value = "${kafka.consumer.sync.process:N}")
	private String consumerSync;
	
	@Bean
	public ConsumerFactory<String, PublishDTO> jsonConsumerFactory() {
		logger.info("Consumer brokers : JSON");
		Map<String, Object> consumerConfig = new HashMap<>();
		consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig1);
		consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		consumerConfig.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, reqTimeout);
		consumerConfig.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatInterval);
		consumerConfig.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPoolInterval);
		consumerConfig.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPoolRecordConfig);
		consumerConfig.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
		consumerConfig.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.valueOf(enableAutoCommit));
		
		final JsonDeserializer<PublishDTO> jsonDeserializer = new JsonDeserializer<>();
		jsonDeserializer.addTrustedPackages("*");
		
		return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), jsonDeserializer);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PublishDTO> kafkaListenerJsonContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, PublishDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(jsonConsumerFactory());
		
		if ("Y".equalsIgnoreCase(consumerSync)) {
			factory.setConcurrency(concurrency);
			factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
			factory.getContainerProperties().setSyncCommits(true);
		}
		
		factory.getContainerProperties().setConsumerRebalanceListener(new ConsumerRebalanceListner());
		
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, String> stringConsumerFactory() {
		logger.info("Consumer brokers : STRING");
		Map<String, Object> consumerConfig = new HashMap<>();
		consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig1);
		consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		consumerConfig.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, reqTimeout);
		consumerConfig.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatInterval);
		consumerConfig.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPoolInterval);
		consumerConfig.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPoolRecordConfig);
		consumerConfig.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
		consumerConfig.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.valueOf(enableAutoCommit));
		
		if ("Y".equalsIgnoreCase(consumerSync)) {
			consumerConfig.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, "org.apache.kafka.clients.consumer.RoundRobinAssignor");
		}
		
		return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), new StringDeserializer());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerStringContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(stringConsumerFactory());
		
		if ("Y".equalsIgnoreCase(consumerSync)) {
			factory.setConcurrency(concurrency);
			factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
			factory.getContainerProperties().setSyncCommits(true);
		}
		
		factory.getContainerProperties().setConsumerRebalanceListener(new ConsumerRebalanceListner());
		
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, byte[]> byteConsumerFactory() {
		logger.info("Consumer brokers : BYTE");
		Map<String, Object> consumerConfig = new HashMap<>();
		consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig1);
		consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
		
		consumerConfig.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, reqTimeout);
		consumerConfig.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatInterval);
		consumerConfig.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPoolInterval);
		consumerConfig.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPoolRecordConfig);
		consumerConfig.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
		consumerConfig.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.valueOf(enableAutoCommit));
		
		
		return new DefaultKafkaConsumerFactory<>(consumerConfig, new StringDeserializer(), new ByteArrayDeserializer());
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, byte[]> kafkaListenerByteContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(byteConsumerFactory());
		
		if ("Y".equalsIgnoreCase(consumerSync)) {
			factory.setConcurrency(concurrency);
			factory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
			factory.getContainerProperties().setSyncCommits(true);
		}
		
		factory.getContainerProperties().setConsumerRebalanceListener(new ConsumerRebalanceListner());
		
		return factory;
	}

}
