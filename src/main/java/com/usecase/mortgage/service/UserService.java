package com.usecase.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.mortgage.repository.PropertyRepository;
import com.usecase.mortgage.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PropertyRepository propertyRepository;
	
	
}
