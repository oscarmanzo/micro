package com.globant.training.micro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.training.micro.model.Company;
import com.globant.training.micro.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public List<Company> findAllCompanies(){
		return repository.findAll();
	}
	
	public Company findCompany(Long idCompany) {
		Company company = null;
		Optional<Company> optional = repository.findById(idCompany);

		company = optional.isPresent()? optional.get(): null;

		return company;
	}
	
	public Long createCompany(Company company) {
		company = repository.save(company);
		Long id = company.getId();
		return id;
	}
	
}
