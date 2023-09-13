package com.dnb.devconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.devconnector.dto.User;
import com.dnb.devconnector.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("/create")
	public User createUser(User user) {
		return userService.createUser(user);
		
	}
}
