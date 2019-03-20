package com.usecase.mortgage.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.usecase.mortgage.model.User;
import com.usecase.mortgage.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	private User user = new User("testuser","password","kumar");
	
	@Test
	public void testUserReistration(){
		
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		
		Assert.assertEquals(userService.createUser(user), user);
		
	}
	
	@Test
	public void testFetchUserByUserName(){
		Optional<User> optionalUser = Optional.of(user);
		Mockito.when(userRepository.findByUserName(Mockito.anyString())).thenReturn(optionalUser);
		
		Assert.assertEquals(userService.getUserByUserName("testuser"), optionalUser.get());
		
	}
	
}
