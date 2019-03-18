package com.usecase.mortgage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.mortgage.model.Offer;
import com.usecase.mortgage.repository.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {
	
	@Autowired
	OfferRepository offerRepo;
	
	@Override
	public List<Offer> getAllOffers(){
		return offerRepo.findAll();
	}
	
	@Override
	public List<Offer> getEligibleOffers(double offerValue){
		return offerRepo.findLessThanOrEqualToByLoanAmount(offerValue);
	}

}
