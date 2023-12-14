package com.jayasanka.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.jayasanka.kafka.dto.HeartBeatDTO;
import com.jayasanka.kafka.dto.ProducerDTO;
import com.jayasanka.kafka.dto.PublishDTO;
import com.jayasanka.kafka.dto.ResponseDTO;

@Service
public class KafkaProducerService {

	private Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

	@Value(value = "${kafka.producer.retry.flag:N}")
	private String retryFlag;

	@Value(value = "${kafka.producer.retry.file.path:/Users/jayasanka/projects/Springboot-Kafka-Crimsonlogic/files/failed}")
	private String retryFilePath;

	@Autowired
	KafkaTemplate<String, String> stringKafkaTemplate;
	
	@Autowired
	KafkaTemplate<String, PublishDTO> jsonKafkaTemplate;
	
	@Autowired
	KafkaTemplate<String, byte[]> byteKafkaTemplate;

	public ResponseDTO sendToTopic(ProducerDTO<String> producerDto) {
		ResponseDTO response = new ResponseDTO();
		
		try {
			if (validateProducerDetails(producerDto, response)) {
				return response;
			}
			
			if (HeartBeatDTO.getInstance().getConsumerFlag().isEmpty() || 
					(!HeartBeatDTO.getInstance().getConsumerFlag().isEmpty() && HeartBeatDTO.getInstance().getConsumerFlag().get(producerDto.getConsumerGroupId()))) {
				
				if ("STRING".equalsIgnoreCase(producerDto.getType())) {
					CompletableFuture<SendResult<String, String>> futureData = stringKafkaTemplate.send(producerDto.getTopicName(), producerDto.getData());
					futureData.whenComplete((result, ex) -> {
						if (ex == null) {
							logger.info("sendToTopic [STRING] :: Message Sucessfully publised to Topic. " + 
									"[Offset]" + result.getRecordMetadata().offset() +
									"[Partition]" + result.getRecordMetadata().partition() +
									"[Message]" + result.getProducerRecord().value());
						} else {
							logger.error("sendToTopic :: Failed to send to topic." + ex.getMessage());
							response.setStatus("FAILED");
							response.setMessage("sendToTopic :: Failed to send to topic." + producerDto.getTopicName());
						}
					});
					
				} else if ("JSON".equalsIgnoreCase(producerDto.getType())) {
					CompletableFuture<SendResult<String, String>> futureData = stringKafkaTemplate.send(producerDto.getTopicName(), producerDto.getData());
					futureData.whenComplete((result, ex) -> {
						if (ex == null) {
							logger.info("sendToTopic [JSON] :: Message Sucessfully publised to Topic. " + 
									"[Offset]" + result.getRecordMetadata().offset() +
									"[Partition]" + result.getRecordMetadata().partition() +
									"[Message]" + result.getProducerRecord().value());
						} else {
							logger.error("sendToTopic :: Failed to send to topic." + ex.getMessage());
							response.setStatus("FAILED");
							response.setMessage("sendToTopic :: Failed to send to topic." + producerDto.getTopicName());
						}
					});
					
				} else if ("BYTE".equalsIgnoreCase(producerDto.getType())) {
					CompletableFuture<SendResult<String, String>> futureData = stringKafkaTemplate.send(producerDto.getTopicName(), producerDto.getData());
					futureData.whenComplete((result, ex) -> {
						if (ex == null) {
							logger.info("sendToTopic [BYTE] :: Message Sucessfully publised to Topic. " + 
									"[Offset]" + result.getRecordMetadata().offset() +
									"[Partition]" + result.getRecordMetadata().partition() +
									"[Message]" + result.getProducerRecord().value());
						} else {
							logger.error("sendToTopic :: Failed to send to topic." + ex.getMessage());
							response.setStatus("FAILED");
							response.setMessage("sendToTopic :: Failed to send to topic." + producerDto.getTopicName());
						}
					});
					
				}
				
			}
			
			response.setStatus("SUCCESS");
			response.setMessage("sendToTopic :: Message publishing to Topic." + producerDto.getTopicName());
			
		} catch (Exception e) {
			logger.error("sendToTopic :: Failed to send to topic." + e.getMessage());
		}
		
		return response;
	}
	
	
	public ResponseDTO sendToTopicWithKey(ProducerDTO<String> producerDto) {
		ResponseDTO response = new ResponseDTO();
		
		try {
			if (validateProducerDetails(producerDto, response)) {
				return response;
			}
			
			if (HeartBeatDTO.getInstance().getConsumerFlag().isEmpty() || 
					(!HeartBeatDTO.getInstance().getConsumerFlag().isEmpty() && HeartBeatDTO.getInstance().getConsumerFlag().get(producerDto.getConsumerGroupId()))) {
				
				if ("STRING".equalsIgnoreCase(producerDto.getType())) {
					CompletableFuture<SendResult<String, String>> futureData = stringKafkaTemplate.send(producerDto.getTopicName(), producerDto.getKey(), producerDto.getData());
					futureData.whenComplete((result, ex) -> {
						if (ex == null) {
							logger.info("sendToTopic [STRING] :: Message Sucessfully publised to Topic. " + 
									"[Offset]" + result.getRecordMetadata().offset() +
									"[Partition]" + result.getRecordMetadata().partition() +
									"[Message]" + result.getProducerRecord().value());
						} else {
							logger.error("sendToTopic :: Failed to send to topic." + ex.getMessage());
							response.setStatus("FAILED");
							response.setMessage("sendToTopic :: Failed to send to topic." + producerDto.getTopicName());
						}
					});
					
				} else if ("JSON".equalsIgnoreCase(producerDto.getType())) {
					CompletableFuture<SendResult<String, String>> futureData = stringKafkaTemplate.send(producerDto.getTopicName(), producerDto.getKey(), producerDto.getData());
					futureData.whenComplete((result, ex) -> {
						if (ex == null) {
							logger.info("sendToTopic [JSON] :: Message Sucessfully publised to Topic. " + 
									"[Offset]" + result.getRecordMetadata().offset() +
									"[Partition]" + result.getRecordMetadata().partition() +
									"[Message]" + result.getProducerRecord().value());
						} else {
							logger.error("sendToTopic :: Failed to send to topic." + ex.getMessage());
							response.setStatus("FAILED");
							response.setMessage("sendToTopic :: Failed to send to topic." + producerDto.getTopicName());
						}
					});
					
				} else if ("BYTE".equalsIgnoreCase(producerDto.getType())) {
					CompletableFuture<SendResult<String, String>> futureData = stringKafkaTemplate.send(producerDto.getTopicName(), producerDto.getKey(), producerDto.getData());
					futureData.whenComplete((result, ex) -> {
						if (ex == null) {
							logger.info("sendToTopic [BYTE] :: Message Sucessfully publised to Topic. " + 
									"[Offset]" + result.getRecordMetadata().offset() +
									"[Partition]" + result.getRecordMetadata().partition() +
									"[Message]" + result.getProducerRecord().value());
						} else {
							logger.error("sendToTopic :: Failed to send to topic." + ex.getMessage());
							response.setStatus("FAILED");
							response.setMessage("sendToTopic :: Failed to send to topic." + producerDto.getTopicName());
						}
					});
					
				}
				
			}
			
			response.setStatus("SUCCESS");
			response.setMessage("sendToTopic :: Message publishing to Topic." + producerDto.getTopicName());
			
		} catch (Exception e) {
			logger.error("sendToTopic :: Failed to send to topic." + e.getMessage());
		}
		
		return response;
	}


	public boolean validateProducerDetails(ProducerDTO<String> producerDto, ResponseDTO response) {
		if (!(null != producerDto && null != producerDto.getTopicName() && null != producerDto.getType()
				&& null != producerDto.getConsumerGroupId())) {
			response.setStatus("FAILED");
			response.setMessage("Producer details incorrect!");
			return true;
		}

		return false;
	}

}
