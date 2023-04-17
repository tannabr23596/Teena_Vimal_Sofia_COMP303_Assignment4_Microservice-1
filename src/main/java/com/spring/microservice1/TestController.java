package com.spring.microservice1;

import java.time.LocalDateTime;

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

@RequestMapping("test")
@AllArgsConstructor
@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	
	@GetMapping
	public Flux<Test>displayAll(){
		return testService.getAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Test> getById(@PathVariable("id")final int id){
		return testService.getById(id);
	}
	
	@PostMapping
	public Mono save(@RequestBody final Test test) {
		return testService.save(test);
	}
	
	@PutMapping("/{id}")
	public Mono updateByid(@PathVariable("id") final int id, @RequestBody final Test test) {
		test.setCenterCode(id);
		Mono<Test> existingTest = testService.getById(id);
		
		return testService.update(id, test);
	}
	
	@PostMapping("/booking/{candidateId}")
	public Mono bookCandidateTest(@PathVariable("candidateId") final int candidateId, @RequestBody final Test test) {
		test.setCandidateId(candidateId);
		checkTestDatesOverlap(candidateId,test.getDateAndTime());
		return testService.save(test);
	}
	
	@GetMapping("/history/{candidateId}")
	public Flux<Test> getHistoryById(@PathVariable("candidateId") final int candidateId){
		return testService.getAllByCandidate(candidateId);
	}
	
	public boolean checkTestDatesOverlap(int candidateId, String testDate) {

		Flux<Test> candidateTests = testService.getAllByCandidate(candidateId);

		// Check if any of the candidate's existing tests overlap with the new test date
		boolean overlap = candidateTests.filter(test -> !test.getDateAndTime().equals(testDate)) // Exclude the new test
																									// being booked
				.any(test -> {
					String start1 =test.getDateAndTime();
					String start2 =testDate;
					return start1.equals(start2);
				}).block();
		
		return overlap;
	}

}