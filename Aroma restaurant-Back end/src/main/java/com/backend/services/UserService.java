package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.models.User;
import com.backend.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	public User login(String password,String username) {
		User user=uRepo.findByPasswordAndUsername(password,username);
		System.out.println("Service "+user);
		return user;
		
	}

}
