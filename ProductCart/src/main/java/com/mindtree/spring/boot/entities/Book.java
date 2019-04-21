package com.mindtree.spring.boot.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Book")
public class Book extends Product{

	private String genre;
	private String author;
	private String publication;
	
	

	public Book(Integer productId, String productName, Float price, String genre, String author, String publication) {
		super(productId, productName, price);
		this.genre = genre;
		this.author = author;
		this.publication = publication;
	}
	
	public Book(){}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

}
