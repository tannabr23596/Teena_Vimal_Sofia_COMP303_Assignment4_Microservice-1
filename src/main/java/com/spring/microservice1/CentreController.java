package com.spring.microservice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@RequestMapping("centre")
@AllArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CentreController {

	@Autowired
	private CentreService centreService;
	
	
	@GetMapping
	public Flux<Center>displayAll(){
		return centreService.getAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Center> getById(@PathVariable("id")final int id){
		return centreService.getById(id);
	}
	
	@PostMapping
	public Mono save(@RequestBody final Center candidate) {
		System.out.println("candidat:"+ candidate.toString());
		return centreService.save(candidate);
	}
	
	@PutMapping("/{id}")
	public Mono updateByid(@PathVariable("id") final int id, @RequestBody final Center center) {
		center.setCenterCode(id);
		return centreService.update(id, center);
	}
}
