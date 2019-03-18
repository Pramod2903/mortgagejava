package com.usecase.mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.mortgage.model.SqftPrice;

@Repository
public interface SqftRepository extends JpaRepository<SqftPrice, Long> {

	public Optional<SqftPrice> findByPincode(Long pincode);
}
