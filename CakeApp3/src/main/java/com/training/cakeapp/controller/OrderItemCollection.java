package com.training.cakeapp.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.cakeapp.dao.OrderItemImplementDao;
import com.training.cakeapp.dao.ProductImplementDao;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Product;

public class OrderItemCollection implements IOrderItemCollection<OrderItem> {
	
	private static OrderItemCollection collection;
	private OrderItemImplementDao orderItemImplementDao;
	private List<OrderItem> orderItemList;
	
	private OrderItemCollection() {
		this.orderItemImplementDao=OrderItemImplementDao.getOrderItemDao();
	}

	public static OrderItemCollection getOrderItemCollection() {
		if(collection==null) {
			synchronized (OrderItemCollection.class) {
				if(collection==null) {
					collection=new OrderItemCollection();
				}
				
			}
		}
		return collection;
	}

	
	public List<OrderItem> findAll() throws SQLException {
		orderItemList=orderItemImplementDao.findAll();
		return orderItemList;
		
		}
		

	
	public OrderItem findOne(int id) throws SQLException {
		OrderItem orderItem=orderItemImplementDao.findOne(id);
		return orderItem;
	}

	
	public boolean createNew(OrderItem orderItem) throws SQLException {
		return orderItemImplementDao.createNew(orderItem);
	}

	
	public boolean findOneAndDelete(int id) throws SQLException {
		return orderItemImplementDao.findOneAndDelete(id);
	}

	
	public boolean findOneAndUpdate(int id, OrderItem orderItem) throws SQLException {
		return orderItemImplementDao.findOneAndUpdate(id, orderItem);
	}

}
