package com.globant.training.micro.controller;

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

import com.globant.training.micro.model.Product;
import com.globant.training.micro.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductWS {

	private Logger logger = Logger.getLogger(ProductWS.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAll() {

		List<Product> products = productService.findAllProducts();

		ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(products, HttpStatus.OK);

		return response;
	}
	
	@RequestMapping(value = "/{idProduct}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable Long idProduct) {

		if (idProduct==null) return ResponseEntity.noContent().build();
				
		Product Product = productService.findProduct(idProduct);

		ResponseEntity<Product> response = Product!=null? new ResponseEntity<Product>(Product, HttpStatus.OK) : ResponseEntity.noContent().build();
		
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> create(@RequestBody Product Product) {
		ResponseEntity<Long> response = null;
		Long idProduct = null;
		
		try {
			idProduct = productService.createProduct(Product);	
		}catch(Exception e) {
			logger.error(e);
		}
		
		response = idProduct!=null? new ResponseEntity<Long>(idProduct, HttpStatus.OK) : ResponseEntity.noContent().build(); 
		
		return response;
	}

}
