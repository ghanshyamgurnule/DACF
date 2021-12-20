package com.cartservice.controller;

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

import com.cartservice.model.Cart;
import com.cartservice.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartRepository cartRepository;
			
	@GetMapping("/hello")
	public String homepage() {
		return "Hello (Cart)";
	}
	
	//------- add to cart
	@PostMapping("/addCart")
	public String saveCoupon(@RequestBody Cart cart){
		cartRepository.save(cart);
		return "Added Cart with Id"+cart.getCartId(); 
	}
	
	//------- fetch coupon from cart 
	@GetMapping("/getCart")
	public List<Cart> getCart(){
		return cartRepository.findAll(); 
	}
	
	//------- fetch cart by userid 
	@GetMapping("/getCartByUserId/{userId}")
	public Optional<Cart> getCartByUserId(@PathVariable int userId)
	{
		return cartRepository.findByUserId(userId);
	}
	
	//-------update cart by cartid
	@PutMapping("/updateCart/{cartId}")
	public String updateCart(@RequestBody Cart cart, @PathVariable int cartId) {
		cartRepository.save(cart);
		return "Cart Updated "; 		
	}
	
	//-------delete cart by cartid
	@DeleteMapping("/delete/{cartId}")
	public String deleteCart(@PathVariable int cartId)
	{
		cartRepository.deleteById(cartId);
		return "Profile Deleted";
	}
	
}
