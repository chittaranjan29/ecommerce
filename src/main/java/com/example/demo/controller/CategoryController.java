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

import com.example.demo.dao.Elmart_category_Repository;

import com.example.demo.entity.Category;

import exceptions.CategoryCustomException2;
import exceptions.ResourceNotFoundException;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CategoryController 
{

	@Autowired
	private Elmart_category_Repository categoryRepository;
	
	// get all category
	@GetMapping("/category")
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}		
	
	// create category rest api
	@PostMapping("/category")
	public Category createCategory(@RequestBody Category product) 
	{
		product.setCategory_id(0);
		return categoryRepository.save(product);
	}
	
	// get category by id rest api
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
		Category product = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryCustomException2("Category not exist with id :" + id));
		return ResponseEntity.ok(product);
	}
	
	// update category rest api
	
	@PutMapping("/category/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category categoryDetails){
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryCustomException2("Category not exist with id :" + id));
		
		category.setCategory_name(categoryDetails.getCategory_name());
		category.setCategory_id(categoryDetails.getCategory_id());
		//category.setElproduct_description(categoryDetails.);
		
		Category updatedEmployee = categoryRepository.save(category);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete category rest api
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
		Category employee = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryCustomException2("category not exist with id :" + id));
		
		categoryRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
