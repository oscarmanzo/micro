package com.globant.training.micro.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.training.micro.model.Discount;
import com.globant.training.micro.model.TypeDiscount;
import com.globant.training.micro.repository.DiscountRepository;
import com.globant.training.micro.repository.TypeDiscountRepository;

@Service
public class DiscountService {

	private Logger logger = Logger.getLogger(DiscountService.class);
	
	@Autowired
	private DiscountRepository repository;

	@Autowired
	private TypeDiscountRepository typeRepository;
	
	public List<Discount> findAllDiscounts() {
		return repository.findAll();
	}
	
	public Discount findDiscount(Long idDiscount) {
		Discount discount = null;
		Optional<Discount> optional = repository.findById(idDiscount);

		discount = optional.isPresent()? optional.get(): null;

		return discount;
	}
	
	public List<TypeDiscount> findTypesDiscount() {
		return typeRepository.findAll();
	}
	
	public Long createDiscount(Discount discount) {
		discount = repository.save(discount);
		Long id = discount.getId();
		return id;
	}
	
	public Discount updateDiscount(Long idCompany,
					     Long idProduct,
					     Long idTipeDiscount,
					     Discount discount) {

		
		discount = repository.save(discount);
		
		return null;
	}

	public Boolean delete(Long idDiscount) {
		boolean result = true;
		
		try {
			repository.deleteById(idDiscount);	
		}catch(Exception e) {
			logger.error(e);
			result = false;
		}

		return result;
	}
	
}
