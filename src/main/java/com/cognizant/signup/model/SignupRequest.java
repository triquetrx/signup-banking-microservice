package com.cognizant.signup.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public @Data @AllArgsConstructor @NoArgsConstructor class SignupRequest {
	
	@Id
	private String requestId;
	private String name;
	private String email;
	private Long phoneNumber;
	private Date dateOfBirth;
	private String address1;
	private String address2;
	private String panNumber;
	private boolean accountCreated;

}
