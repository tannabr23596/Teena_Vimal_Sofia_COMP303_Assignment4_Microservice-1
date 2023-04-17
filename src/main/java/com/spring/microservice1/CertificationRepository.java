package com.spring.microservice1;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends ReactiveMongoRepository<Certification, Integer>{

}
