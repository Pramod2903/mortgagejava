package com.usecase.mortgage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.mortgage.exceptions.InvalidPincodeException;
import com.usecase.mortgage.model.SqftPrice;
import com.usecase.mortgage.repository.SqftRepository;

@Service
public class SqftServiceImpl implements SqftService {
	
	@Autowired
	SqftRepository sqftRepo;
	
	
	@Override
	public SqftPrice getSqftValue(Long pincode) throws InvalidPincodeException {
		return sqftRepo.findByPincode(pincode).orElseThrow(()->new InvalidPincodeException("Invalid Pincode"));
	}
	
}
