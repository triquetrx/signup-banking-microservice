package com.cognizant.signup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.signup.model.SignupRequest;

@Repository
public interface SignupRequestRepository extends JpaRepository<SignupRequest, String> {

	List<SignupRequest> findByAccountCreated(boolean accountCreated);
	
}
