package com.couponservice.controller;

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

import com.couponservice.model.Coupon;
import com.couponservice.repository.CouponRepository;

@RestController
@RequestMapping("/coupon")
public class CouponController {
	
	@Autowired
	CouponRepository couponRepository;
	
	@GetMapping("/home")
	public String homepage()
	{
		return "HelloWorld";
	}
	
	//------- add coupon
	@PostMapping("/addCoupon")
	public String addCoupon(@RequestBody Coupon coupon){
		couponRepository.save(coupon);
		return "Added coupon with Id"+coupon.getId(); 
	}
	
	//------- fetch all coupon 

	@GetMapping("/getAllCoupon")
	public List<Coupon> getAllcoupon(){
		return couponRepository.findAll(); 
	}
	
	//------- fetch coupon by id

	@GetMapping("/getCouponById/{id}")
	public Optional<Coupon> getCouponById( @PathVariable int id){
		 return couponRepository.findById(id); 
	}
	
	//-------fetch coupon by category
	@GetMapping("/getCouponByCategory/{category}")
	public List<Coupon> getCouponByCategory( @PathVariable String category){
		 return couponRepository.findByCategory(category); 
	}
	
	//-------update coupon details by id
	@PutMapping("/updateCoupon/{id}")
	public String updatecoupon(@RequestBody Coupon coupon, @PathVariable int id) {
		couponRepository.save(coupon);
		return "Coupon Updated "; 		
	}
	
	//-------delete coupon by id
	@DeleteMapping("/delete/{id}")
	public String deleteCoupon(@PathVariable int id)
	{
		couponRepository.deleteById(id);
		return "Coupon Deleted";
	}
	
}
