package com.usecase.mortgage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.mortgage.exceptions.UserNotFoundException;
import com.usecase.mortgage.model.Offer;
import com.usecase.mortgage.model.Property;
import com.usecase.mortgage.model.User;
import com.usecase.mortgage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	SqftService sqftService;
	@Autowired
	OfferService offerService;
	
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
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public Map<Long, List<Offer>> getOffers(String userName) throws Exception {
		Map<Long, List<Offer>> offers = new HashMap();
		User user = userRepository.findByUserName(userName)
				.orElseThrow(()->new UserNotFoundException("No User found with username :"+userName));
		Double baseAmount = (user.getSalary() + user.getOtherIncome()+user.getAltIncomee())*0.4;
		
		List<Property> props = user.getProperties();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		System.out.println("============================");
		System.out.println((java.sql.Date)user.getDob());
		//Instant instant = ((java.sql.Date)user.getDob()).toLocalDate()
		Period period = Period.between(LocalDate.now(),((java.sql.Date)user.getDob()).toLocalDate());
		//Period period = Period.between(LocalDate.now(), instant.atZone(defaultZoneId).toLocalDate());
		if(period.getYears()>60 || baseAmount <15000){
			//return null;
		}
		offerService.getAllOffers();
		for(Property prop : props) {
			Double propValue = prop.getArea() * sqftService.getSqftValue(prop.getPincode()).getValue();
			
			Double offerValue = propValue*0.6;
			offers.put(prop.getId(), offerValue<1000000 ? null : offerService.getEligibleOffers(offerValue));
			
		}
		return offers;
		
		
	}
	
	
}
