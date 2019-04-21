package com.mindtree.spring.boot.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer productId;
	private String productName;
	private Float price;
	
	@OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
	private List<ProductCart> productCartList;

	
	public Product(Integer productId, String productName, Float price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public Product() {}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<ProductCart> getProductCartList() {
		return productCartList;
	}

	public void setProductCartList(List<ProductCart> productCartList) {
		this.productCartList = productCartList;
	}
}
