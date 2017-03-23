package com.emusicshop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicshop.model.Customer;
import com.emusicshop.model.Product;
import com.emusicshop.service.CustomerService;
import com.emusicshop.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
	public String adminPage(){
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String productInventory(Model model){
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		
		return "productInventory";
	}
	
	@RequestMapping("/customer")
	public  String customerManagement(Model model){
		
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);
		return "customerManagement";
	}

}
