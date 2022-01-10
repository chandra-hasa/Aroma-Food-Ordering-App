	package com.backend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="foodItem_db")
public class FoodItem {
	
	@Id
	@SequenceGenerator(name = "foodItemid_gen", sequenceName = "foodItemId", initialValue = 40001, allocationSize = 2)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="foodItemid_gen")
	private long foodItemId;
	private String foodItemName;
	private String description;
	
//	private int quantity;
	
	private double price;
	
	
	private String foodItemImage;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(
			name="cart_foodItem",
			joinColumns= {@JoinColumn(name="foodItemId")},
			inverseJoinColumns= { @JoinColumn(name="cartId")}
			)
	Set<Cart> carts=new HashSet<>();
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(
			name="category_foodItem",
			joinColumns= {@JoinColumn(name="foodItemId")},
			inverseJoinColumns= { @JoinColumn(name="categoryId")}
			)
	

	public Set<Cart> getCarts() {
		return carts;
	}


	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}


	public long getFoodItemId() {
		return foodItemId;
	}

	public void setFoodItemId(long foodItemId) {
		this.foodItemId = foodItemId;
	}


	public String getFoodItemName() {
		return foodItemName;
	}


	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


//	public int getQuantity() {
//		return quantity;
//	}
//
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getFoodItemImage() {
		return foodItemImage;
	}


	public void setFoodItemImage(String foodItemImage) {
		this.foodItemImage = foodItemImage;
	}
}
