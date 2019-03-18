package com.usecase.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.mortgage.model.Property;

@Service
public interface PropertyService {

	public Property addProperty(Property property);

	public List<Property> addProperties(List<Property> properties);

}
