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
public class Center {
	
	@Id
	private int centerCode;
	private String centerName;
	private String address;
	private long phone;
	private String website;
	
	public Center() {
		
	}

	public Center(int centerCode, String centerName, String address, long phone, String website) {
		
		this.centerCode = centerCode;
		this.centerName = centerName;
		this.address = address;
		this.phone = phone;
		this.website = website;
	}

	public int getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(int centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
		

}
