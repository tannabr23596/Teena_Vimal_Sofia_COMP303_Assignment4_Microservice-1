package com.spring.microservice1;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CentreService {
	@Autowired
	CentreRepository centreRepository;

    public Flux<Center> getAll() {
        return centreRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Center> getById(final int id) {
        return centreRepository.findById(id);
    }

    public Mono update(final int id, final Center center) {
        return centreRepository.save(center);
    }

    public Mono save(final Center center) {
        return centreRepository.save(center);  
    }

    public Mono delete(final int id) {
        final Mono<Center> dbCenter = getById(id);

        if (Objects.isNull(dbCenter)) {
            return Mono.empty();
        }

    return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(centerToBeDeleted -> centreRepository
        .delete(centerToBeDeleted).then(Mono.just(centerToBeDeleted)));
    }

}
