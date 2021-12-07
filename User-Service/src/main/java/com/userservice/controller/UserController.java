package com.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/home")
	public String homepage()
	{
		return "HelloWorldUser";
	}
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user){
		userRepository.save(user);
		return "Added user with Id"+user.getId(); 
	}
	
	@GetMapping("/getuser")
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

}
