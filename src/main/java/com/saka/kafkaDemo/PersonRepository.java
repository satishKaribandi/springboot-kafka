package com.saka.kafkaDemo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, UUID> {
	Person findByFirstName(String username);
}
