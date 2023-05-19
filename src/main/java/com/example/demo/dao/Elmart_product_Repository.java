package com.example.demo.dao;


import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.example.demo.entity.Product;

@RepositoryRestResource(path="epro")
@CrossOrigin("http://localhost:4200")
public interface Elmart_product_Repository extends JpaRepository<Product,Integer>
{
	List<Product>findByProductnameIgnoreCase(String pname);
	Page<Product>findByElcategory_id(@RequestParam("id")Integer id,Pageable pageable);
	
	

}
