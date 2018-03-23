package com.globant.training.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.training.micro.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	public void testService() {
		System.out.println("+++++++++++++ test ++++++++++++++++++");
	}
	
}
