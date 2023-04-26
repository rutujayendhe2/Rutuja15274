package com.cakeapp.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import com.cakeapp.model.Customer;
import com.cakeapp.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrdersData {

	private static final long SerialVersionUID = 10l;

	private int orderId;
	 @Past
	    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private Customer customer;
	private List<OrderItem> orderItem;

	public OrdersData() {
		super();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	@Override
	public String toString() {
		return "OrdersData [orderId=" + orderId + ", date=" + date + ", customer=" + customer + ", orderItem="
				+ orderItem + "]";
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
		
	}

}
