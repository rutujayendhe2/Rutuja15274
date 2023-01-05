package com.training.cakeapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.collection.OrderCollection;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Orders;

public class OrderController implements IController<Orders> {


	private static OrderController orderController;
	private static OrderCollection orderCollection;
	
	public static OrderController getOrderController() {
		if(orderController==null) {
			synchronized (OrderController.class) {
				if(orderController==null) {
					orderController= new OrderController();
				}
				
			}
		}
		return orderController;
	}
	
	public OrderController() {
		super();
		this.orderCollection=OrderCollection.getOrderCollection();
	}

	public List<Orders> findAll() throws SQLException {
		return orderCollection.findAll();
	}

	public Orders findOne(int id) throws SQLException {
		Orders orders=orderCollection.findOne(id);
		return orders;
	}

	public boolean createNew(Orders orders) throws SQLException {
		return orderCollection.createNew(orders);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		return orderCollection.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Orders orders) throws SQLException {
		return orderCollection.findOneAndUpdate(id, orders);
	}

}


