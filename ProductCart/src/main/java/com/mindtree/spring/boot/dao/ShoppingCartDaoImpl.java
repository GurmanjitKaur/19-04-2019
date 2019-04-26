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
		Integer productId = productCart.getProduct().getProductId();
		String hql = "FROM ProductCart as model WHERE model.cart.user.userId = '"+userId+"'"
				+ "and model.product.productId = '"+productId+"'";
		List<?> prodCartList = entityManager.createQuery(hql).getResultList();
		if(prodCartList.size()>0) {
			ProductCart prodCart = (ProductCart)prodCartList.get(0);
			prodCart.setQuantity(prodCart.getQuantity() + 1);
			entityManager.merge(prodCart);
			return;
		}
		String hql1 = "FROM Cart as model WHERE model.user.userId = '"+userId+"'";
		Cart cart = (Cart) entityManager.createQuery(hql1).getSingleResult();
		productCart.setCart(cart);
		entityManager.persist(productCart);
	}

	@Override
	public void removeProductFromCart(int userId, int productId) {
		String hql = "FROM ProductCart as model WHERE model.cart.user.userId = '"+userId+"'"
				+ "and model.product.productId = '"+productId+"'";
		List<?> prodCartList = entityManager.createQuery(hql).getResultList();
		ProductCart prodCart = (ProductCart)prodCartList.get(0);
		if(prodCart.getQuantity() >1) {
			prodCart.setQuantity(prodCart.getQuantity() - 1);
			entityManager.merge(prodCart);
			return;
		}		
		entityManager.remove(prodCart);		
	}

	@Override
	public List<Product> viewProducts(int userId) {
		String hql = "FROM ProductCart as model WHERE model.cart.user.userId = '"+userId+"'";
		return entityManager.createQuery(hql).getResultList();
	}
}
