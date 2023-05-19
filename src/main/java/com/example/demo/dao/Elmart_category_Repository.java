package com.example.demo.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;


@RepositoryRestResource(path="ecat")
@CrossOrigin("http://localhost:4200")
public interface Elmart_category_Repository extends JpaRepository<Category,Integer>
{
	
}
