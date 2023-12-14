package com.jayasanka.kafka.basic;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaProducerWithSameKeysApp {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaProducerWithSameKeysApp.class);

	public static void main(String[] args) {
		log.info("Kafka Producer");
		
		// Create producer properties
		String bootstrapServers = "127.0.0.1:9092";
		
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		// properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "400");
		// properties.setProperty(ProducerConfig.PARTITIONER_CLASS_CONFIG, RoundRobinPartitioner.class.getName());
		
		// Create the producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		for (int i = 0; i < 10; i++) {
			String topic = "my_first_topic";
			final String key = "key_id" + i;			
			
			for (int j = 0; j < 30; j++) {
				String value = "Value " + i + "" + j;
				
				// Producer topic
				ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, key, value);
				
				// Send data
				producer.send(producerRecord, new Callback() {
					
					public void onCompletion(RecordMetadata metadata, Exception exception) {
						if (exception == null) {
							log.info("Received new metadata " + 
									"Topic: " + metadata.topic() + " | " +
									"Partition: " + metadata.partition() + " | " +
									"Key: " + key + " | " +
									"Offcet: " + metadata.offset() + " | " +
									"TimeStamp: " + metadata.timestamp() + " | ");
						} else {
							log.error("Exception while produsing...", exception);
						}
						
					}
				});
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Flush and close the producer -- Sysnc operation
		producer.flush();
		producer.close();

	}

}
