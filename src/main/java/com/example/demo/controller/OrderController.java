package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.Elmart_Orders_Repository;
import com.example.demo.dao.Elmart_product_Repository;
import com.example.demo.entity.Ordemanage;
import com.example.demo.entity.Orderid;
import com.example.demo.entity.Product;

import exceptions.OrderCustomException;
import exceptions.ProductCustomException;
import exceptions.ResourceNotFoundException;

public class OrderController
{
	@Autowired
	private Elmart_Orders_Repository ordersRepository;
	
	// get all products
	@GetMapping("/orders")
	public List<Ordemanage> getAllOrders(){
		return ordersRepository.findAll();
	}		
	
	// create product rest api
	@PostMapping("/orderssave")
	public Ordemanage createOrders(@RequestBody Ordemanage orders) {
		return ordersRepository.save(orders);
	}
	
	
	

}
