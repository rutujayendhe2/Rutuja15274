package com.training.CakeApp.controller;

import java.util.Set;

import com.training.CakeApp.modal.Customer;
import com.training.CakeApp.modal.Order;

public  class CustomerImplementation extends CakeAppCollection<Customer> {

	private static CustomerImplementation customerImplement;
	
	public static CustomerImplementation getustomerObj() {

		
		if (customerImplement == null) {
			synchronized (CustomerImplementation.class) {
				if (customerImplement == null) {
					customerImplement = new CustomerImplementation();
				}
			}
		}
		return customerImplement;
	}

	{
		collection.add(new Customer(101,"Rutuja","Yendhe","rutu@gmail.com","9023231267","Pune"));
		collection.add(new Customer(102,"Gayatri","Yendhe","gayatri@gmail.com","9022121167","Pune"));

	}

	@Override
	public Set<Customer> getList() {
		return collection;
	}

	@Override
	public String createNew(Customer customer) {
		if (collection.add(customer)) {
			return "Created new Customer" + customer;
		}
		else {
			return "error while creating new Customer";
		}
	}

	@Override
	public String updateentityById(int entityId, Customer entity) {
		for(Customer customer : collection) {
			if(customer.getCustomerId()== entityId) {
				customer.setFirstName(entity.getFirstName());
				customer.setLastName(entity.getLastName());
				customer.setEmailAdd(entity.getEmailAdd());
				customer.setPhoneNo(entity.getPhoneNo());
				
				return "Customer updated Successfully";
			}	
		}
		return null;
	}

	@Override
	public String deletebyId(int entityId) {
		for(Customer customer : collection) {
			if(customer.getCustomerId()== entityId) {
				collection.remove(customer);
				return "customer Deleted";
			}
		}
		return "customer Not Found";
	}
	
	
	@Override
	public Customer findById(int customerId) {
		for(Customer customer : collection) {
			if(customer.getCustomerId()== customerId) {
				return customer;
			}
		}
		return null;
	}
	
}