package com.usecase.mortgage.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.usecase.mortgage.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void tset() throws Exception{
		User user = new User();
		user.setName("Test");
		user.setUserName("Test23");
		user.setPassword("p@ssWord245");
		user.setPan("BVC5578G");
		entityManager.persist(user);		
		assertThat(user.getName()).isEqualTo("Test");		
	}
}
