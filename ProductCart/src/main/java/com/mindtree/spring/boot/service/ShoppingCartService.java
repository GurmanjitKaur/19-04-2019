package com.mindtree.spring.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.spring.boot.entities.Product;

@Service
public interface ShoppingCartService {

	void addProductToCart(int userId, Product product);

	void removeProductFromCart(int userId, int productId);

	void updateQuantityOfProduct(int userId, Product product);

	List<Product> viewProducts(int userId);

}
