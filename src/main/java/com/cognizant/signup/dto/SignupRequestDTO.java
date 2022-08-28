package com.cognizant.signup.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public @Data @AllArgsConstructor @NoArgsConstructor class SignupRequestDTO {

	private String name;
	private String email;
	private Long phoneNumber;
	private Date dateOfBirth;
	private String address1;
	private String address2;
	private String panNumber;
	
}
