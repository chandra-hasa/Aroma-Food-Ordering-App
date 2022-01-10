package com.backend.controllers;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.User;
import com.backend.repositories.UserRepository;
import com.backend.services.UserService;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins="*")
public class UserAuthController {
	
	@Autowired
	UserRepository userRepo;
	
//	@Autowired
//	private JwtUtility jwtUtility;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
	
//	@Autowired
//	private UserSecurityService userSecurityService;
//	
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/user/login")
	public User userLogin(@RequestBody User user) {
		
		User authUser=userService.login(user.getPassword(),user.getUsername());
		
		if(Objects.nonNull(authUser)) {
			System.out.println(authUser.getlName());
			User logged= userRepo.findByUsername(authUser.getUsername());
			User responseUser=new User();
			responseUser.setUserId(logged.getUserId());
			responseUser.setUsername(logged.getUsername());
			return responseUser;
		}
		
		return authUser;
		
		
		
//		try {
//		authenticationManager.authenticate(
//			new UsernamePasswordAuthenticationToken(
//					user.getUsername(),
//					user.getPassword()
//					)
//				
//				);
//		} catch(BadCredentialsException e) {
//			throw new Exception("INVALID_CREDENTIALS",e);
//		}
//		
//		 UserDetails userDetails=userSecurityService.loadUserByUsername(user.getUsername());  
//	
//		 final String token = jwtUtility.generateToken(userDetails);
//		 
	
		
		//return new JwtResponse(token);
		}
	
	@GetMapping(value="/user/logout")
	public ResponseEntity<HttpStatus> userLogout() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
