package com.app.response;

import com.app.entity.AddressResponse;

import lombok.Data;

@Data
public class StudentResponse {
	
	private Integer studId;
	
	private String studName;
	
	private String emailId;
	
	private String gender;
	
	private String bloodGrp;
	
	private AddressResponse addressResponse;

}
