package com.globant.training.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.training.micro.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
