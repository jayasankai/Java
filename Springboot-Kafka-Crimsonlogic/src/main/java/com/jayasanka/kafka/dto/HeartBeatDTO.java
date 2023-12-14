package com.jayasanka.kafka.dto;

import java.util.HashMap;
import java.util.Map;

public class HeartBeatDTO {
	private static HeartBeatDTO instance = null;
	private Map<String, Boolean> consumerFlag;

	private HeartBeatDTO() {
		consumerFlag = new HashMap<>();
	}

	public void setConsumerFlag(Map<String, Boolean> consumerFlag) {
		this.consumerFlag = consumerFlag;
	}

	public Map<String, Boolean> getConsumerFlag() {
		return consumerFlag;
	}

	public static HeartBeatDTO getInstance() {
		if (instance == null) {
			instance = new HeartBeatDTO();
		}

		return instance;
	}
}
