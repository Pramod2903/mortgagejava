package com.usecase.mortgage.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.usecase.mortgage.model.User;
import com.usecase.mortgage.service.UserService;



@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
public class TestUserController {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;
	
	User mockUser = new User("testuser123","pwd","TestUser");
	List<User> userList = new ArrayList<User>();
	
	@Test
	public void retrieveUserDetails() throws Exception {

		Mockito.when(
				userService.getUserByUserName(Mockito.anyString())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/user/testuser123").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{\"id\":null,\"properties\":[],\"name\":\"TestUser\",\"userName\":\"testuser123\",\"password\":\"pwd\",\"cpassword\":null,\"phone\":null,\"email\":null,\"dob\":null,\"gender\":null,\"pan\":null,\"salary\":0.0,\"altIncomee\":0.0,\"otherIncome\":0.0}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void retrieveUsers() throws Exception {

		Mockito.when(
				userService.getAllUsers()).thenReturn(userList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/user").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void createUser() throws Exception {
		String expected = "{\"id\":null,\"properties\":[],\"name\":\"TestUser\",\"userName\":\"testuser123\",\"password\":\"pwd\",\"cpassword\":null,\"phone\":null,\"email\":null,\"dob\":null,\"gender\":null,\"pan\":null,\"salary\":0.0,\"altIncomee\":0.0,\"otherIncome\":0.0}";
		String postContent = "{\"name\":\"TestUser\",\"userName\":\"testuser123\",\"password\":\"pwd\"}";
		Mockito.when(
				userService.createUser(Mockito.any(User.class))).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
										.post("/api/user")
										.accept(MediaType.APPLICATION_JSON)
										.content(postContent)
										.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder)
			   .andExpect(MockMvcResultMatchers.status().isCreated())
			   .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(MockMvcResultMatchers.content().json(expected, false));
	}
	
}
