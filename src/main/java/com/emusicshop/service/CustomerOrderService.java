package com.emusicshop.service;

import com.emusicshop.model.CustomerOrder;

public interface CustomerOrderService {
	
	void addCustomerOrder(CustomerOrder customerOrder);
	
	double getCustomerOrderGrandTotal(int cartId);
}
