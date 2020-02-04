package com.capgemini.userprofilemgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.userprofilemgmtservice.customexceptions.UserLoginException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserLogoutException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserRegisterException;
import com.capgemini.userprofilemgmtservice.dto.User;
import com.capgemini.userprofilemgmtservice.services.UserService;


@RestController
@RequestMapping(path = "/user")
public class UserProfileController  {

	@Autowired
	UserService userService;
	
	@PostMapping(path = "/register")
	public String register(@RequestBody User user) throws Exception {
		try {
			userService.register(user);
		}catch(UserRegisterException exception) {
			return "User Cannot be registered!!!";
		}
		return "User added successfully.";
	}
	
	@PostMapping(path = "/login")
	public String login(@RequestBody User user) {
		try {
			userService.login(user);
		}catch(UserLoginException exception) {
			return "User Cannot be logged-in!!!";
		}
		return "User login successfully.";
	}
	
	@PostMapping(path = "/logout")
	public String logout(@RequestBody User user) {
		try {
			userService.logout (user);
		}catch(UserLogoutException exception) {
			return "User Cannot be logged-out!!!";
		}
		return "User logged-out successfully.";
	}
	
	

}
