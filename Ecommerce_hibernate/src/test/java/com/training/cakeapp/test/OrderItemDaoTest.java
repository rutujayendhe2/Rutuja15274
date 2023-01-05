package com.training.cakeapp.test;

import com.training.cakeapp.dao.OrderItemDao;
import com.training.cakeapp.dao.ProductDao;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class OrderItemDaoTest {
	private OrderItem orderItem;
	private OrderItemDao orderItemDao;
	private ProductDao productDao;
	private Product product;

	@BeforeEach()
	public void beforeEach() {

		productDao = ProductDao.getProductDao();
		product = productDao.findOne(3);
		orderItem = new OrderItem(product, 2);
		orderItemDao = OrderItemDao.getOrderItemDao();

	}

	@Disabled
	@Test
	public void testCreate() {
		Assertions.assertTrue(orderItemDao.createNew(orderItem));
	}

	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderItemDao.findAll());
	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		orderItem = orderItemDao.findOne(38);
		Assertions.assertNotNull(orderItem);
		System.out.println("id=38 |" + orderItem);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderItemDao.findOneandDelete(28));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		orderItem.setQuantity(4);
		Assertions.assertTrue(orderItemDao.findOneandUpdate(3, orderItem));
	}

}
