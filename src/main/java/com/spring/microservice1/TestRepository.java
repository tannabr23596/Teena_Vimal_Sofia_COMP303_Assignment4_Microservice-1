package com.spring.microservice1;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface TestRepository extends ReactiveMongoRepository<Test, Integer>{
	
	@Query("{candidateId : ?0}") 
    Flux<Test> getTestsByCandidate(int candidateId);

}