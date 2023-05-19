package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Elmart_product_Repository;
import com.example.demo.entity.Product;

import exceptions.ProductCustomException;
import exceptions.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class ProductController 
{
	@Autowired
	private Elmart_product_Repository productRepository;
	
	// get all products
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/save")
	public Product createProduct(@RequestBody Product product) 
	{
		
		return productRepository.save(product);
	}
	
	// get product by id rest api
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));
		return ResponseEntity.ok(product);
	}
	
	// update products rest api
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateEmployee(@PathVariable Integer id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
		
		product.setProductname(productDetails.getProductname());
		product.setAvailable_stock(productDetails.getAvailable_stock());
		product.setElproduct_description(productDetails.getElproduct_description());
		
		Product updatedEmployee = productRepository.save(product);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete products rest api
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
		Product employee = productRepository.findById(id)
				.orElseThrow(() -> new ProductCustomException("product not exist with id :" + id));
		
		productRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	


}
