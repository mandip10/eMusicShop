package com.emusicshop.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicshop.dao.ProductDao;
import com.emusicshop.model.Product;

@Controller
public class HomeController {
	
	//private Path path;
	
	@Autowired
	private ProductDao productDao;
	//ProductService productService;
	//ProductDao productDao;
	
	
	@RequestMapping({"/","/home","/index"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getProducts(Model model){
		//List<Product> productList = productDao.getProductList(); //For one product
		//Product product = productList.get(0); //For one product
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products",products);
		
		return "productList";
	}
	
	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable Long productId, Model model) throws IOException{
		
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);
		
		return "viewProduct";
	}
	
}
