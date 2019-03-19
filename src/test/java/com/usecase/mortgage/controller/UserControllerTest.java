package com.usecase.mortgage.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usecase.mortgage.model.Property;
import com.usecase.mortgage.model.User;
import com.usecase.mortgage.repository.UserRepository;
import com.usecase.mortgage.service.UserService;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = UserController.class, secure = false)
@SpringBootTest
public class UserControllerTest {
	@Autowired
	UserController userController;
	
	/*

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;
	@MockBean
	UserRepository userRepo;

	private ObjectMapper mapper = new ObjectMapper();

	private String parseToJsonString(Object object) {
		String json = "";
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	@Test
	public void getCustomerTest() throws Exception {

		List<Property> propertyDetails = new ArrayList<>();
		User user = new User();

		
		 * Property p= new Property();
		 * 
		 * p.setPropertyName("Builder"); p.setAddress("Bangalore"); p.setArea(1000.00);
		 * p.setId(1000L); p.setPincode(510000L); p.setType("Home");
		 * 
		 * Property p1= new Property(); p1.setPropertyName("Builder1");
		 * p1.setAddress("akjl"); p1.setArea(4000.00); p1.setId(1002L);
		 * p1.setPincode(610000L); p1.setType("Rent");
		 * 
		 * Property p2= new Property(); p2.setPropertyName("Builder2");
		 * p2.setAddress("Bangalore"); p.setArea(1000.00); p.setId(1000L);
		 * p.setPincode(510000L); p.setType("Home");
		 * 
		 * propertyDetails.add(p); propertyDetails.add(p1); propertyDetails.add(p2);
		 

		user.setUserName("Suresh123");
		user.setAltIncomee(20000);
		user.setDob(null);
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

		Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

		
		 * RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
		 * "/mortgage/api/user").accept( MediaType.APPLICATION_JSON);
		 
		String expected = this.parseToJsonString(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/mortgage/api/user/")
				.accept(MediaType.APPLICATION_JSON).content(expected).contentType(MediaType.APPLICATION_JSON);

		System.out.println("==========================================");
		System.out.println(expected);
		System.out.println("==========================================");
		// System.out.println(result.getResponse());
		System.out.println("==========================================");

		// JSONAssert.assertEquals(expected, result.getResponse()
		// .getContentAsString(), false);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		System.out.println(response);
		// JSONAssert.assertEquals(expected, result.getResponse()
		// .getContentAsString(), false);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost:3306/mortgage/api/user/", response.getHeader(HttpHeaders.LOCATION));

	}

*/
	
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
