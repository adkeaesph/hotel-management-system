package com.capgemini.userprofilemgmtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.userprofilemgmtservice.customexceptions.UserLoginException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserLogoutException;
import com.capgemini.userprofilemgmtservice.customexceptions.UserRegisterException;
import com.capgemini.userprofilemgmtservice.dto.User;
import com.capgemini.userprofilemgmtservice.entities.UserEntity;
import com.capgemini.userprofilemgmtservice.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "/user")
public class UserProfileController  {

	@Autowired
	UserService userService;
	
	@ResponseBody
	@PostMapping(path = "/register")
	public String register(@RequestBody User user) throws Exception {
		try {
			userService.register(user);
		}catch(UserRegisterException exception) {
			return "User Cannot be registered!!!" + exception.getMessage();
		}
		return "User added successfully.";
	}
	
	@ResponseBody
	@PostMapping(path = "/login")
	public String login(@RequestBody User user) {
		System.out.println(user);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode dataResponse = mapper.createObjectNode();
		UserEntity existingUser = null;
		try {
			existingUser = userService.login(user);
			String userFetched = mapper.writeValueAsString(existingUser);
			dataResponse = mapper.readTree(userFetched);
		}catch(UserLoginException exception) {
			
			return "User Cannot be logged-in!!! " + exception.getMessage();
		}catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "User Successfully Logged-in";
		return dataResponse.toString();
	}
	@ResponseBody
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
