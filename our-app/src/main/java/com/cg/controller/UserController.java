package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.UserAlreadyExistsException;
import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws UserAlreadyExistsException, UserNotFoundException {
		try {
		User user1 = userService.findByEmailId(user.getEmailId());
		if(user1==null) {
			return userService.registerUser(user);
		}else {
			throw new UserAlreadyExistsException("User Already Exists");
		}
		
		}catch(UserAlreadyExistsException e) {
			e.getMessage();
		}
		return null;
	}

	@GetMapping("/login/{email_id}/{password}")
	public String loginUser( @PathVariable(value="email_id") String emailId, @PathVariable(value="password") String password) throws UserNotFoundException {
		User user = userService.findByEmailId(emailId);
		String status="invalid Password";
		try {
			if(user!=null) {
				if(user.getPassword().equals(password)) {
					status="valid";
					return status;
				}else {
					return status;
				}
			}else {
				throw new UserNotFoundException("Incorrect email Id");
			}
		}catch(UserNotFoundException e) {
			e.getMessage();
		}
		return status;
	}

	@GetMapping("/{email_id}")
	public ResponseEntity<User> findByEmailId(@PathVariable(value= "email_id") String emailId) throws UserNotFoundException {
		User user = userService.findByEmailId(emailId);
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/update/{email_id}")
	public ResponseEntity<User> updatePassword(@PathVariable(value = "email_id") String emailId, @RequestBody String password) throws UserNotFoundException {
		User u = userService.findByEmailId(emailId);
		u.setPassword(password);
		User updatedUser = userService.updatePassword(u);
		return ResponseEntity.ok(updatedUser);
	}
}
