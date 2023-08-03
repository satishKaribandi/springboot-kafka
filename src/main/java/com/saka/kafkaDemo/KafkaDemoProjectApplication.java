package com.saka.kafkaDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@SpringBootApplication
@EnableCassandraRepositories
@EnableAutoConfiguration
public class KafkaDemoProjectApplication {
	
	  @Autowired
	  KafkaProducerService kafkaproducer;
	  private final static Logger log = LoggerFactory.getLogger(KafkaDemoProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoProjectApplication.class, args);
		
		
	}
	
	 @Bean
	  public CommandLineRunner clr(PersonRepository personRepository) {
	    return args -> {
	    	personRepository.deleteAll();
	      
	      Person john = new Person(UUID.randomUUID(), "John", "Doe", new HashSet<>(Arrays.asList("surgery")));
	      Person jane = new Person(UUID.randomUUID(), "Jane", "Doe", new HashSet<>(Arrays.asList("radiology, surgery")));
	      
	      Person savedJohn = personRepository.save(john);
	      Person savedJane = personRepository.save(jane);

	      personRepository.findAll()
	        .forEach(v -> log.info("Vet: {}", v.getFirstName()));
	      
	      personRepository.findById(savedJohn.getId())
	        .ifPresent(v -> log.info("Vet by id: {}", v.getFirstName()));
	    };
	}
	/*@Override
	  public void run(String... args) throws Exception {

		kafkaproducer.send("customerDetails", "123", new Customer("123", "Satish", 50, Status.EMPLOYEE));
		kafkaproducer.send("customerDetails", "taskId", new Customer("124", "Deepthi", 50, Status.EMPLOYEE));
	  }*/

}
