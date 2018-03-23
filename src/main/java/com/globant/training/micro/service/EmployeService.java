package com.globant.training.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.training.micro.repository.EmployeeRepository;

@Service
public class EmployeService {
	
	@Autowired
	private EmployeeRepository repository;

}
