package com.backend.models;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="cart_db")
public class Cart {
	
	@Id
	@SequenceGenerator(name = "cartid_gen", sequenceName = "cartId", initialValue = 202001, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="cartid_gen")
	private long cartId;
	
	
//	@ManyToOne
//	@JoinColumn(name="FoodItemId",nullable=false)
//	private FoodItem item;
	

	
	private double totalPrice;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	@ManyToMany(mappedBy="carts")
	private Set<FoodItem> foodItems = new HashSet<>();
	  
	@OneToOne()
	private User user;
	
	private int quantity;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user=user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public double getTotalPrice() {
		for(FoodItem item: this.foodItems) {
			totalPrice+=item.getPrice();
		}
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(Set<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}


	
	}

//	public FoodItem getFoodItem() {
//		return foodItem;
//	}
//
//	public void setFoodItem(FoodItem foodItem) {
//		this.foodItem = foodItem;
//	}
	
	
	
	
	

