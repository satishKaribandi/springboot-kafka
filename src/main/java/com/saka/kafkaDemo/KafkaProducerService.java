package com.saka.kafkaDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class KafkaProducerService {

  private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

  @Autowired
  KafkaTemplate<String, Customer> kafkaTemplate;

  public void send(String topicName, String key, Customer value) {

    var future = kafkaTemplate.send(topicName, key, value);

    future.whenComplete((sendResult, exception) -> {
      if (exception != null) {
        future.completeExceptionally(exception);
      } else {
        future.complete(sendResult);
      }
      LOGGER.info("Task status send to Kafka topic : "+ value);
    });
  }
}