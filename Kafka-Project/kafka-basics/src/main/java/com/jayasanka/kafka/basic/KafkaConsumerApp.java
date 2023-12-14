package com.jayasanka.kafka.basic;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaConsumerApp {
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumerApp.class);

	public static void main(String[] args) {
		log.info("Kafka Consumer");
		
		// Create producer properties
		String bootstrapServers = "127.0.0.1:9092";
		String groupId = "my_consumer_group";
		String topicId = "my_first_topic";
		
		// Consumer properties
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		// Create Consumer 
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		
		// Subscribe to the topic
		consumer.subscribe(Arrays.asList(topicId));
		
		try {
			// Pull for data
			while (true) {
				// log.info("Consumer is polling...");
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
				
				for (ConsumerRecord<String, String> record : records) {
					log.info("Key: {}, Value: {}, Partition: {}, Offset: {} ", record.key(), record.value(), record.partition(), record.offset());
				}
			}
		} finally {
			consumer.close();
		}

	}

}
