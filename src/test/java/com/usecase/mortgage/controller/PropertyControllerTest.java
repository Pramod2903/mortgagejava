package com.usecase.mortgage.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import com.usecase.mortgage.model.Property;
import com.usecase.mortgage.model.User;
import com.usecase.mortgage.service.PropertyService;
import com.usecase.mortgage.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PropertyController.class)
public class PropertyControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;
	
	@MockBean
	private PropertyService propertyService;
	
	private User user =new User("","","");
	
	private Property property = new Property("Lake View Villa", "House", 2800, 560100L, "15-8-32/A, 15th Avenu, Lake Front, Bangalore, India");
	
	
	@Test
	public void testPropertyCreation() throws Exception{
		Mockito.when(userService.getUserByUserName(Mockito.anyString())).thenReturn(user);
		Mockito.when(propertyService.addProperty(Mockito.any(Property.class))).thenReturn(property);
		String content = "{\"propertyName\":\"Lake View Villa\",\"type\":\"House\",\"area\":2800,\"pincode\":560100,\"address\":\"15-8-32/A, 15th Avenu, Lake Front, Bangalore, India\"}";
		String expected = "{\"id\":null,\"propertyName\":\"Lake View Villa\",\"type\":\"House\",\"area\":2800,\"pincode\":560100,\"address\":\"15-8-32/A, 15th Avenu, Lake Front, Bangalore, India\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/properties/suresh")
				.accept(MediaType.APPLICATION_JSON)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
			   .andExpect(MockMvcResultMatchers.status().isCreated())
			   .andExpect(MockMvcResultMatchers.content().json(expected, false));
	}
	
	@Test
	public void testPropertiesCreation() throws Exception{
		List<Property> propsList = new ArrayList<>();
		propsList.add(property);
		Mockito.when(userService.getUserByUserName(Mockito.anyString())).thenReturn(user);
		Mockito.when(propertyService.addProperties(Mockito.any())).thenReturn(propsList);
		String content = "[{\"propertyName\":\"Lake View Villa\",\"type\":\"House\",\"area\":2800,\"pincode\":560100,\"address\":\"15-8-32/A, 15th Avenu, Lake Front, Bangalore, India\"}]";
		String expected = "[{\"id\":null,\"propertyName\":\"Lake View Villa\",\"type\":\"House\",\"area\":2800,\"pincode\":560100,\"address\":\"15-8-32/A, 15th Avenu, Lake Front, Bangalore, India\"}]";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/properties/addProperties/suresh")
				.accept(MediaType.APPLICATION_JSON)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
			   .andExpect(MockMvcResultMatchers.status().isCreated())
			   .andExpect(MockMvcResultMatchers.content().json(expected, false));
	}
}
