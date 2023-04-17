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

public class CandidateService {

    @Autowired
    CandidateRepository candRepository;

    public Flux<Candidate> getAll() {
        return candRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Candidate> getById(final int id) {
        return candRepository.findById(id);
    }

    public Mono update(final int id, final Candidate candidate) {
        return candRepository.save(candidate);
    }

    public Mono save(final Candidate candidate) {
        return candRepository.save(candidate);  
    }

    public Mono delete(final int id) {
        final Mono<Candidate> dbCandidate = getById(id);

        if (Objects.isNull(dbCandidate)) {
            return Mono.empty();
        }

    return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(candidateToBeDeleted -> candRepository
        .delete(candidateToBeDeleted).then(Mono.just(candidateToBeDeleted)));
    }

}