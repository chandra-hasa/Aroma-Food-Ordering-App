package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.models.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

}
