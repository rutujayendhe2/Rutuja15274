package com.training.cakeapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.collection.CustomerCollection;
import com.training.cakeapp.model.Customer;

public class CustomerController implements IController<Customer> {

	private static CustomerController customerController;
	private CustomerCollection  customerCollection;
	private CustomerController() {
		super();
		this.customerCollection=CustomerCollection.getCustomerCollection();
	}
	public static CustomerController getCustomerController() {
		if(customerController == null) {
			synchronized (CustomerController.class) {
				if(customerController==null) {
					customerController= new CustomerController();
				}
				
			}
		}
		return customerController;

    }
	
	public List<Customer> findAll() throws SQLException {
		return customerCollection.findAll();
	}
	
	public Customer findOne(int id) throws SQLException {
		return customerCollection.findOne(id);
	}
	public boolean createNew(Customer customer) throws SQLException {
		return customerCollection.createNew(customer);
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		return customerCollection.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		return customerCollection.findOneAndUpdate(id, customer);
	}
	
}
