package com.globant.training.micro.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<List<Company>> getAll() {

		List<Company> companies = companyService.findAllCompanies();

		ResponseEntity<List<Company>> response = new ResponseEntity<List<Company>>(companies, HttpStatus.OK);

		return response;
	}
	
	@RequestMapping(value = "/{idCompany}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Company> getCompany(@PathVariable Long idCompany) {

		if (idCompany==null) return ResponseEntity.noContent().build();
				
		Company company = companyService.findCompany(idCompany);

		ResponseEntity<Company> response = company!=null? new ResponseEntity<Company>(company, HttpStatus.OK) : ResponseEntity.noContent().build();
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Company company) {
		ResponseEntity<Long> response = null;
		Long idCompany = null;
		
		try {
			idCompany = companyService.createCompany(company);	
		}catch(Exception e) {
			logger.error(e);
		}
		
		response = idCompany!=null? new ResponseEntity<Long>(idCompany, HttpStatus.OK) : ResponseEntity.noContent().build(); 
		
		return response;
	}
	
}
