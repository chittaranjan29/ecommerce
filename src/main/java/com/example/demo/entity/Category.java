package com.example.demo.entity;


import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

@Entity
@Table(name="elmartcategory")
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	@NotNull
	@Column(name="elcategory_id")
	private int id;
	
	  @NotNull
	@Column(name="elcategory_name")
	private String name;
	 
	@OneToMany(mappedBy="elcategory")
	private Set<Product>product;
	 
	public Category() 
	{	}
	
	public Category(int id, String name) 
	{
		this.id = id;
		this.name = name;
	}

	public int getCategory_id() {
		return id;
	}

	public void setCategory_id(int id) {
		this.id = id;
	}

	public String getCategory_name() {
		return name;
	}

	public void setCategory_name(String name) {
		this.name = name;
	}
	
	
}
