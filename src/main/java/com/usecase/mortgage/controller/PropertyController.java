package com.usecase.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.mortgage.model.Property;
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
	
	@PostMapping
	public ResponseEntity<Property> addProperty(@RequestBody Property property){
		return new ResponseEntity<Property>(propertyService.addProperty(property),HttpStatus.CREATED);
		
	}
	
	@PostMapping("/addProperties")
	public ResponseEntity<List<Property>> addProperties(@RequestBody List<Property> properties){
		return new ResponseEntity<List<Property>>(propertyService.addProperties(properties),HttpStatus.CREATED);
		
	}

}