package com.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userservice.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

	//public Coupon findCouponById(int id);

}
