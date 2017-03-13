package com.emusicshop.dao;

import java.util.List;

import com.emusicshop.model.Product;


public interface ProductDao {

	void addProduct(Product product);
	
	void editProduct(Product product);

	Product getProductById(Long productId);

	List<Product> getAllProducts();

	void deleteProduct(Long productId);

}
