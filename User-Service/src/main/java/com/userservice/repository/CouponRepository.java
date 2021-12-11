package com.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userservice.model.Coupon;


public interface CouponRepository extends MongoRepository<Coupon, Integer>{

	public Coupon getCouponById(int id);
}
