package com.emusicshop.dao;

import com.emusicshop.model.Cart;

public interface CartDao {
	
	Cart create(Cart cart);
	
	Cart read(String cartId);
	
	void update(String cartId, Cart cart);
	
	void delete(String cartId);

}
