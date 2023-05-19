package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="elmart_product")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="elproduct_id")
	private int productid;
    @NotNull
    @Size(min=2, max=11)
	@Column(name="elproduct_name")
	 
	private String productname;
   @NotNull
   @Size(min=2, max=250)
	@Column(name="elproduct_description")
	private String elproduct_description;
    @NotNull
   @DecimalMin(value = "0.0", inclusive = false)
   @Digits(integer=3, fraction=2)
	@Column(name="unit_price")
	private Double unit_price;
   @NotNull
   @Size(min=2, max=1000)
	@Column(name="elproduct_image")
	private String elproduct_image;
    //@NotNull
   //	@Column(name="active")
	//private Byte active;
    @NotNull
   
	@Column(name="available_stock")
	private Integer available_stock;
    @Column(name="quantity")
	private Integer quantity;
	
	 @DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="date_created")
	private Date date_created;
	
	 @DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name="last_updated")
	private Date last_updated;
	
	@Column(name="elmart_category_id")
	private int elmart_category_id;
	
	@Column(name="elcategory_name")
	private String elcategory_name;
	public String getElcategory_name() {
		return elcategory_name;
	}


	public void setElcategory_name(String elcategory_name) {
		this.elcategory_name = elcategory_name;
	}


	@ManyToOne(targetEntity=Category.class,fetch=FetchType.EAGER)
	@JoinColumn(name="elmart_category_id",insertable=false,updatable=false)
	private Category elcategory;

    @OneToMany(mappedBy="productjoin")
	private Set<Ordemanage>ordemanagement;
	
	
	public Product() {
		
	}


	public Product(int productid, String productname, String elproduct_description, Double unit_price,
			String elproduct_image, Byte active, Integer available_stock, Date date_created, Date last_updated,
			int elmart_category_id,String elcategory_name,Integer quantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.elproduct_description = elproduct_description;
		this.unit_price = unit_price;
		this.elproduct_image = elproduct_image;
		//this.active = active;
		this.available_stock = available_stock;
		this.date_created = date_created;
		this.last_updated = last_updated;
		this.elmart_category_id = elmart_category_id;
		this.elcategory_name=elcategory_name;
		this.quantity=quantity;
	}


	

	@Override
	public String toString() {
		return "Product [quantity=" + quantity + "]";
	}


	public int getProduct_id() {
		return productid;
	}


	public void setProduct_id(int product_id) {
		this.productid = product_id;
	}

	


	public String getProductname() {
		return productname;
	}


	public void setProductname(String product_name) {
		this.productname = product_name;
	}


	public String getElproduct_description() {
		return elproduct_description;
	}


	public void setElproduct_description(String elproduct_description) {
		this.elproduct_description = elproduct_description;
	}




	public Double getUnit_price() {
		return unit_price;
	}


	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}


	public String getElproduct_image() {
		return elproduct_image;
	}


	public void setElproduct_image(String elproduct_image) {
		this.elproduct_image = elproduct_image;
	}


	/*
	 * public Byte getActive() { return active; }
	 * 
	 * 
	 * public void setActive(Byte active) { this.active = active; }
	 */

	

	public Date getDate_created() {
		return date_created;
	}


	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}


	public Date getLast_updated() {
		return last_updated;
	}


	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}


	public Integer getAvailable_stock() {
		return available_stock;
	}


	public void setAvailable_stock(Integer available_stock) {
		this.available_stock = available_stock;
	}


	public int getElmart_category_id() {
		return elmart_category_id;
	}


	public void setElmart_category_id(int elmart_category_id) {
		this.elmart_category_id = elmart_category_id;
	}




	






	

	
	
	
	
}
