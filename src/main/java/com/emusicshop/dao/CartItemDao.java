package com.emusicshop.dao;

import com.emusicshop.model.Cart;
import com.emusicshop.model.CartItem;

public interface CartItemDao {
	
	void addCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	void removeAllCartItems(Cart cart);

	CartItem getCartItemByProductId(int productId);
}
