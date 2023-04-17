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

public class CertificationService {

    @Autowired
    CertificationRepository certRepository;

    public Flux<Certification> getAll() {
        return certRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Certification> getById(final int id) {
        return certRepository.findById(id);
    }

    public Mono update(final int id, final Certification certification) {
        return certRepository.save(certification);
    }

    public Mono save(final Certification certification) {
        return certRepository.save(certification);  
    }

    public Mono delete(final int id) {
        final Mono<Certification> dbCertification = getById(id);

        if (Objects.isNull(dbCertification)) {
            return Mono.empty();
        }

    return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(certificationToBeDeleted -> certRepository
        .delete(certificationToBeDeleted).then(Mono.just(certificationToBeDeleted)));
    }

}