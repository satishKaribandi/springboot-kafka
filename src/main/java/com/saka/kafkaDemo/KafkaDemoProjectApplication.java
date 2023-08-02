package com.saka.kafkaDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.saka.kafkaDemo.Customer.Status;

@SpringBootApplication
public class KafkaDemoProjectApplication {
	
	  @Autowired
	  KafkaProducerService kafkaproducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoProjectApplication.class, args);
		
		
	}
	
	/*@Override
	  public void run(String... args) throws Exception {

		kafkaproducer.send("customerDetails", "123", new Customer("123", "Satish", 50, Status.EMPLOYEE));
		kafkaproducer.send("customerDetails", "taskId", new Customer("124", "Deepthi", 50, Status.EMPLOYEE));
	  }*/

}
