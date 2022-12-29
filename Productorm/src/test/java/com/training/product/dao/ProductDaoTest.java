package com.training.product.dao;

import com.training.product.model.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ProductDaoTest {

	private Product product;
	private ProductDao productDao;
	
	@BeforeEach()
	public void beforeEach() {
		product = new Product("Cake2",450.0);
		productDao = new ProductDao();
	}


	@Test
	public void testCreate() {
		Assertions.assertTrue(productDao.create(product));
	}
	
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productDao.findAll());
	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		product = productDao.findOne(4);
		Assertions.assertNotNull(product);
		System.out.println("id=4 |" + product);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productDao.findOneandDelete(9));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setProductName("Cake1");
		Assertions.assertTrue(productDao.findOneandUpdate(7, product));
	}

}


