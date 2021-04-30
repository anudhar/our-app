package com.cg.controllerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.cg.OurAppApplication;
import com.cg.model.User;

@SpringBootTest(classes = OurAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	void testRegisterUser() {
		User user = new User();
		user.setUsername("Anudhar");
		user.setFirstName("Anudhar");
		user.setLastName("M S");
		user.setEmailId("anudhar@gmail.com");
		user.setPhoneNumber("987654321");
		user.setPassword("Anu123");
		ResponseEntity<?> postResponse=restTemplate.postForEntity(getRootUrl()+"/user/register", user, User.class);
		assertNotNull(postResponse);
		//assertNotNull(postResponse.getBody());
	}
	
	@Test
	void testLoginUser() {
		HttpHeaders header = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, header);
		User user1 = new User("Ashok","Ashok","kumar","ashok@gmail.com","Ashok@123","9876543211");
		user1.setUserId(125L);
		ResponseEntity<String> response = restTemplate.exchange(getRootUrl()+"/user/login/ashok@gmail.com/Ashok@123",HttpMethod.GET, entity, String.class);
		assertNotNull(response.getBody());
	}
}

