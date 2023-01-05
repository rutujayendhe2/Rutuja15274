package com.training.cakeapp.collection;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.dao.CustomerDao;

import com.training.cakeapp.model.Customer;

public class CustomerCollection implements ICollection<Customer> {

	private static CustomerCollection collection;
	private CustomerDao dao;
	private List<Customer> customerList;
	
	private CustomerCollection() {
		this.dao=CustomerDao.getCustomerDao();
	}

	public static CustomerCollection getCustomerCollection() {
		if(collection==null) {
			synchronized (CustomerCollection.class) {
				if(collection==null) {
					collection=new CustomerCollection();
				}
				
			}
		}
		return collection;
	}

	
	
	public List<Customer> findAll() throws SQLException {
		customerList=dao.findAll();
		return customerList;
	}
	public Customer findOne(int id) throws SQLException {
		Customer customer=dao.findOne(id);
		return customer;
	}
	public boolean createNew(Customer customer) throws SQLException {
		return dao.createNew(customer);
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		return dao.findOneandDelete(id);
	}
	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		return dao.findOneandUpdate(id, customer);
	}
}
