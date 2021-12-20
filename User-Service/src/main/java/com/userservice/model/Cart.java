package com.userservice.model;

public class Cart {

	private int cartId;
	private int userId;
	private int couponIdList[];
	
	public Cart()
	{
		
	}
	public Cart(int cartId, int userId, int[] couponIdList) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.couponIdList = couponIdList;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int[] getCouponId() {
		return couponIdList;
	}
	public void setCouponId(int[] couponIdList) {
		this.couponIdList= couponIdList;
	}
	
	
}
