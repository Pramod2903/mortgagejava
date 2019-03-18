package com.usecase.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usecase.mortgage.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	

}
