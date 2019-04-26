package com.mindtree.spring.boot.dao;

import java.util.List;

import com.mindtree.spring.boot.entities.Product;
import com.mindtree.spring.boot.entities.ProductCart;

public interface ShoppingCartDao {

	void addProductToCart(ProductCart productCart);

	void removeProductFromCart(int userId, int productId);

	List<Product> viewProducts(int userId);

}
