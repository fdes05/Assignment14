package com.fabio.Assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.fabio.Assignment14.service.UserService;

@Controller
public class UserController {

	@Autowired 
	UserService userServ;
		
	@GetMapping("/register")
	public String requestUserName() {
		
		return "register";
	}
	
	@PostMapping("/register")
	public void saveUserName(@RequestBody String userName) {
		userServ.saveUser(userName);
	}
	
	

}
