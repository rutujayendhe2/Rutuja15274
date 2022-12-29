package com.training.customer.dao;

import com.training.customer.model.Customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CustomerDaoTest {

	private Customer customer;
	private CustomerDao customerDao;

	@BeforeEach()
	public void beforeEach() {
		customer = new Customer("rutuja", "yendhe", "r@gmail.com", "9725342674", "Pune");
		customerDao = new CustomerDao();
	}

	
	@Test
	public void testCreate() {
		Assertions.assertTrue(customerDao.create(customer));
	}
	

	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(customerDao.findAll());
	}

	
	@Test
	public void testFindOneNotNull() {
		customer = customerDao.findOne(4);
		Assertions.assertNotNull(customer);
		System.out.println("id=4 |" + customer);
	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(customerDao.findOneandDelete(9));
	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		customer.setFirstName("Pooja");
		Assertions.assertTrue(customerDao.findOneandUpdate(7, customer));
	}

}
