package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
		Cart findByUserUserId(int userId);

}
