package com.emusicshop.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emusicshop.dao.ProductDao;
import com.emusicshop.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	public void editProduct(Product product){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	public Product getProductById(Long productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, productId);
		session.flush();
		return product;
	}
	
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");
		List<Product> products = query.list();
		session.flush();
		return products;
	}
	
	public void deleteProduct(Long productId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(productId));
		session.flush();
	}

}
