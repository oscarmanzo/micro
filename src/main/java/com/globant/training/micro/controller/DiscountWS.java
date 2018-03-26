package com.globant.training.micro.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List> getAll() {
		return null;	
	}

	@RequestMapping(value = "/{idDiscount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Discount> getDiscount(@PathVariable Long idDiscount) {
		return null;
	}
	
	@RequestMapping(value = "/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> getTypes() {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Company company) {
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Discount> edit(@PathVariable Long idCompany,
			             @PathVariable Long idProduct,
			             @PathVariable Long idTipeDiscount,
			             @RequestBody Discount discount) {
		return null;
	}

	@RequestMapping(value = "/{idDiscount}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@PathVariable Long idDiscount) {
		return null;
	}
	
}
