package com.jayasanka.kafka.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;

public class ConsumerRebalanceListner implements ConsumerAwareRebalanceListener {

	private Logger logger = LoggerFactory.getLogger(ConsumerRebalanceListner.class);

	private Map<TopicPartition, OffsetAndMetadata> currentOffset = new HashMap<>();

	@Override
	public void onPartitionsRevokedBeforeCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
		logger.info("ConsumerRebalanceListner :: onPartitionsRevokedBeforeCommit");

		logger.info("Partition Revoked..");
		for (TopicPartition topicPartition : partitions) {
			logger.info(topicPartition.topic() + "::" + topicPartition.partition());
		}

		logger.info("Partition Commited..");
		for (TopicPartition topicPartition : currentOffset.keySet()) {
			logger.info(topicPartition.topic() + "::" + topicPartition.partition());
		}

		consumer.commitSync(currentOffset);
		currentOffset.clear();
	}

	@Override
	public void onPartitionsAssigned(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
		logger.info("ConsumerRebalanceListner :: onPartitionsAssigned");

		logger.info("Partition Assigned..");
		for (TopicPartition topicPartition : partitions) {
			logger.info(topicPartition.topic() + "::" + topicPartition.partition());
		}
	}

	public void addOffset(String topic, int partion, long offset) {
		currentOffset.put(new TopicPartition(topic, partion), new OffsetAndMetadata(offset));
	}

	public Map<TopicPartition, OffsetAndMetadata> getCurrentOffsets() {
		return currentOffset;
	}

}
