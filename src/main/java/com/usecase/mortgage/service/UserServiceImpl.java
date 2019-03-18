package com.usecase.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.mortgage.exceptions.UserNotFoundException;
import com.usecase.mortgage.model.User;
import com.usecase.mortgage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User getUserByUserName(String userName) {
		return userRepository.findByUserName(userName)
				.orElseThrow(()->new UserNotFoundException("No User found with username :"+userName));
	}
	
	
}
