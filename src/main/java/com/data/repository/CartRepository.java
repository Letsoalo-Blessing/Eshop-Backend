package com.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	Optional<Cart> findByName(String name);
}
