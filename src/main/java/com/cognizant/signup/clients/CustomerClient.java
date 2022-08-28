package com.cognizant.signup.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="customer-microservice",url="http://localhost:8002")
public interface CustomerClient {
	
	@GetMapping("is-account-present/{panNumber}")
	public boolean isAccountPresent(@RequestHeader(name="Authorization")String token,@PathVariable String panNumber);

}
