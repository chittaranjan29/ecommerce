package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.User;


@RepositoryRestResource(path="euser")
@CrossOrigin("http://localhost:4200")
public interface Elmart_user_Repository extends JpaRepository<User,Integer>
{
	 User findByUsername(String uname);
	 
}
