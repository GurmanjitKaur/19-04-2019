package com.mindtree.spring.boot.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Apparal")
public class Apparal extends Product {

	private String type;
	private String brand;
	private String design;
	
	

	public Apparal(Integer productId, String productName, Float price, String type, String brand, String design) {
		super(productId, productName, price);
		this.type = type;
		this.brand = brand;
		this.design = design;
	}
	
	public Apparal() {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

}
