package com.usecase.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.mortgage.model.Offer;

@Service
public interface OfferService {

	public List<Offer> getAllOffers();

	public List<Offer> getEligibleOffers(double offerValue);

}
