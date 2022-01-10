package com.backend.controllers;

import java.util.List;

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

import com.backend.models.FoodItem;
import com.backend.repositories.FoodItemRepository;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins="*")
public class FoodItemController {
	
	@Autowired
	private FoodItemRepository foodRepo;
	
	@PostMapping(value="/add/fooditem")
	public FoodItem addFoodItem(@RequestBody FoodItem item) {
		return foodRepo.save(item);
	}
	
	@PutMapping(value="/update/fooditem")
	public FoodItem updateFoodItem(@RequestBody FoodItem item) {
		return foodRepo.save(item);
	}
	
	@DeleteMapping(value="/delete/food/{id}")
	public ResponseEntity<HttpStatus> deleteFoodItem(@PathVariable long id){
		foodRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/get/fooditems")
	public List<FoodItem> showFoodItems(){
		return foodRepo.findAll();
		
	}

}
