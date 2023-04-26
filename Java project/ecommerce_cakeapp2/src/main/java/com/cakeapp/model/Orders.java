package com.cakeapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private Date date;
	
	@OneToOne(cascade = CascadeType.ALL )
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL )
	private List<OrderItem> orderItem;

	public Orders() {
		super();
	}

	public Orders(Date date, Customer customer, List<OrderItem> orderItem) {
		super();
		this.date = date;
		this.customer = customer;
		this.orderItem = orderItem;
	}

	public Orders(int orderId, Date date, Customer customer, List<OrderItem> orderItem) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.customer = customer;
		this.orderItem = orderItem;
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
		return "Order [orderId=" + orderId + ", date=" + date + ", customer=" + customer + ", orderItem=" + orderItem
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
