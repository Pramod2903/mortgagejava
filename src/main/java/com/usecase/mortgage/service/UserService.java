package com.usecase.mortgage.service;

import java.util.List;
import java.util.Map;

import com.usecase.mortgage.model.Offer;
import com.usecase.mortgage.model.User;

public interface UserService {

	public User createUser(User user);

	public User getUserByUserName(String userName);

	public void updateUser(User user);

	public Map<Long, List<Offer>> getOffers(String userName) throws Exception;

	public List<User> getAllUsers();

}
