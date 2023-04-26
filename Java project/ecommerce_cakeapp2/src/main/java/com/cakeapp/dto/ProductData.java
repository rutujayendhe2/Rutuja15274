package com.cakeapp.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

public class ProductData {

	private static final long SerialVersionUID = 10l;

	private Long productId;
	@NotEmpty(message = "Product name is required")
	private String productName;
	@DecimalMax("900.0") @DecimalMin("100.0") 
	private double price;
	@NotEmpty(message = "Product weight is required")
	private String weight;
	@NotEmpty(message = "Product image is required")
	private String imageUrl;

	public ProductData() {
		//TODO Auto-generated constructor stub
	}

	public ProductData(Long productId, String productName, double price, String weight, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.imageUrl = imageUrl;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
		
	}


}
