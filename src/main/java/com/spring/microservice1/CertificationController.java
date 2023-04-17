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

@RequestMapping("certification")
@AllArgsConstructor
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class CertificationController {

	@Autowired
	private CertificationService certificationService;
	
	
	@GetMapping
	public Flux<Certification>displayAll(){
		return certificationService.getAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Certification> getById(@PathVariable("id")final int id){
		return certificationService.getById(id);
	}
	
	@PostMapping
	public Mono save(@RequestBody final Certification cert) {
		System.out.println("certification:"+ cert.toString());
		return certificationService.save(cert);
	}
	
	@PutMapping("/{id}")
	public Mono updateByid(@PathVariable("id") final int id, @RequestBody final Certification certification) {
		certification.setExamCode(id);
		return certificationService.update(id, certification);
	}
}
