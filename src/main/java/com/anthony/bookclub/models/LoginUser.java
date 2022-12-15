package com.anthony.bookclub.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	// class variables
	@NotEmpty(message="Email is required")
	private String email;
	@NotEmpty(message="Password is required")
	@Size(min=4,message="Password must be 4 characters or longer")
	private String password;
	
	// constructors
	public LoginUser() {
	}
	
	// getters and setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
