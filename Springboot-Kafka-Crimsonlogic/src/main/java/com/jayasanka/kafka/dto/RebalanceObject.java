package com.jayasanka.kafka.dto;

import com.jayasanka.kafka.util.ConsumerRebalanceListner;

public class RebalanceObject {

	private static ConsumerRebalanceListner instance;

	private RebalanceObject() {
	}

	public static ConsumerRebalanceListner getInstance() {
		if (null == instance) {
			instance = new ConsumerRebalanceListner();
		}
		return instance;
	}
}
