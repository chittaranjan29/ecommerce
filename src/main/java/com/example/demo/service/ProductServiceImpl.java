package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Elmart_product_Repository;
import com.example.demo.entity.Product;

import exceptions.ResourceNotFoundException;

@Component
@Service
public class ProductServiceImpl  implements ProductService{
	@Autowired
	private Elmart_product_Repository productRepository;
	
	
	
	@Override
	public Product addProduct(Product product) {
		System.out.println("Product added Succesfully "+product);
		product.setProductname(product.getProductname());
		product.setAvailable_stock(product.getAvailable_stock());
		product.setUnit_price(product.getUnit_price());
		product.setElproduct_description(product.getElproduct_description());
		return productRepository.save(product);
	}

	



	@Override
	public Product updateProduct(Product product,int productId) {
		
		Product existingProduct = productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product"));
		existingProduct.setProductname(product.getProductname());
		//existingProduct.setPrice(product.getPrice());
		existingProduct.setUnit_price(product.getUnit_price());
		existingProduct.setElproduct_image(product.getElproduct_image());
		existingProduct.setElproduct_description(product.getElproduct_description());
		existingProduct.setAvailable_stock(product.getAvailable_stock());
		//existingProduct.setCartId(product.getCartId());

		productRepository.save(existingProduct);
		
		return existingProduct;
		
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("product"));
		productRepository.deleteById(productId);	
	

	}





	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}





	@Override
	public Product getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product"));
	}

}