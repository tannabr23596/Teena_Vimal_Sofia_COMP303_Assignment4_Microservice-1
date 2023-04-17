
package com.spring.microservice1;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor

public class TestService {

    @Autowired
    TestRepository testRepository;

    public Flux<Test> getAll() {
        return testRepository.findAll().switchIfEmpty(Flux.empty());
    }
    
    public Flux<Test> getAllByCandidate(final int id) {
        return testRepository.getTestsByCandidate(id).switchIfEmpty(Flux.empty());
    }

    public Mono<Test> getById(final int id) {
        return testRepository.findById(id);
    }

    public Mono update(final int id, final Test test) {
        return testRepository.save(test);
    }

    public Mono save(final Test test) {
        return testRepository.save(test);  
    }

    public Mono delete(final int id) {
        final Mono<Test> dbTest = getById(id);

        if (Objects.isNull(dbTest)) {
            return Mono.empty();
        }

    return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(testToBeDeleted -> testRepository
        .delete(testToBeDeleted).then(Mono.just(testToBeDeleted)));
    }

}
