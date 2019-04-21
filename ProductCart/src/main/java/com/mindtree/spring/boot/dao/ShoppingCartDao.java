package com.mindtree.spring.boot.dao;

import java.util.List;

import com.mindtree.spring.boot.entities.Product;
import com.mindtree.spring.boot.entities.ProductCart;

public interface ShoppingCartDao {

	void addProductToCart(ProductCart productCart);

	void removeProductFromCart(int userId, int productId);

	void updateQuantityOfProduct(int userId, Product product);

	List<Product> viewProducts(int userId);

}
