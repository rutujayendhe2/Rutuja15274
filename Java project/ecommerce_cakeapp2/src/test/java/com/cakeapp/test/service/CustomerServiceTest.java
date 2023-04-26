package com.cakeapp.test.service;

import java.util.ArrayList;
import java.util.List;

import com.cakeapp.dto.CustomerData;
import com.cakeapp.service.CustomerService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@MockBean
	private CustomerService customerService;
	private CustomerData customerData;

	@BeforeEach()
	public void beforeEach() {
		customerData = new CustomerData();

		customerData.setFirstName("Rutuja");
		customerData.setLastName("Yendhe");
		customerData.setEmailAdd("rutu@gmail.com");
		customerData.setPhoneNo("8940284024");
		customerData.setAddress("Pune");
		customerData.setPassword("12345");
	}

	@Test
	public void testFindAllNotNull() {
		List<CustomerData> list = new ArrayList<CustomerData>();
		CustomerData customer1 = new CustomerData(1L, "Rutuja", "Yendhe", "r@gmail.com", "897653234", "Pune", "12345");
		CustomerData customer2 = new CustomerData(2L, "Rutuja", "Yendhe", "r@gmail.com", "897653234", "Pune", "12345");
		list.add(customer1);
		list.add(customer2);
		Mockito.when(customerService.findAll()).thenReturn(list);

		List<CustomerData> customerlist = customerService.findAll();
		Assertions.assertEquals(2, customerlist.size());

	}

	@Test
	public void testCreateNew() {

		Mockito.when(customerService.create(customerData)).thenReturn(customerData);
		Assertions.assertNotNull(customerService.create(customerData));

	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		Mockito.when(customerService.findById(2L)).thenReturn(customerData);
		Assertions.assertEquals(customerData, customerService.findById(2L));

	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Mockito.when(customerService.delete(2L)).thenReturn(true);
		Assertions.assertTrue(customerService.delete(2L));

	}

	@Disabled
	@Test
	public void testFindOneAndUpdate() {

		Mockito.when(customerService.update(1L, customerData)).thenReturn(true);
		Assertions.assertTrue(customerService.update(1L, customerData));
	}

}
