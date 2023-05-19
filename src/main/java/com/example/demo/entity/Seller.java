package com.example.demo.entity;

import java.util.Set;

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

@Entity
@Table(name ="seller")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seller_id")
	private int seller_id;
	@NotNull
	@Size(min=2, max=30) 

	@Column(name="seller_name")
	private String seller_name;
	
	/*@OneToMany(mappedBy="seller")
	private Set<Product> product;*/

	public Seller() {
		
	}

	public Seller(int seller_id, String seller_name) {
		super();
		this.seller_id = seller_id;
		this.seller_name = seller_name;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	
	

}
