package com.cakeapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cakeapp.model.Product;

public class OrderItemData {
	
	private static final long SerialVersionUID = 10l;

	private Long itemId;
	private Product product;
	@NotEmpty
	@Size(min = 5, message = "quantity select 1 to 5")
	private int quantity;

	public OrderItemData() {
		super();
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
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

	@Override
	public String toString() {
		return "OrderItemData [itemId=" + itemId + ", product=" + product + ", quantity=" + quantity + "]";
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
		
	}

}
