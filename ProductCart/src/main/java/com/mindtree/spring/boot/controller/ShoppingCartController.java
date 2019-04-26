package com.mindtree.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.spring.boot.entities.Product;
import com.mindtree.spring.boot.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping("/user/{userId}/products")
	public void addProductToCart(@PathVariable int userId,@RequestBody Product product) {
		shoppingCartService.addProductToCart( userId, product);
	}
	
	@DeleteMapping("/user/{userId}/products/{productId}")
	public void removeProductFromCart(@PathVariable int userId,@PathVariable int productId) {
		shoppingCartService.removeProductFromCart(userId, productId);
	}
	
	@GetMapping("/user/{userId}/products")
	public List<Product> viewProducts(@PathVariable int userId){ 
		List<Product> products = shoppingCartService.viewProducts(userId);
		return products;
	}

}
