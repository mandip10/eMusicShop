package com.emusicshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicshop.dao.CustomerOrderDao;
import com.emusicshop.model.Cart;
import com.emusicshop.model.CartItem;
import com.emusicshop.model.CustomerOrder;
import com.emusicshop.service.CartService;
import com.emusicshop.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{
	
	@Autowired
	public CustomerOrderDao customerOrderDao;
	
	@Autowired
	private CartService cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder){
		customerOrderDao.addCustomerOrder(customerOrder);
	}
	
	public double getCustomerOrderGrandTotal(int cartId){
		double grandTotal=0;
		Cart cart=cartService.getCartById(cartId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(CartItem item : cartItems){
			grandTotal += item.getTotalPrice();
		}
		
		return grandTotal;
	}
	
}
