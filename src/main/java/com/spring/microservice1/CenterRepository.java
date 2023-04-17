package com.spring.microservice1;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends ReactiveMongoRepository<Center, Integer>{

}
