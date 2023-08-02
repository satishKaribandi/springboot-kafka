package com.saka.kafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saka.kafkaDemo.Customer.Status;

@RestController
public class LandingPage {
	
	@Autowired
	 KafkaProducerService kafkaproducer;
	
	@GetMapping("/postmessage")
	public void putmessage() {
		kafkaproducer.send("customerDetails", "123", new Customer("123", "Satish", 50, Status.EMPLOYEE));
		kafkaproducer.send("customerDetails", "taskId", new Customer("124", "Deepthi", 50, Status.EMPLOYEE));
		
	}

}
