package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@IdClass(Orderid.class)
@Entity(name="Order_Management")
@Table (name="Order_Management")
public class Ordemanage {
	
	@Id
  // @Size(min=2, max=30) 
	//@NotNull
	@Column(name="orders")
	private int orders;
	
	@Id
//	@NotNull
	@Column(name="el_userid")
	private int userid;
	
	@Column(name="first_name")
	private String first_name;
	@Id
	//@NotNull
	@Column(name="product_id")
	private int productid;
	
	@Column(name="productname")
	 
	private String productname;
	
	@Column(name="noofitems")
	private int numberofitems;

	public int getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}

	@ManyToOne(targetEntity=User.class,fetch=FetchType.EAGER)
	@JoinColumn(name="el_userid",insertable=false,updatable=false)
	private User userjoin;
	
	@ManyToOne(targetEntity=Product.class,fetch=FetchType.EAGER)
	@JoinColumn(name="product_id",insertable=false,updatable=false)
	private Product productjoin;
	
	
	
	public Ordemanage(int orders, int userid, int productid,String productname,String first_name) {
		super();
		this.orders = orders;
		this.userid = userid;
		this.productid = productid;
		
		this.productname=productname;
		this.first_name=first_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Ordemanage() {
		super();
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	
	
	

	
	
	
	

	
}