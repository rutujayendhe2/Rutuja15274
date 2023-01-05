package com.training.cakeapp.collection;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.dao.OrderDao;
import com.training.cakeapp.model.Orders;

public class OrderCollection implements ICollection<Orders> {

	private static OrderCollection orderCollection;
	private OrderDao orderDao;
	private List<Orders> orderList;
	
	private OrderCollection() {
		this.orderDao=OrderDao.getOrderDao();
	} 
	
	public static OrderCollection getOrderCollection() {
		if(orderCollection==null) {
			synchronized (OrderCollection.class) {
				if(orderCollection==null) {
					orderCollection=new OrderCollection();
				}
				
			}
		}
		return orderCollection;
	}

	
	public List<Orders> findAll() throws SQLException {
		orderList=orderDao.findAll();
		return orderList;
	}
	
	public Orders findOne(int id) throws SQLException {
		Orders orders=orderDao.findOne(id);
		return orders;
	}

	
	public boolean createNew(Orders orders) throws SQLException {
		return orderDao.createNew(orders);
	}

	
	public boolean findOneAndDelete(int id) throws SQLException {
		return orderDao.findOneandDelete(id);
	}

	
	public boolean findOneAndUpdate(int id, Orders orders) throws SQLException {
		return orderDao.findOneandUpdate(id, orders);
	}

}
