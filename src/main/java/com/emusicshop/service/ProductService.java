package com.emusicshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emusicshop.model.Product;

@Service
public interface ProductService {

	
	List<Product> getProductList();
	
	Product getProductById(int id);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	void deleteProduct(Product product); 

}
