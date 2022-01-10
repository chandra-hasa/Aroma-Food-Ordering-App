package com.backend.controllers;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.models.Cart;
import com.backend.models.FoodItem;
import com.backend.services.CartService;
import com.backend.services.FoodItemService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/food")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private FoodItemService foodService;
	
	@GetMapping(value="/get/cart/{id}")
	public Cart getCartDetails(@PathVariable long id){
		
		return cartService.getCart(id); 
		
	}
	
	@PostMapping(value="/add/cart/{userId}/{foodId}")
	public Cart addToCart(@PathVariable int userId, @PathVariable long foodId) {
		Cart cart=cartService.getCartByUser(userId );
		System.out.println(cart.getCartId());
		
		Set<FoodItem> list= new HashSet<>();
		list.add(foodService.getById(foodId));
		cart.setFoodItems(list);
		return cartService.addCart(cart);
	}
	
	@PutMapping(value="update/cart")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartService.updateCart(cart);
	}
	
	@DeleteMapping(value="delete/cart/{id}")
	public ResponseEntity<HttpStatus> deleteCart(@PathVariable long id){
		cartService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
