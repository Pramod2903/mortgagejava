 package com.usecase.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.mortgage.model.Property;

public interface PropertyRepositoryTest extends JpaRepository<Property,Long>{

}
