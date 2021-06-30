package com.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.models.Cart;
import com.data.services.CartService;

@RestController
@RequestMapping(value = "/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addCartToUser/{idUser}")
	Cart addCartToUser(@RequestBody Cart cart, @PathVariable long idUSer) {

		return cartService.addCartToUser(cart, idUSer);
	}

	@DeleteMapping("/deleteCart/{id}")
	void deleteCart(@PathVariable long id) {

		cartService.deleteCart(id);
	}

	@GetMapping("/findCartsForUSer/{id}")
	List<Cart> findCartsForUSer(@PathVariable long idUSer) {

		return cartService.findCartsForUSer(idUSer);
	}

	@GetMapping("/findCartBy/{id}")
	Cart findCartById(@PathVariable long id) {
		
		return cartService.findCartById(id);
	}
	
	@DeleteMapping("/removeFromCart/{idCart}/{idUser}")
	Cart findByCartName(@PathVariable String name) {
		
		return cartService.findByCartName(name);
	}
}
