package com.globant.training.micro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.training.micro.model.Product;
import com.globant.training.micro.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAllProducts(){
		return repository.findAll();
	}
	
	public Product findProduct(Long idProduct) {
		Product product = null;
		Optional<Product> optional = repository.findById(idProduct);

		product = optional.isPresent()? optional.get(): null;

		return product;
	}
	
	public Long createProduct(Product product) {
		product = repository.save(product);
		Long id = product.getId();
		return id;
	}

}