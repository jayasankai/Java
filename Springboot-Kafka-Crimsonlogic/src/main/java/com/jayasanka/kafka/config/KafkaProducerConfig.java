package com.jayasanka.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;
import com.jayasanka.kafka.dto.PublishDTO;

@Configuration
public class KafkaProducerConfig {

	private Logger logger = LoggerFactory.getLogger(KafkaProducerConfig.class);
	
	@Value(value = "${kafka.brockers:localhost:9092}")
	private String bootstrapConfig;
	
	@Value(value = "${kafka.producer.compression.config:gzip}")
	private String compressionTypeConfig;
	
	@Value(value = "${kafka.producer.acks.config:all}")
	private String acksConfig;
	
	@Value(value = "${kafka.producer.linger.ms.config:100}")
	private String lingerMsConfig;
	
	@Value(value = "${kafka.producer.batch.size.config:32768}")
	private String batchSizeConfig;
	
	@Value(value = "${kafka.producer.enable.idempotence:true}")
	private String enableIdempotence;
	
	@Bean
	public ProducerFactory<String, PublishDTO> jsonProducerFactory() {
		logger.info("Producer JSON :: ");
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		producerConfig.put(ProducerConfig.ACKS_CONFIG, acksConfig);
		producerConfig.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, compressionTypeConfig);
		producerConfig.put(ProducerConfig.LINGER_MS_CONFIG, lingerMsConfig);
		producerConfig.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSizeConfig);
		producerConfig.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, enableIdempotence);
		
		return new DefaultKafkaProducerFactory<>(producerConfig);
		
	}
	
	@Bean
	public KafkaTemplate<String, PublishDTO> jsonKafkaTemplate() {
		return new KafkaTemplate<>(jsonProducerFactory());
	}
	
	@Bean
	public ProducerFactory<String, String> stringProducerFactory() {
		logger.info("Producer STRING :: ");
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		producerConfig.put(ProducerConfig.ACKS_CONFIG, acksConfig);
		producerConfig.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, compressionTypeConfig);
		producerConfig.put(ProducerConfig.LINGER_MS_CONFIG, lingerMsConfig);
		producerConfig.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSizeConfig);
		producerConfig.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, enableIdempotence);
		
		return new DefaultKafkaProducerFactory<>(producerConfig);
		
	}
	
	@Bean
	public KafkaTemplate<String, String> stringKafkaTemplate() {
		return new KafkaTemplate<>(stringProducerFactory());
	}
	
	@Bean
	public ProducerFactory<String, byte[]> byteProducerFactory() {
		logger.info("Producer BYTE :: ");
		Map<String, Object> producerConfig = new HashMap<>();
		producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapConfig);
		producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
		
		producerConfig.put(ProducerConfig.ACKS_CONFIG, acksConfig);
		producerConfig.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, compressionTypeConfig);
		producerConfig.put(ProducerConfig.LINGER_MS_CONFIG, lingerMsConfig);
		producerConfig.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSizeConfig);
		producerConfig.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, enableIdempotence);
		
		return new DefaultKafkaProducerFactory<>(producerConfig);
		
	}
	
	@Bean
	public KafkaTemplate<String, byte[]> byteKafkaTemplate() {
		return new KafkaTemplate<>(byteProducerFactory());
	}
	
}
