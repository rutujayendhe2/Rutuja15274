package com.training.cakeapp.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


public class Orders {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int orderId;
		private Date orderDate;

		@OneToOne(cascade = CascadeType.ALL)
		private Customer customer;
		@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
		
		private List<OrderItem> orderItems = new ArrayList<OrderItem>();

		public Orders() {
			super();
		}

		public Orders(Date orderDate, Customer customer, List<OrderItem> orderItems) {
			super();
			this.orderDate = orderDate;
			this.customer = customer;
			this.orderItems = orderItems;
		}

		public Orders(int orderId, Date orderDate, Customer customer, List<OrderItem> orderItems) {
			super();
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.customer = customer;
			this.orderItems = orderItems;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}

		@Override
		public String toString() {
			return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", customer=" + customer + ", orderItems="
					+ orderItems + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(customer, orderDate, orderId, orderItems);
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
			return Objects.equals(customer, other.customer) && Objects.equals(orderDate, other.orderDate)
					&& orderId == other.orderId && Objects.equals(orderItems, other.orderItems);
		}

	
}
