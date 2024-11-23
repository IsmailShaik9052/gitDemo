package com.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value="*")
@RestController
public class SineUpController {
	
//	public String sineUP(@RequestBody SineUp sineUp) {
//		
//		return "";
//	}

	
	@GetMapping(value="/loginUser")
	public String loginUser() {
		return "successfully login inside the product";
	}
	
	
	@GetMapping(value="/user")
	public String userDetails() {
		return "User Details are Private....?";
	}
	
	
	@GetMapping(value="/modify")
	public String modify() {
		return "User Details modify are Private....?";
	}
	
	@GetMapping(value="/delete")
	public String delete() {
		return "User delete Details  are Private....?";
	}
	
	
}
