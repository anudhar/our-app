package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmailId(String emailId);

	public User findByUsername(String username);
}
