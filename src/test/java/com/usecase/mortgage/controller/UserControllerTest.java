package com.usecase.mortgage.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usecase.mortgage.model.Property;
import com.usecase.mortgage.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	@Autowired
	UserController userController;	
	@Test
	public void createCustomerTest() throws Exception {
		
		List<Property> propertyDetails = new ArrayList<>();
		User user = new User();
		user.setUserName("Suresh123");
		user.setAltIncomee(20000);
		user.setDob(new Date());
		user.setEmail("abc.gmail.com");
		user.setGender("Male");
		user.setName("Suresh");
		user.setCpassword("Suresh");
		user.setId(100L);
		user.setOtherIncome(10000);
		user.setPhone(9010101010L);
		user.setSalary(50000);
		user.setPassword("Suresh");
		user.setPan("ABC18");
		// user.setProperty(propertyDetails);
		user.setProperties(propertyDetails);
		
		User userRes = userController.createUser(user).getBody();
		//assertEquals(user, userRes);
		assertNotNull(userRes.getId());
		
	}
	@Test
	public void getcustomerTest() throws Exception{
		
		User userdetails=(User) userController.getUser("shivu").getBody();
		assertEquals("shivu", userdetails.getUserName());
	}
	

}
