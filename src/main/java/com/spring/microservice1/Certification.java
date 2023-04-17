package com.spring.microservice1;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Document
@Component
public class Certification {
	
	@Id
	private int examCode;
	private String certificationName;
	private String format;
	private int duration;
	private int noOfQuestions;
	private double passingScore;
	private double fee;
	
	public Certification() {
		
	}

	public int getExamCode() {
		return examCode;
	}

	public void setExamCode(int examCode) {
		this.examCode = examCode;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public double getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(double passingScore) {
		this.passingScore = passingScore;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	
	

}
