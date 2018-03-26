package com.globant.training.micro.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.globant.training.micro.model.Discount;
import com.globant.training.micro.model.TypeDiscount;
import com.globant.training.micro.service.DiscountService;

@RestController
@RequestMapping("/discounts")
public class DiscountWS {

	private Logger logger = Logger.getLogger(DiscountWS.class);
	
	@Autowired
	private DiscountService discountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Discount>> getAll() {
		List<Discount> discounts = discountService.findAllDiscounts();
		ResponseEntity<List<Discount>> response = new ResponseEntity<List<Discount>>(discounts, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/{idDiscount}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Discount> getDiscount(@PathVariable Long idDiscount) {
		if (idDiscount==null) return ResponseEntity.noContent().build();
		
		Discount discount = discountService.findDiscount(idDiscount);

		ResponseEntity<Discount> response = discount!=null? new ResponseEntity<Discount>(discount, HttpStatus.OK) : ResponseEntity.noContent().build();
		return response;
	}
	
	@RequestMapping(value = "/types", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TypeDiscount>> getTypes() {
		List<TypeDiscount> types = discountService.findTypesDiscount();
		
		ResponseEntity<List<TypeDiscount>> response = new ResponseEntity<List<TypeDiscount>>(types, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Discount discount) {
		ResponseEntity<Long> response = null;
		Long idDiscount = null;
		
		try {
			idDiscount = discountService.createDiscount(discount);	
		}catch(Exception e) {
			logger.error(e);
		}
		
		response = idDiscount!=null? new ResponseEntity<Long>(idDiscount, HttpStatus.OK) : ResponseEntity.noContent().build(); 
		
		return response;
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
		ResponseEntity<Boolean> response = null;
		Boolean deleted = null;
		
		try {
			deleted = discountService.delete(idDiscount);	
		}catch(Exception e) {
			logger.error(e);
		}
		
		response = deleted!=null? new ResponseEntity<Boolean>(deleted, HttpStatus.OK) : ResponseEntity.noContent().build(); 

		return response;
	}

	/**
	 * WS Client
	 * Invocacion de WS
	 **/
	private String readingList() {
	    RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8090/recommended");
	    return restTemplate.getForObject(uri, String.class);
	  }
	
}
