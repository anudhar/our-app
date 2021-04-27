package com.cg.controllerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.OurAppApplication;
import com.cg.model.User;

@SpringBootTest(classes = OurAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getBootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testRegisterUser() {
		User user = new User();
		user.setUsername("Anudhar");
		user.setFirstName("Anudhar");
		user.setLastName("M S");
		user.setEmailId("anudhar@gmail.com");
		user.setPhoneNumber("987654321");
		user.setPassword("Anu123");
		ResponseEntity<?> postResponse=restTemplate.postForEntity(getBootUrl()+"/user/register", user, User.class);
		assertNotNull(postResponse);
		//assertNotNull(postResponse.getBody());
	}
}

