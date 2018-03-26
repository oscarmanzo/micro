package com.globant.training.micro.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductWS {

	private Logger logger = Logger.getLogger(ProductWS.class);
	
}
