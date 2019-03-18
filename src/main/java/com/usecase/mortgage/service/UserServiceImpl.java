package com.usecase.mortgage.service;

import java.util.List;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.mortgage.exceptions.UserNotFoundException;
import com.usecase.mortgage.model.Property;
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
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
	
	public void getOffers(String userName) {
		User user = userRepository.findByUserName(userName)
				.orElseThrow(()->new UserNotFoundException("No User found with username :"+userName));
		Double baseAmount = (user.getSalary() + user.getOtherIncome()+user.getAltIncomee())*0.4;
		
		List<Property> props = user.getProperties();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = user.getDob().toInstant();		
		Period period = Period.between(LocalDate.now(), instant.atZone(defaultZoneId).toLocalDate());
		if(period.getYears()>60 || baseAmount <15000){
			//return null;
		}
		
		for(Property prop : props) {
			//prop.getPincode()
			
			
		}
		
		
		
	}
	
	
}
