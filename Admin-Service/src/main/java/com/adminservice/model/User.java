package com.adminservice.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserDB")
public class User {
	
	@Id
	private int id;
	private String name;
	private String email;
	private int password;
	private String city;
	private String gender;
	private ArrayList<Integer> myCoupon;
	
	public User() {
		
	}
	
	public User(int id, String name, String email, int password, String city, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.gender = gender;
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
	public ArrayList<Integer> getMyCoupon() {
		return myCoupon;
	}
	public void setMyCoupon(ArrayList<Integer> myCoupon) {
		this.myCoupon = myCoupon;
	}
	
	
	
}
