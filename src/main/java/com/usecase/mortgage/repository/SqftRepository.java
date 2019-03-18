package com.usecase.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.mortgage.model.SqftPrice;

@Repository
public interface SqftRepository extends JpaRepository<SqftPrice, Long> {

}
