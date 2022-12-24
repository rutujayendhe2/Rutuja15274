package com.training.CakeApp.controller;

import java.util.Date;
import java.util.Set;

import com.training.CakeApp.modal.Order;
import com.training.CakeApp.modal.Product;

public  class OrderImplementation extends CakeAppCollection<Order> {

	private static OrderImplementation orderImplement;
	
	public static OrderImplementation getOrderObj() {
		
		if (orderImplement == null) {
			synchronized (OrderImplementation.class) {
				if (orderImplement == null) {
					orderImplement = new OrderImplementation();
				}
			}
		}
		return orderImplement;
	}
	{
		Date date = new Date();

		collection.add(new Order(101,1000,1001,"Strawberry",date,1,200.0,200.0));
		collection.add(new Order(102,1000,1001,"Almond Cake",date,1,200.0,200.0));
		collection.add(new Order(103,1000,1001,"Red velvet",date,1,200.0,200.0));

	}
	
	@Override
	public Set<Order> getList() {
		return collection;
	}

	@Override
	public String createNew(Order order) {
		if (collection.add(order)) {
			return "Created new order" + order;
		}
		else {
			return "error while creating new order";
		}
	}

	@Override
	public String updateentityById(int entityId, Order entity) {
		for(Order order : collection) {
			if(order.getOrderId()== entityId) {
				order.setProductId(entity.getProductId());
				order.setCustomerId(entity.getCustomerId());
				order.setProductName(entity.getProductName());
				order.setOrderDate(entity.getOrderDate());
				order.setQuantity(entity.getQuantity());
				order.setPrice(entity.getPrice());
				
				return "Order updated Successfully";
			}	
		}
		return null;
	
	}

	@Override
	public String deletebyId(int entityId) {
			for(Order order: collection) {
				if(order.getOrderId()== entityId) {
					collection.remove(order);
					return "Order Deleted";
				}
			}
			return "Order Not Found";
		}
		
	

	@Override
	public Order findById(int orderId) {
		for(Order order:collection) {
			if(order.getOrderId()==orderId) {
				return order;
			}
		}
		return null;
	}
	
}