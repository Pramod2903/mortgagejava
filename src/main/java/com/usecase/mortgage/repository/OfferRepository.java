package com.usecase.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.mortgage.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

	List<Offer> findLessThanOrEqualToByLoanAmount(double offerValue);

}
