package com.mindtree.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mindtree.spring.boot.dao.ShoppingCartDao;
import com.mindtree.spring.boot.entities.Cart;
import com.mindtree.spring.boot.entities.Product;
import com.mindtree.spring.boot.entities.ProductCart;
import com.mindtree.spring.boot.entities.User;

@Component
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	public void addProductToCart(int userId, Product product) {
		ProductCart productCart = new ProductCart(new Cart(null,new User(userId,null)), product,1);
		shoppingCartDao.addProductToCart(productCart);

	}

	@Override
	public void removeProductFromCart(int userId, int productId) {
		shoppingCartDao.removeProductFromCart(userId, productId);

	}

	@Override
	public List<Product> viewProducts(int userId) {
		List<Product> products = shoppingCartDao.viewProducts(userId);
		return products;
	}

}
