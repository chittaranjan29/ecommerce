package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Elmart_user_Repository;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
@RequestMapping(path = "/controll")
@CrossOrigin("http://localhost:4200")
public class Usercontroller {
	@Autowired
	private Elmart_user_Repository dao;
	@Autowired
	private UserService service;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User userData) {
		User user = dao.findByUsername(userData.getUser_name());

		if (user.getUserpassword().equals(userData.getUserpassword())) {
			User senduser=new User();
			senduser.setEluser_id(user.getEluser_id());
			senduser.setFirst_name(user.getFirst_name());
			senduser.setLast_name(user.getLast_name());
			senduser.setUser_address1(user.getUser_address1());
			senduser.setUser_address2(user.getUser_address2());
			senduser.setUser_name(user.getUser_name());
			return ResponseEntity.ok(senduser);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

//	@GetMapping("/getid")
//	public int getidbyuname(@RequestParam("uname") String uname) {
//		User user=reposit.findByUsername(uname);
//		return user.getEluser_id();
//		
//	}
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User u=dao.findByUsername(user.getUser_name());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
		}
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<User> getCustomerById(@PathVariable("id") int customerId) {
		return new ResponseEntity<User>(service.getCustomerById(customerId), HttpStatus.OK);
	}
}
