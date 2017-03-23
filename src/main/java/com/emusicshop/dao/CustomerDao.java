package com.emusicshop.dao;

import java.util.List;

import com.emusicshop.model.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);
	
	Customer getCustomerById(int customerId);
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);

}
