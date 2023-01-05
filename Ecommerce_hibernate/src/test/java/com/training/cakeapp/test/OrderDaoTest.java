package com.training.cakeapp.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.training.cakeapp.dao.CustomerDao;
import com.training.cakeapp.dao.OrderDao;
import com.training.cakeapp.model.Customer;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Orders;
import com.training.cakeapp.model.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class OrderDaoTest {
	private Orders orders;
	private OrderDao orderDao;
	private CustomerDao customerDao;
	private Customer customer;
	private List<OrderItem> items =new ArrayList<>();
	@BeforeEach()
	public void beforeEach() {

		customer = CustomerDao.getCustomerDao().findOne(4);
		
		
		items.add(new OrderItem(new Product(3,"Cake2",450.0),2));
		orders = new Orders(new Date(),customer,items);
		orderDao = OrderDao.getOrderDao();

	}
	
	
	@Test
	public void testCreate() {
		Assertions.assertTrue(orderDao.createNew(orders));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderDao.findAll());
	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		orders = orderDao.findOne(38);
		Assertions.assertNotNull(orders);
		System.out.println("id=38 |" + orders);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderDao.findOneandDelete(28));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		orders.setDate(new Date());
		Assertions.assertTrue(orderDao.findOneandUpdate(3, orders));
	}
	
}
