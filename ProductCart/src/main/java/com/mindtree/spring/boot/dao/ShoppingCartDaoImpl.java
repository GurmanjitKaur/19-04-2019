package com.mindtree.spring.boot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.spring.boot.entities.Cart;
import com.mindtree.spring.boot.entities.Product;
import com.mindtree.spring.boot.entities.ProductCart;

@Transactional
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void addProductToCart(ProductCart productCart) {
		Integer userId = productCart.getCart().getUser().getUserId();
		String hql = "FROM Cart WHERE user_id = '"+userId+"'";
		List<?> cartList = entityManager.createQuery(hql).getResultList();
		Cart cart = (Cart)cartList.get(0);
		productCart.setCart(cart);
		entityManager.flush();
	}

	@Override
	public void removeProductFromCart(int userId, int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuantityOfProduct(int userId, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> viewProducts(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
