package com.training.test.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.training.dto.CustomerData;
import com.training.service.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	private CustomerData customerData;
	@BeforeEach()
	
	public void beforeEach() {
		customerData=new CustomerData();
		
		customerData.setFirstName("Rutuja");
		customerData.setLastName("Yendhe");
		customerData.setEmailAdd("rutu@gmail.com");
		customerData.setPhoneNo("8940284024");
		customerData.setAddress("Pune");;
	}
	
	@Test
	public void testFindAllNotNull() {
		assertNotNull(customerService.findAll());
	}
	
	@Test
	public void testCreateNew() {	
		assertNotNull(customerService.create(customerData));
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		Long id=2l;
		assertNotNull(customerService.findById(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Long id=1l;
		assertTrue(customerService.delete(id));
	}
	
//	@Disabled
//	@Test
//	public void testFindOneAndUpdate() {
//		Long id=1l;
//		assertTrue(customerService.findOneAndUpdate(id, productData));
//	}

}
