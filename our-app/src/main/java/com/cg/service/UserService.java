package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


	public User registerUser(User user){
		return userRepo.save(user);
	}

	public User updatePassword(User user) {
		return userRepo.save(user);
	}

	public User findByEmailId(String emailId) {
		return userRepo.findByEmailId(emailId);
	}


}