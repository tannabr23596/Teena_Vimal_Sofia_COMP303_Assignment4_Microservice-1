package com.spring.microservice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("candidate")
@AllArgsConstructor
@RestController
public class CandidateController {
	
	@Autowired
	private CandidateService candService;
	
	
	@GetMapping
	public Flux<Candidate>displayAll(){
		return candService.getAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Candidate> getById(@PathVariable("id")final int id){
		return candService.getById(id);
	}
	
	@PostMapping
	public Mono save(@RequestBody final Candidate candidate) {
		return candService.save(candidate);
	}
	
	@PutMapping("/{id}")
	public Mono updateByid(@PathVariable("id") final int id, @RequestBody final Candidate candidate) {
		candidate.setCandidateId(id);
		return candService.update(id, candidate);
	}

}