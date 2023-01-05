package com.training.cakeapp.collection;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.dao.OrderItemDao;
import com.training.cakeapp.model.OrderItem;

public class OrderItemCollection implements ICollection<OrderItem> {
	private static OrderItemCollection collection;
	private OrderItemDao orderItemDao;

	private List<OrderItem> orderItemList;
	
	private OrderItemCollection() {
		this.orderItemDao=OrderItemDao.getOrderItemDao();
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
		orderItemList=orderItemDao.findAll();
		return orderItemList;
		
		}
		

	
	public OrderItem findOne(int id) throws SQLException {
		OrderItem orderItem=orderItemDao.findOne(id);
		return orderItem;
	}

	
	public boolean createNew(OrderItem orderItem) throws SQLException {
		return orderItemDao.createNew(orderItem);
	}

	
	public boolean findOneAndDelete(int id) throws SQLException {
		return orderItemDao.findOneandDelete(id);
	}

	
	public boolean findOneAndUpdate(int id, OrderItem orderItem) throws SQLException {
		return orderItemDao.findOneandUpdate(id, orderItem);
	}

}
