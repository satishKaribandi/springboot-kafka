package com.saka.kafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;

public class kafkaProcessor {
	
	@Autowired
	KafkaProducerService kafkaProducerService;

	//Using service

	//kafkaProducerService.send(String topicName, String id, Customer customer);

}
