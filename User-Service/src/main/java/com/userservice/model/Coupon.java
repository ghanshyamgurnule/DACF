package com.userservice.model;

public class Coupon {
	
	private int id;
	private String couponName;
	private String desc;
	private String couponCode;
	
	public Coupon()
	{
		
	}
	
	public Coupon(int id, String couponName, String desc, String couponCode) {
		super();
		this.id = id;
		this.couponName = couponName;
		this.desc = desc;
		this.couponCode = couponCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	

}
