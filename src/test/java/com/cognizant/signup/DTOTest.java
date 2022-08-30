package com.cognizant.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.signup.dto.SignupRequestDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DTOTest {

	SignupRequestDTO requestDTO;
	
	@Test
	void testRequestDTO() {
		requestDTO = new SignupRequestDTO("test", "test@test.com", (long) 1234567890, new Date(), "address1", "address2", "AHK001PKL0");
		assertEquals("test", requestDTO.getName());
		assertEquals("test@test.com", requestDTO.getEmail());
		assertEquals(1234567890, requestDTO.getPhoneNumber());
		assertEquals("address1", requestDTO.getAddress1());
		assertEquals("address2", requestDTO.getAddress2());
		assertEquals("AHK001PKL0", requestDTO.getPanNumber());
	}
	
}
