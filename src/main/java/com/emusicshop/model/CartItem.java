package com.emusicshop.model;

//@Entity
public class CartItem /*implements Serializable*/{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 6898602563168644797L;
	private Product product;
	private int quantity;
	private double totalPrice;
	
	public CartItem(){}
	
	

	public CartItem(Product product) {
		//super();
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getProductPrice();
	}



	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}	

}
