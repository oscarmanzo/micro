package com.globant.training.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.training.micro.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
