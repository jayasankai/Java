package com.jayasanka.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangeHandler implements EventHandler {
	private final Logger logger = LoggerFactory.getLogger(WikimediaChangeHandler.class);
	
	KafkaProducer<String, String> producer;
	String topic;
	
	public WikimediaChangeHandler(KafkaProducer<String, String> producer, String topic) {
		this.producer = producer;
		this.topic = topic;
	}

	public void onOpen() {
		// Do nothing

	}

	public void onClosed() {
		producer.close();
	}

	public void onMessage(String event, MessageEvent messageEvent) {
		logger.info(messageEvent.getData());
		
		producer.send(new ProducerRecord<String, String>(this.topic, messageEvent.getData()));

	}

	public void onComment(String comment) {
		// TODO Auto-generated method stub

	}

	public void onError(Throwable t) {
		logger.error("Error in streaming.. ", t);

	}

}
