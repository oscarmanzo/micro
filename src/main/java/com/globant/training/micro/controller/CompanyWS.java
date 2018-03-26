package com.globant.training.micro.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.training.micro.model.Company;
import com.globant.training.micro.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyWS {

	private Logger logger = Logger.getLogger(CompanyWS.class);
	
	@Autowired
	private CompanyService companyService;

	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> getAll() {
		return null;
	}
	
	@RequestMapping(value = "/{idCompany}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> getCompany(@PathVariable Long idCompany) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Company company) {
		return null;
	}
	
}
