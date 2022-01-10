package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.models.Cart;
import com.backend.repositories.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepo;
	
	public Cart getCart(long cartId) {
		return cartRepo.getById(cartId);
	}
	
	public Cart addCart(Cart cart) {
		return cartRepo.save(cart);
	}

	public Cart updateCart(Cart cart) {
		return cartRepo.save(cart);
	}

	public void delete(long id) {
		cartRepo.deleteById(id);
		
	}
	
	public Cart getCartByUser(int userId) {
		return cartRepo.findByUserUserId(userId);
	}
	

}
