package com.spring.microservice1;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CentreRepository extends ReactiveMongoRepository<Center, Integer>{
	
}
