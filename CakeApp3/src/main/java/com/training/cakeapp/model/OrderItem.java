package com.training.cakeapp.model;

public class OrderItem {
	
	private  int itemId;
	private Product product;
	private int quantity;
	private double itemTotalPrice;
	private static int counter = 100;

	
	
	public OrderItem() {
		super();
	}

	public OrderItem(Product product, int quantity, double itemTotalPrice) {
		super();
		this.itemId = counter++;
		this.product = product;
		this.quantity = quantity;
		this.itemTotalPrice = itemTotalPrice;
	}

	public OrderItem(int itemId, Product product, int quantity, double itemTotalPrice) {
		super();
		this.itemId = itemId;
		this.product = product;
		this.quantity = quantity;
		this.itemTotalPrice = itemTotalPrice;
	}
	
	public  int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	public double getItemTotalPrice() {
		return product.getPrice()*quantity ;
	}

	public int getProductId() {
		return product.getProductId();
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", product=" + product + ", quantity=" + quantity + ", itemTotalPrice="
				+ itemTotalPrice + "]";
	}

	
}
