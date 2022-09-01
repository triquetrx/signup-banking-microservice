package com.cognizant.signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.signup.dto.SignupRequestDTO;
import com.cognizant.signup.model.SignupRequest;
import com.cognizant.signup.model.SignupResponse;
import com.cognizant.signup.service.SignupService;

@RestController
public class SignupController {
	
	@Autowired
	private SignupService service;
	
	@CrossOrigin(origins ="http://localhost:5000")
	@PostMapping("/signup-request")
	public ResponseEntity<?> signupRequest(@RequestBody SignupRequestDTO dto) {
		SignupResponse addnewRequest = service.addnewRequest(dto);
		return new ResponseEntity<>(addnewRequest,HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:5000")
	@GetMapping("/view-all-requests")
	public ResponseEntity<?> signupRequest(@RequestHeader(name="Authorization")String token) {
		List<SignupRequest> list = service.viewAllList(token);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:5000")
	@GetMapping("/track-request/{requestId}/{name}")
	public ResponseEntity<?> trackRequest(@PathVariable String requestId, @PathVariable String name){
		try {
			return new ResponseEntity<>(service.trackRequestStatus(requestId, name),HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
