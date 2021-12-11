package com.userservice.controller;

import java.util.Arrays;
import java.util.List;

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
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user){
		userRepository.save(user);
		return "Added user with Id"+user.getId(); 
	}
	
	@GetMapping("/getUser")
	public List<User> getUser(){
		return userRepository.findAll(); 
	}
	
	@PutMapping("/update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable int id) {
		userRepository.save(user);
		return "Profile Updated "; 		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id)
	{
		userRepository.deleteById(id);
		return "Profile Deleted";
	}
	
	@GetMapping("/getAllCoupon")
	public List<Coupon> getAllcoupon(){
		return Arrays.asList(restTemplate.getForObject("http://Coupon-Service/coupon/getAllCoupon", Coupon[].class ));
	}
	

}
