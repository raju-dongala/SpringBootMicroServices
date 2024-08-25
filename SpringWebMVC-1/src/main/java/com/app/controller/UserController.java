package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/home")
	public String userHome() {
		
		return "UserHome";
	}
	
	
	

}
