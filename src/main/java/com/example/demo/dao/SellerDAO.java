package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Seller;
@RepositoryRestResource(path="seller")
@CrossOrigin("http://localhost:4200")

public interface SellerDAO extends JpaRepository<Seller, Integer> {

}
