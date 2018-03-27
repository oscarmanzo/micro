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

import com.globant.training.micro.model.Employee;
import com.globant.training.micro.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeWS {

	private Logger logger = Logger.getLogger(EmployeeWS.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employees = employeeService.findAllEmployees();

		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/{idEmployee}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable Long idEmployee) {
		if (idEmployee==null) return ResponseEntity.noContent().build();
		
		Employee Employee = employeeService.findEmployee(idEmployee);

		ResponseEntity<Employee> response = Employee!=null? new ResponseEntity<Employee>(Employee, HttpStatus.OK) : ResponseEntity.noContent().build();
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Employee employee) {
		ResponseEntity<Long> response = null;
		Long idEmployee = null;
		
		try {
			idEmployee = employeeService.createEmployee(employee);	
		}catch(Exception e) {
			logger.error(e);
		}
		
		response = idEmployee!=null? new ResponseEntity<Long>(idEmployee, HttpStatus.OK) : ResponseEntity.noContent().build(); 
		
		return response;
	}

	@RequestMapping(value = "/{idEmployee}/isemployee/{idCompany}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isEmployee(@PathVariable Long idEmployee,
											  @PathVariable Long idCompany) {

		boolean is = employeeService.isEmployee(idEmployee, idCompany);

		ResponseEntity<Boolean> response = is? new ResponseEntity<Boolean>(is, HttpStatus.OK) : ResponseEntity.noContent().build();
		return response;
	}
	
}
