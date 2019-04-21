package com.example.demo.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//For Swagger documentation
@ApiModel(description="All details for User")
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	//For Swagger documentation
	@ApiModelProperty(notes = "Length of Name should be more than 3 characters")
	//For Validation
	@Size(min = 4,message = "Length of Name should be more than 3 characters")
	private String name;
	
	//For Swagger documentation
	@ApiModelProperty(notes = "Date of Birth should not be future date")
	//For Validation
	@Past(message = "Date of Birth should not be future date")
	private Date dob;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User() {
	}

	public User(int id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
