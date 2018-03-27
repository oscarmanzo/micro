package com.globant.training.micro.controller;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ClientWSProxy {

	@HystrixCommand(fallbackMethod = "dummyResponse")
	public boolean verifiedEmployee(Long idEmployee, Long idCompany) {
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8080/employees/"+ idEmployee.longValue() +"/isemployee/"+ idCompany.longValue());

	    Boolean isEmployee = restTemplate.getForObject(uri, Boolean.class);
	    return isEmployee;
	}

	public boolean dummyResponse() {
		return false;
	}
	
}
