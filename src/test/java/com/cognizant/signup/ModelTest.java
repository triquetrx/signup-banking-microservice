package com.cognizant.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.signup.model.SignupRequest;
import com.cognizant.signup.model.SignupResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ModelTest {
	
	SignupRequest request;
	SignupResponse response;
	
	@Test
	void testRequest() {
		request = new SignupRequest("REQ0", "test", "test@test.com", (long) 1234567890, new Date(), "address1", "address2", "AHK001PKL0", false);
		assertEquals("REQ0", request.getRequestId());
		assertEquals("test", request.getName());
		assertEquals("test@test.com", request.getEmail());
		assertEquals(1234567890, request.getPhoneNumber());
		assertEquals("address1", request.getAddress1());
		assertEquals("address2", request.getAddress2());
		assertEquals("AHK001PKL0", request.getPanNumber());
	}
	
	@Test
	void testResponse() {
		response = new SignupResponse("REQ", "SUCCESSFULL");
		assertEquals("REQ", response.getRequestId());
		assertEquals("SUCCESSFULL", response.getMessage());
	}

}
