package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart_table")
//@SequenceGenerator(name = "generator3", sequenceName = "gen3", initialValue = 1000)
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long cartId;

//	@Column(name="image")
//	private String image;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "mrp_price", nullable = false)
	private double mrpPrice;

//	// @Size(min = 2, max = 10)
//	@Column(name = "price", nullable = false)
//	private double price;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="elproduct_id")
	@JsonIgnore
    private Product product;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="eluser_id")
	//@JsonIgnore
    private User customer;
	
	
	
	public Cart() {

	}



	public long getCartId() {
		return cartId;
	}



	public void setCartId(long cartId) {
		this.cartId = cartId;
	}



	public int getQuantity() {
		return quantity;
	}





	public User getCustomer() {
		return customer;
	}



	public void setCustomer(User customer) {
		this.customer = customer;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getMrpPrice() {
		return mrpPrice;
	}



	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", mrpPrice=" + mrpPrice + ", product=" + product
				+ ", customer=" + customer + "]";
	}



	
	


	


}