package com.usecase.mortgage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.usecase.mortgage.model.Property;
import com.usecase.mortgage.repository.PropertyRepository;

public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyRepo;

	@Override
	public Property addProperty(Property property) {
		return propertyRepo.save(property);
	}

	@Override
	public List<Property> addProperties(List<Property> properties) {
		return propertyRepo.saveAll(properties);
	}

}
