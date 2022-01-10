package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByPasswordAndUsername(String password,String username);
	User findByUsername(String username);
	User findByPassword(String password);
}
	
