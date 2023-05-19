package com.example.demo.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.entity.Ordemanage;
import com.example.demo.entity.Orderid;
import com.example.demo.entity.Product;


@RepositoryRestResource(path = "eorders")
@CrossOrigin("http://localhost:4200")
public interface Elmart_Orders_Repository extends JpaRepository<Ordemanage, Orderid> {
	
	//Page<Ordemanage> findByUserid1(@RequestParam("id") Integer id, Pageable pageable);

	Page<Ordemanage> findByProductid(@RequestParam("id") Integer id, Pageable pageable);
	
	Ordemanage findProductidByUserid(@RequestParam("id") Integer id);
	
	@Query("select s.productjoin from Order_Management s where s.productid = :productid")
	List<Product> findProductjoinByProducts(@RequestParam("productid") Integer productid);

	@Query("select s.productjoin from Order_Management s where s.userid = :userid")
	List<Product> findProductjoinByUserid(@RequestParam("userid") Integer userid);
	
	@Query("Delete from Order_Management o where o.orders=:orders")
	List<Ordemanage> deleteByOrders(@RequestParam("orders")Integer orders);
Page<Product> findByUserid(@RequestParam("id") Integer id,Pageable pageable);
}
