package com.jayasanka.kafka.advance;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerDemoThreads {

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			ConsumerDemoWorker consumerDemoWorker = new ConsumerDemoWorker();
			new Thread(consumerDemoWorker).start();
			Runtime.getRuntime().addShutdownHook(new Thread(new ConsumerDemoCloser(consumerDemoWorker)));			
		}
    }
	
	private static class ConsumerDemoWorker implements Runnable {

        private static final Logger log = LoggerFactory.getLogger(ConsumerDemoWorker.class);

        private CountDownLatch countDownLatch;
        private Consumer<String, String> consumer;

        public void run() {
            countDownLatch = new CountDownLatch(1);
            final Properties properties = new Properties();
            
    		// Create producer properties
    		String bootstrapServers = "127.0.0.1:9092";
    		String groupId = "my_consumer_group";
    		String topicId = "my_first_topic";

            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
            properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

            consumer = new KafkaConsumer<String, String>(properties);
            consumer.subscribe(Collections.singleton(topicId));

            final Duration pollTimeout = Duration.ofMillis(100);

            try {
                while (true) {
                    final ConsumerRecords<String, String> consumerRecords = consumer.poll(pollTimeout);
                    for (final ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    	log.info("Getting consumer record Key: {}, Value: {}, Partition: {}, Offset at : {} ", 
                    			consumerRecord.key(), consumerRecord.value(), consumerRecord.partition(), new Date(consumerRecord.timestamp()));
                    }
                }
            } catch (WakeupException e) {
                log.info("Consumer poll woke up");
            } finally {
                consumer.close();
                countDownLatch.countDown();
            }
        }

        void shutdown() throws InterruptedException {
            consumer.wakeup();
            countDownLatch.await();
            log.info("Consumer closed");
        }

    }

    private static class ConsumerDemoCloser implements Runnable {

        private static final Logger log = LoggerFactory.getLogger(ConsumerDemoCloser.class);

        private final ConsumerDemoWorker consumerDemoWorker;

        ConsumerDemoCloser(final ConsumerDemoWorker consumerDemoWorker) {
            this.consumerDemoWorker = consumerDemoWorker;
        }

        public void run() {
            try {
                consumerDemoWorker.shutdown();
            } catch (InterruptedException e) {
                log.error("Error shutting down consumer", e);
            }
        }
    }

}
