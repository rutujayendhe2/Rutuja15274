package com.training.CakeApp.modal;

import java.util.Date;

public class Order {

	private int orderId;
	private int productId;
	private int customerId;
	private String productName;
	private Date orderDate;
	private int quantity;
	private double price;
	private static int counter =  100;

	public Order() {
		super();
	}
	public Order(int productId, int customerId, String productName, Date orderDate, int quantity, double price) {
		super();
		this.orderId = counter++;
		this.productId = productId;
		this.customerId = customerId;
		this.productName = productName;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.price = price;
	}
	public Order(int orderId, int productId, int customerId, String productName, Date orderDate, int quantity,
			double price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.customerId = customerId;
		this.productName = productName;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", customerId=" + customerId
				+ ", productName=" + productName + ", orderDate=" + orderDate + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
}


