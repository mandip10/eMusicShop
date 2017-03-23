package com.emusicshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4050335095435277122L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@NotEmpty(message="(The product name must not be empty.)")
	private String productName;
	private String productCategory;
	private String productDescription;
	
	@Min(value=0,message="(The product price must not be less than zero.)")
	private double productPrice;
	private String productCondition;
	private String productStatus;
	
	@Min(value=0,message="(The product unit must not be less than zero.)")
	private int unitInStock;
	private String productManufacturer;
	
	@Transient
	private MultipartFile productImage;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CartItem> cartItemList;
	
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public String getProductCategory() {
		return productCategory;
	}
	
	
	public String getProductCondition() {
		return productCondition;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public int getProductId() {
		return productId;
	}
	/*public String getProductId() {
	return String.valueOf(productId);
}*/
	public MultipartFile getProductImage() {
		return productImage;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public String getProductName() {
		return productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	
	
	
}
