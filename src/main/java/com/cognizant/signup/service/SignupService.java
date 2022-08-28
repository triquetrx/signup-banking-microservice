package com.cognizant.signup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.signup.clients.AuthClient;
import com.cognizant.signup.clients.CustomerClient;
import com.cognizant.signup.dto.SignupRequestDTO;
import com.cognizant.signup.model.SignupRequest;
import com.cognizant.signup.model.SignupResponse;
import com.cognizant.signup.repository.SignupRequestRepository;

@Service
public class SignupService {

	@Autowired
	private SignupRequestRepository repository;
	@Autowired
	private AuthClient authClient;
	@Autowired
	private CustomerClient customerClient;

	public SignupResponse addnewRequest(SignupRequestDTO requestDTO) {
		String id = "REQ_" + repository.count();
		repository.save(new SignupRequest(id, requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPhoneNumber(),
				requestDTO.getDateOfBirth(),requestDTO.getAddress1(), requestDTO.getAddress2(), requestDTO.getPanNumber(), false));
		return new SignupResponse(id, "REQUEST_CREATED_SUCCESSFULLY");
	}

	public List<SignupRequest> viewAllList(String token) {
		if (authClient.validatingToken(token).isValidStatus()
				&& authClient.validatingToken(token).getUserRole().equalsIgnoreCase("ROLE_EMPLOYEE")) {
			List<SignupRequest> requests = repository.findAll();
			List<SignupRequest> results = new ArrayList<>();
			for (SignupRequest request : requests) {
				if (customerClient.isAccountPresent(token, request.getPanNumber())) {
					request.setAccountCreated(true);
					repository.save(request);
				} else {
					results.add(request);
				}
			}
			return results;
		}
		return null;
	}

}
