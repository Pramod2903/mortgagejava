package com.usecase.mortgage.service;

import com.usecase.mortgage.model.User;

public interface UserService {

	public User createUser(User user);

	public User getUserByUserName(String userName);

}
