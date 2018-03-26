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

import com.globant.training.micro.model.Employee;
import com.globant.training.micro.service.EmployeService;

@RestController
@RequestMapping("/employees")
public class EmployeeWS {

	private Logger logger = Logger.getLogger(EmployeeWS.class);
	
	@Autowired
	private EmployeService employeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List> getAll() {
		return null;	
	}
	
	@RequestMapping(value = "/{idEmployee}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable Long idEmployee) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Employee employee) {
		return null;
	}
	
}
