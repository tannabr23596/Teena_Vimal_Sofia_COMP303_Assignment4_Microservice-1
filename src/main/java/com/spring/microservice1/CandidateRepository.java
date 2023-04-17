package com.spring.microservice1;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CandidateRepository extends ReactiveMongoRepository<Candidate, Integer>{
	

}