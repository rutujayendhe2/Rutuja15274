package com.training.CakeApp.modal;

public abstract class Product {

	private int productId;
	private String productName;
	private Double price;
	private String weight;
	private String imageUrl;
	private static int counter=1000;
	private static final String Cakeshop_NAME="Ecake Shop";

public Product() {
	super();
}

public Product(String productName, double price, String weight, String imageUrl) {
	super();
	this.productId=counter++;
	this.productName = productName;
	this.price = price;
	this.weight =weight;
	this.imageUrl= imageUrl;
}

public Product(int productId, String productName, double price, String weight, String imageUrl) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.price = price;
	this.weight =weight;
	this.imageUrl= imageUrl;
}

public int getproductId() {
	return productId;
}

public void setproductId(int productId) {
	this.productId = productId;
}

public String getproductName() {
	return productName;
}

public void setproductName(String productName) {
	this.productName = productName;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getweight() {
	return weight;
}

public void setweight(String weight) {
	this.weight = weight;
}

public String getimageUrl() {
	return imageUrl;
}

public void setimageUrl(String imageUrl) {
	 this.imageUrl = imageUrl;

}

@Override
public String toString() {
	return Cakeshop_NAME+" has Product [productId=" + productId + ", productName=" + productName +  ", price=" + price + ",weight="+ weight + ",imageUrl="+ imageUrl +"]";
}

}
