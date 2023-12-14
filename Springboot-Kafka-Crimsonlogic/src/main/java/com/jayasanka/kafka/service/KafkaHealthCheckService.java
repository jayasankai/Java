package com.jayasanka.kafka.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListConsumerGroupOffsetsResult;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class KafkaHealthCheckService {

	private Logger logger = LoggerFactory.getLogger(KafkaHealthCheckService.class);

	@Value(value = "${kafka.health.check.brockers:localhost:9092}")
	private String bootstrapConfig;

	@Value(value = "#{${kafka.health.check.consumer.group}}")
	private Map<String, String> consumerMap;

	@Value(value = "${kafka.health.check.maxQueueDepth:25000}")
	private int maxQueueDepth;

	@Scheduled(fixedRateString = "${kafka.health.check.retry.interval:300000}", initialDelayString = "${kafka.health.check.initial.delay:2000}")
	public void topicHealthCheck() {
		logger.info("topicHealthCheck :: Started ::");

		Map<String, Boolean> consumerFlag = new HashMap<>();

		if (consumerMap != null && !consumerMap.isEmpty()) {
			for (Entry<String, String> entry : consumerMap.entrySet()) {
				logger.info("Map Data :: " + entry.getKey() + " :: " + entry.getValue());
				consumerFlag.put(entry.getKey(), kafkaHeartBeatCheck(entry.getKey(), entry.getValue()));
			}
		}
	}

	public boolean kafkaHeartBeatCheck(String type, String consumerGroupId) {
		logger.info("Consumer Group Id :: " + consumerGroupId);

		Properties hbConsumerProp = new Properties();
		hbConsumerProp.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig);
		hbConsumerProp.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		hbConsumerProp.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(hbConsumerProp);
				AdminClient client = AdminClient.create(hbConsumerProp)) {
			ListConsumerGroupOffsetsResult offsets = client.listConsumerGroupOffsets(consumerGroupId);
			Map<TopicPartition, OffsetAndMetadata> tt = offsets.partitionsToOffsetAndMetadata().get();
			
			for (Map.Entry<TopicPartition, OffsetAndMetadata> entry : tt.entrySet()) {
				TopicPartition topicPartition = entry.getKey();
				OffsetAndMetadata offsetAndMetadata = entry.getValue();
				
				consumer.assign(Collections.singletonList(topicPartition));
				consumer.seekToEnd(Collections.singletonList(topicPartition));
				
				logger.info(
						"HeartBeatCheck :: Topic: " + topicPartition.topic() + " Partition: " + topicPartition.partition() +
						" Msg in Queue: " + consumer.position(topicPartition) + " Msg Consumed: " + offsetAndMetadata.offset() + 
						" Current Queue depth: " + (consumer.position(topicPartition) - offsetAndMetadata.offset()));
				
				if ((consumer.position(topicPartition) - offsetAndMetadata.offset()) > maxQueueDepth) {
					return false;
				}
				
			}

		} catch (InterruptedException | ExecutionException e) {
			logger.error("Health Check Error : {}", e.getMessage());
			
			Thread.currentThread().interrupt();
			return true;
		}

		return true;
	}

}
