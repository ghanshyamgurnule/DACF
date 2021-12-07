package com.adminservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("/home")
	public String homepage()
	{
		return "HelloWorld Admin";
	}
	
}
