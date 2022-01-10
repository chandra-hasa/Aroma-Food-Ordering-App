package com.backend.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.Cart;
import com.backend.models.User;
import com.backend.repositories.CartRepository;
import com.backend.repositories.UserRepository;


@RestController
@RequestMapping("/api/food")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserRepository uRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	
	@PostMapping(value="/add/user")
	public User addUser(@RequestBody User user) {
		
		Cart cart=new Cart();
		cart.setUser(user);
		uRepo.save(user);
		cartRepo.save(cart);
		return user;
	}
	
	@PutMapping(value="/update/user")
	public User editUser(@RequestBody User user ) {
		return uRepo.save(user);
		
	}
	
	@GetMapping(value="get/user/{id}")
	public  Optional<User> getUser(@PathVariable int id){
		return uRepo.findById(id);
		
	}
	
	
	
	

}
