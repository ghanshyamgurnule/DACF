package com.adminservice.Controller;

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

import com.adminservice.model.Admin;
import com.adminservice.model.Coupon;
import com.adminservice.model.User;
import com.adminservice.repository.AdminRepository;
//import com.adminservice.repository.CouponRepository;
//import com.adminservice.repository.UserRepository;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/home")
	public String homepage()
	{
		return "HelloWorld Admin";
	}
	
	

	@PostMapping("/addAdmin")
	public String addUser(@RequestBody Admin admin){
		adminRepository.save(admin);
		return "Added Admin with Id"+admin.getId(); 
	}
	
	@GetMapping("/getAdmin")
	public List<Admin> getUser(){
		return adminRepository.findAll(); 
	}
	
	@PutMapping("/updateAdmin/{id}")
	public String updateUser(@RequestBody Admin admin, @PathVariable int id) {
		adminRepository.save(admin);
		return "Admin Profile Updated "; 		
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public String deleteUser(@PathVariable int id)
	{
		adminRepository.deleteById(id);
		return "Admin Profile Deleted";
	}
	
	//communication with coupon microservice using RestTemplate
	
	@GetMapping("/getCoupon")
	public List<Coupon> getCoupon()
	{
		String url="http://Coupon-Service/coupon/getAllCoupon";
		return Arrays.asList(restTemplate.getForObject(url, Coupon[].class));
	}
	
	
	@PostMapping("/addCoupon")
	public String addCoupon(@RequestBody Coupon coupon) 
	{
		restTemplate.postForObject("http://Coupon-Service/coupon/addCoupon", coupon, String.class);
		return "Coupon added";
	}
	
	@PutMapping("/update/{id}")
	public String updateCouponById(@PathVariable int id, @RequestBody Coupon coupon) {
		restTemplate.put("http://Coupon-Service/coupon/updateCoupon/"+id, coupon, String.class);
		return "Coupon Updated";
	}
	
	@DeleteMapping("/deleteCoupon/{id}")
	public String deleteCouponById(@PathVariable int id) 
	{
		restTemplate.delete("http://Coupon-Service/coupon/delete/"+id, String.class);
		return "Coupon Deleted";
	}

	//communication with User microservice using RestTemplate

	
	@GetMapping("/getUser")
	public List<User> getAllUser()
	{
		String url="http://User-Service/user/getUser";
		return Arrays.asList(restTemplate.getForObject(url, User[].class));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUsernById(@PathVariable int id) 
	{
		restTemplate.delete("http://User-Service/user/delete/"+id, String.class);
		return "User Deleted";
	}
	
}
