package com.usecase.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.mortgage.model.Property;
import com.usecase.mortgage.model.User;
import com.usecase.mortgage.service.PropertyService;
import com.usecase.mortgage.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/properties")
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/{userName}")
	public ResponseEntity<Property> addProperty(@RequestBody Property property,@PathVariable String userName){
		Property propertyRes = propertyService.addProperty(property);
		User user = userService.getUserByUserName(userName);
		user.getProperties().add(propertyRes);
		userService.updateUser(user);
		return new ResponseEntity<Property>(propertyRes,HttpStatus.CREATED);
	}
	
	@PostMapping("/addProperties/{userName}")
	public ResponseEntity<List<Property>> addProperties(@RequestBody List<Property> properties,@PathVariable String userName){
		
		List<Property> propertyRes = propertyService.addProperties(properties);
		User user = userService.getUserByUserName(userName);
		user.getProperties().addAll(propertyRes);
		userService.updateUser(user);
		
		return new ResponseEntity<List<Property>>(propertyRes,HttpStatus.CREATED);
		
	}

}