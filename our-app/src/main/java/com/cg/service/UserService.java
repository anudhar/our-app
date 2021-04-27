package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.UserAlreadyExistsException;
import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepo;
	

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}


	public User registerUser(User user) throws UserAlreadyExistsException{
		return userRepo.save(user);
	}

	public User updatePassword(User user) throws UserNotFoundException {
		return userRepo.save(user);
	}

	public User findByEmailId(String emailId) throws UserNotFoundException {
		return userRepo.findByEmailId(emailId);
	}


}