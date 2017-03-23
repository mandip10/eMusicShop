package com.emusicshop.service;

import com.emusicshop.model.Cart;
import com.emusicshop.model.CartItem;

public interface CartItemService {
	
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItem getCartItemByProductId(int productId);
}
