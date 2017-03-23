package com.emusicshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusicshop.model.Cart;
import com.emusicshop.model.CartItem;
import com.emusicshop.model.Customer;
import com.emusicshop.model.Product;
import com.emusicshop.service.CartItemService;
import com.emusicshop.service.CartService;
import com.emusicshop.service.CustomerService;
import com.emusicshop.service.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {
	
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/{cartId}")
	public @ResponseBody
	Cart getCartById (@PathVariable(value="cartId") int cartId){
		return cartService.getCartById(cartId);
	}
	
	@RequestMapping(value="/add/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value="productId") int productId, ModelMap model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Customer customer = customerService.getCustomerByUsername(name);
		//Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItems();
		
		for(int i=0; i<cartItems.size();i++){
			if(product.getProductId()==cartItems.get(i).getProduct().getProductId()){
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity()+1);
				cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
				
				return;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}
	
	@RequestMapping(value="/remove/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value="productId") int productId){
		CartItem cartItem=cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}
	
	@RequestMapping(value="/{cartId}",method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value="cartId") int cartId){
		Cart cart=cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
	public void handleClientErrors(Exception e){}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
	public void handleServerErrors(Exception e){}

}
