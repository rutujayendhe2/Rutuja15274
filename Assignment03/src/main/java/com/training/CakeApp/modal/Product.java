package com.training.CakeApp.modal;

public class Product {

	private int productId;
	private String productName;
	private Double price;
	private String weight;
	private String imageUrl;
	private int quantity;
	private static int counter=1000;
	
	
	
	public Product() {
		super();
	}

	public Product(String productName, Double price, String weight, String imageUrl, int quantity) {
		super();
		this.productId = counter++;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
	}
	
	public Product(int productId, String productName, Double price, String weight, String imageUrl, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", weight="
				+ weight + ", imageUrl=" + imageUrl + ", quantity=" + quantity + "]";
	}

	
	
	
	
}
