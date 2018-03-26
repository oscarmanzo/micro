package com.globant.training.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.training.micro.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
