package com.saka.kafkaDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class KafKaTopicListeners {

  private final Logger logger = LoggerFactory.getLogger(KafKaTopicListeners.class);

  @KafkaListener(topics = {"customerDetails"}, groupId = "task-group")
  public void consume(Customer customer) {

    logger.info(String.format("Task status is updated : " + customer));
  }
}