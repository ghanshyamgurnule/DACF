package com.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.model.Cart;
import com.userservice.model.Coupon;
import com.userservice.model.User;

import com.userservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
		
	@GetMapping("/home")
	public String homepage()
	{
		return "HelloWorldUser";
	}
	
	//-------add user details
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user){
		userRepository.save(user);
		return "Added user with Id"+user.getId(); 
	}
	
	//------- fetch all user details
	@GetMapping("/getUser")
	public List<User> getUser(){
		return userRepository.findAll(); 
	}
	
	//-------fetch user details by id
	@GetMapping("/getUserById/{id}")
	public Optional<User> getUserById(@PathVariable int id)
	{
		return userRepository.findById(id);
	}
	
	//-------update user details by id
	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable int id) {
		userRepository.save(user);
		return "Profile Updated "; 		
	}
	
	//-------delete user details by id
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
		return "Profile Deleted";
	}

	
	
//------------communication with coupon microservice using RestTemplate
	
	
	
	//-------fetch all coupons
	@GetMapping("/getAllCoupon")
	public List getAllcoupon(){
		return restTemplate.getForObject("http://Coupon-Service/coupon/getAllCoupon", List.class );
	}
	
	//-------fetch coupon by id
	@GetMapping("/getCoupons/{id}")
	public Coupon getCouponById(@PathVariable int id )
	{
		return restTemplate.getForObject("http://Coupon-Service/coupon/getCouponById/" + id, Coupon.class);
	}
	
	//------- fetch coupon by category
		@GetMapping("/getCouponsCategory/{category}")
		public List<Coupon> getCouponByCategory(@PathVariable String category )
		{
				return restTemplate.getForObject("http://Coupon-Service/coupon/getCouponByCategory/" + category, List.class);
		}
		
		
//------------communication with cart microservice using RestTemplate

		
	//-------fetch cart by userId	
	 @GetMapping("/getByUserId/{userId}")
	 public Cart getCartByUserId(@PathVariable int userId){
		return restTemplate.getForObject("http://Cart-Service/cart/getCartByUserId/"+ userId ,Cart.class );
		 
	 }

	
}
