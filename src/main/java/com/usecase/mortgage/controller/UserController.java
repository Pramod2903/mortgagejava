package com.usecase.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.mortgage.model.User;
import com.usecase.mortgage.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User persistUser = userService.createUser(user);
		return new ResponseEntity<>(persistUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userName")
	public ResponseEntity<User> getUser(@PathVariable(value="userName") String userName){
		User user = userService.getUserByUserName(userName);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}

}
