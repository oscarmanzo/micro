package com.globant.training.micro.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.training.micro.model.Company;
import com.globant.training.micro.model.Discount;
import com.globant.training.micro.service.DiscountService;

@RestController
@RequestMapping("/discounts")
public class DiscountWS {

	private Logger logger = Logger.getLogger(DiscountWS.class);
	
	@Autowired
	private DiscountService discountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List getAll() {
		return null;	
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{idDiscount}")
	public Discount getDiscount(@PathVariable Long idDiscount) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/types")
	public List getTypes() {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Long create(@RequestBody Company company) {
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Discount edit(@PathVariable Long idCompany,
			             @PathVariable Long idProduct,
			             @PathVariable Long idTipeDiscount,
			             @RequestBody Discount discount) {
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{idDiscount}")
	public Boolean delete(@PathVariable Long idDiscount) {
		return null;
	}
	
}
