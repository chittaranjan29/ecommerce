package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartRepository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;

import exceptions.ResourceNotFoundException;


@Service
public class CartServiceImpl implements CartService {
	
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	public CartRepository cartRepository;
	
//	@Autowired
//	public ProductRepository productRepository;

	@Autowired
	public ProductService productService;
	
	@Autowired
	public UserService customerService;
	
public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}

@Override
public Cart addCart(Cart cart,int productId,int customerId) {

	Product product =productService.getProductByProductId(productId) ;
	User customer =customerService.getCustomerById(customerId) ;
	   product.setAvailable_stock(product.getAvailable_stock()-cart.getQuantity());
	 productService.updateProduct( product,product.getAvailable_stock()-1);
	cart.setProduct(product);
	cart.setMrpPrice(product.getUnit_price());
	cart.setCustomer(customer);
	  System.out.println("product"+product);
	  System.out.println("customer"+customer);
	  System.out.println("cart"+cart);
	  
		    	
	return cartRepository.save(cart);
}



@Override
public List<Cart> getAllCarts() {
	return cartRepository.findAll();
}



@Override
public Cart getCartById(long cartId) {
	
	return cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart"));
}



@Override
public Cart updateCart(Cart cart, long cartId) {
	Cart existingCart=cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart"));
	existingCart.setQuantity(cart.getQuantity());
	//existingCart.setPrice(cart.getPrice());
	existingCart.setMrpPrice(cart.getMrpPrice());
	//existingCart.setImage(cart.getImage());
	existingCart.setCartId(cart.getCartId());
	existingCart.setProduct(cart.getProduct());
	//existingCart.setCustomerId(cart.getCustomerId());
	existingCart.setCustomer(cart.getCustomer());
    cartRepository.save(existingCart);
    
	return existingCart;
}



@Override
public void deleteCart(long cartId) {
	cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart"));
	cartRepository.deleteById(cartId);
	
}

}