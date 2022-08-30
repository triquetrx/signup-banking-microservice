package com.cognizant.signup;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.signup.controller.SignupController;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllerTest {
	
	SignupController controller = new SignupController();
	
	@Test
	void testSignupController() {
		assertThat(controller).isNotNull();
	}

}
