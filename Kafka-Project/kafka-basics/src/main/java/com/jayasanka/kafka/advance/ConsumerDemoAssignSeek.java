package com.jayasanka.kafka.advance;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemoAssignSeek {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(ConsumerDemoAssignSeek.class.getName());

		String bootstrapServers = "127.0.0.1:9092";
		String groupId = "my_consumer_group";
		String topicId = "my_first_topic";

        // create consumer configs
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        // create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        // assign and seek are mostly used to replay data or fetch a specific message

        // assign
        TopicPartition partitionToReadFrom = new TopicPartition(topicId, 0);
        long offsetToReadFrom = 7L;
        consumer.assign(Arrays.asList(partitionToReadFrom));

        // seek
        consumer.seek(partitionToReadFrom, offsetToReadFrom);

        int numberOfMessagesToRead = 15;
        boolean keepOnReading = true;
        int numberOfMessagesReadSoFar = 0;

        try {
        	// poll for new data
        	while(keepOnReading){
        		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        		
        		for (ConsumerRecord<String, String> record : records){
        			numberOfMessagesReadSoFar += 1;
        			log.info("Key: {}, Value: {}, Partition: {}, Offset: {} ", record.key(), record.value(), record.partition(), record.offset());
        			
        			if (numberOfMessagesReadSoFar >= numberOfMessagesToRead){
        				keepOnReading = false; // to exit the while loop
        				break; // to exit the for loop
        			}
        		}
        	}
        } finally {
        	consumer.close();
        }

        log.info("Exiting the application");

	}

}
