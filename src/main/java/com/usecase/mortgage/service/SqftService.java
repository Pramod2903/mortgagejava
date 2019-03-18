package com.usecase.mortgage.service;

import org.springframework.stereotype.Service;

import com.usecase.mortgage.model.SqftPrice;

@Service
public interface SqftService {

	public SqftPrice getSqftValue(Long pincode) throws Exception;

}
