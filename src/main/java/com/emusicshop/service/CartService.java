package com.emusicshop.service;

import com.emusicshop.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);
	
	
	void update(Cart cart);
}
