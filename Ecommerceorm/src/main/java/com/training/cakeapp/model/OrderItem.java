package com.training.cakeapp.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	@ManyToOne
	private Orders orders;
	@OneToOne(cascade = CascadeType.ALL)
	private Product product;
	private int quantity;

	public OrderItem() {
		super();
	}

	public OrderItem(Orders orders, Product product, int quantity) {
		super();
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderItem(int itemId, Orders orders, Product product, int quantity) {
		super();
		this.itemId = itemId;
		this.orders = orders;
		this.product = product;
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", orders=" + orders + ", product=" + product + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, orders, product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return itemId == other.itemId && Objects.equals(orders, other.orders) && Objects.equals(product, other.product)
				&& quantity == other.quantity;
	}

	
}
