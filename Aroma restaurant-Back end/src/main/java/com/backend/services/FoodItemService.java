package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.models.FoodItem;
import com.backend.repositories.FoodItemRepository;


@Service
public class FoodItemService {
	
	@Autowired
	private FoodItemRepository foodRepo;
	
	public FoodItem getById(long foodId) {
		return foodRepo.getById(foodId);
	}
	
	

}
