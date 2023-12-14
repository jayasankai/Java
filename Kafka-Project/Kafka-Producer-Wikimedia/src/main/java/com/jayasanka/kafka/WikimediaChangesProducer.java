package com.jayasanka.kafka;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;

public class WikimediaChangesProducer {
	public static void main(String[] args) throws InterruptedException {
		String bootstrapServers = "127.0.0.1:9092";
		String topicName = "wikimedia.recentchanges";
		
		Properties properties = new Properties();
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		// Safe producer config
		/**

		properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, Boolean.TRUE.toString());
		properties.setProperty(ProducerConfig.ACKS_CONFIG, "all"); // same as -1
		properties.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));
		
		*/
		
		// High throughput producer config
		properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20");
		properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32 * 1024));
		properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
		
		// If the load is high
		properties.setProperty(ProducerConfig.MAX_BLOCK_MS_CONFIG, "120000");
		properties.setProperty(ProducerConfig.BUFFER_MEMORY_CONFIG, Integer.toString(64 * 1024 * 1024));
		
		
		// Create the producer for kafka <= 2.8
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		// Even handler
		EventHandler eventHandler = new WikimediaChangeHandler(producer, topicName);
		
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource = builder.build();
		
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
	}
}
