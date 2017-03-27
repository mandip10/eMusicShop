package com.emusicshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emusicshop.model.Customer;
import com.emusicshop.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	/*
	 * public String getCart(@AuthenticationPrincipal User activeUser){ Customer
	 * customer = customerService.getCustomerByUsername
	 * (activeUser.getUsername()); int cartId = customer.getCart().getCartId();
	 * return "redirect:/customer/cart/"+cartId; }
	 */
	public String getCart(ModelMap model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		Customer customer = customerService.getCustomerByUsername(name);
		int cartId = customer.getCart().getCartId();
		 return "redirect:/customer/cart/"+cartId;
	}

	@RequestMapping("/{cartId}")
	public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
		model.addAttribute("cartId", cartId);

		return "cart";
	}

}
