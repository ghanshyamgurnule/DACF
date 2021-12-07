package com.couponservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.couponservice.model.Coupon;

public interface CouponRepository extends MongoRepository<Coupon, Integer>{

}
