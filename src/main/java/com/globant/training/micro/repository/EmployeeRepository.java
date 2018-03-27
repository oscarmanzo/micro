package com.globant.training.micro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globant.training.micro.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "select e from Employee e where e.id = :idEmployee and e.company.id = :idCompany")
	public Optional<Employee> findByCompany(@Param("idEmployee") Long idEmployee,
			                                @Param("idCompany") Long idCompany);
	
}
