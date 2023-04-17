package com.spring.microservice1;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Test {

	@Id
	private int testId;
	private int centerCode;
	private int candidateId;
	private int examCode;
	private String dateAndTime;
	private double score;
	private String status;
	private String result;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(int centerCode) {
		this.centerCode = centerCode;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getExamCode() {
		return examCode;
	}

	public void setExamCode(int examCode) {
		this.examCode = examCode;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
