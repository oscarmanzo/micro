package com.globant.training.micro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.globant.training.micro.model.Employee;
import com.globant.training.micro.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> findAllEmployees(){
		return repository.findAll();
	}
	
	public Employee findEmployee(Long idEmployee) {
		Employee Employee = null;
		Optional<Employee> optional = repository.findById(idEmployee);

		Employee = optional.isPresent()? optional.get(): null;

		return Employee;
	}
	
	public Long createEmployee(Employee Employee) {
		Employee = repository.save(Employee);
		Long id = Employee.getId();
		return id;
	}

	public boolean isEmployee(Long idEmployee, Long idCompany) {
		Optional<Employee> optional = repository.findByCompany(idEmployee, idCompany);
		return optional.isPresent();
	}
	
}
