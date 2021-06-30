package com.data.services;

import java.util.List;

import com.data.models.Cart;

public interface CartService {

	Cart addCartToUser(Cart cart, long idUSer);
	
	void deleteCart(long id);
	
	List<Cart> findCartsForUSer(long idUser);
	
	Cart findCartById(long id);
	
	void removeFromCart(long idCart, long idUser);
	
	Cart findByCartName(String name);
	
}
