package com.userservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDB")
public class User {
	
	@Id
	private int userId;
	private String name;
	private String email;
	private int password;
	private String city;
	private String gender;	
	
	public User(int userId, String name, String email, int password, String city, String gender) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.gender = gender;
	}
	public int getId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
