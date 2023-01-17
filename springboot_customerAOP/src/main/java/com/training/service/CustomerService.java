package com.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.training.dao.ICustomerRepository;
import com.training.dto.CustomerData;
import com.training.model.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class CustomerService implements ICustomerService {

//	DTO=>Entity
	private Customer getCustomerEntity(CustomerData customerData) {
		Customer customer = new Customer();
		customer.setCustomerId(customerData.getCustomerId());
		customer.setFirstName(customerData.getFirstName());
		customer.setLastName(customerData.getLastName());
		customer.setEmailAdd(customerData.getEmailAdd());
		customer.setPhoneNo(customerData.getPhoneNo());
		customer.setAddress(customerData.getAddress());
		return customer;
	}

//	Entity=>DTO
	private CustomerData getCustomerData(Customer customer) {
		CustomerData customerData = new CustomerData();
		customerData.setCustomerId(customer.getCustomerId());
		customerData.setFirstName(customer.getFirstName());
		customerData.setLastName(customer.getLastName());
		customerData.setEmailAdd(customer.getEmailAdd());
		customerData.setPhoneNo(customer.getPhoneNo());
		customerData.setAddress(customer.getAddress());

		return customerData;
	}

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public List<CustomerData> findAll() {
		List<CustomerData> customerDataList = new ArrayList<>();
		List<Customer> customers = customerRepository.findAll();
		customers.forEach(customer -> {
			customerDataList.add(getCustomerData(customer));
		});
		return customerDataList;
	}

	@Override
	public CustomerData findById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional == null) {
			new EntityNotFoundException("Customer Not Found");
		}
		return getCustomerData(customerOptional.get());

	}

	@Override
	public CustomerData create(CustomerData customerData) {
		Customer customer = getCustomerEntity(customerData);
		return getCustomerData(customerRepository.save(customer));
	}

	@Override
	public boolean delete(Long id) {
		boolean test = findAll().remove(findById(id));
		customerRepository.deleteById(id);
		return test;
	}

	@Override
	public boolean update(Long id, CustomerData customerData) {
		Customer customer = customerRepository.findById(id).get();
		if (customer != null) {
			customer.setFirstName(customerData.getFirstName());
			customer.setLastName(customerData.getLastName());
			customer.setEmailAdd(customerData.getEmailAdd());
			customer.setPhoneNo(customerData.getPhoneNo());
			customer.setAddress(customerData.getAddress());

			customerRepository.save(customer);
			
			return true;
		}
		return false;
	}
	

}
