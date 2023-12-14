package com.jayasanka.kafka.dto;

import java.io.Serializable;

public class ProducerDTO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String topicName;
	private String type;
	private String consumerGroupId;
	private T data;
	private int retryCount;
	private String key;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConsumerGroupId() {
		return consumerGroupId;
	}

	public void setConsumerGroupId(String consumerGroupId) {
		this.consumerGroupId = consumerGroupId;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "ProducerDTO [topicName=" + topicName + ", type=" + type + ", consumerGroupId=" + consumerGroupId
				+ ", data=" + data + ", retryCount=" + retryCount + ", key=" + key + "]";
	}
	

}
