package com.jayasanka.kafka.basic;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaProducerApp {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerApp.class);

	public static void main(String[] args) {
		log.info("Kafka Producer");
		
		// Create producer properties
		String bootstrapServers = "127.0.0.1:9092";
		
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		// Create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		// Producer topic
		ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("my_first_topic", "Key2", "Value2");
		
		// Send data
		producer.send(producerRecord);
		
		// Flush and close the producer -- Sysnc operation
		producer.flush();
		producer.close();

	}

}
