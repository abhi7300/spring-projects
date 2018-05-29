package com.app.myspringmvc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull
	@NotEmpty(message = "Please enter your user id.")
	@Size(min=5, max=10, message = "Your user Id must be between 5 and 10 characters")
	private String userId;
	
	@NotNull
	@NotEmpty(message = "Please enter your password.")
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;

	public User() {
	}

	public User(String firstname, String lastname, String email, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
