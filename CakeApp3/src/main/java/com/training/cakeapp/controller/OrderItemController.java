package com.training.cakeapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.model.OrderItem;

public class OrderItemController implements IOrderItemController<OrderItem> {

	private static OrderItemController orderItemController;
	private static OrderItemCollection collection;
	
	public static OrderItemController getOrderItemController() {
		if(orderItemController==null) {
			synchronized (OrderItemController.class) {
				if(orderItemController==null) {
					orderItemController= new OrderItemController();
				}
				
			}
		}
		return orderItemController;
	}

	public OrderItemController() {
		super();
		this.collection=OrderItemCollection.getOrderItemCollection();
	}

	@Override
	public List<OrderItem> findAll() throws SQLException {
		return collection.findAll();
	}

	@Override
	public OrderItem findOne(int id) throws SQLException {
		OrderItem orderItem=collection.findOne(id);
		return orderItem;
	}

	@Override
	public boolean createNew(OrderItem orderItem) throws SQLException {
		return collection.createNew(orderItem);
	}

	@Override
	public boolean findOneAndDelete(int id) throws SQLException {
		return collection.findOneAndDelete(id);
	}

	@Override
	public boolean findOneAndUpdate(int id, OrderItem orderItem) throws SQLException {
		return collection.findOneAndUpdate(id, orderItem);
	}

}
