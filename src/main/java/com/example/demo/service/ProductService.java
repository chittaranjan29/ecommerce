package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	Product addProduct(Product product);
    List<Product> getAllProducts();
	Product getProductByProductId(int productId);
	Product updateProduct(Product product, int productId);
	void deleteProduct(int productId);
}