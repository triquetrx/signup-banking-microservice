package com.cognizant.signup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.signup.dto.SignupRequestDTO;
import com.cognizant.signup.model.SignupRequest;
import com.cognizant.signup.model.SignupResponse;

@Service
public interface SignupService {

	SignupResponse addnewRequest(SignupRequestDTO requestDTO);

	List<SignupRequest> viewAllList(String token);

}
