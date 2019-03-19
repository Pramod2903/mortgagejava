package com.usecase.mortgage.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.mortgage.model.Offer;

@Service
public interface OfferService {

	public List<Offer> getAllOffers() throws Exception;

	public List<Offer> getEligibleOffers(double offerValue);

}
