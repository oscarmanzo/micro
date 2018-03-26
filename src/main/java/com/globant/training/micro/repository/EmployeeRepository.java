package com.globant.training.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.training.micro.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
