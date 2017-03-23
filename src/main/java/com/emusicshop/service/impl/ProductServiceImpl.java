package com.emusicshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emusicshop.dao.ProductDao;
import com.emusicshop.model.Product;
import com.emusicshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productDao;
	

	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	public void editProduct(Product product) {
		productDao.editProduct(product);
	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

}
