package com.mindtree.spring.boot.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Integer cartId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
	private List<ProductCart> productCartList;

	
	public Cart(Integer cartId, User user) {
		super();
		this.cartId = cartId;
		this.user = user;
	}
	
	public Cart() {}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductCart> getProductCartList() {
		return productCartList;
	}

	public void setProductCartList(List<ProductCart> productCartList) {
		this.productCartList = productCartList;
	}

}
