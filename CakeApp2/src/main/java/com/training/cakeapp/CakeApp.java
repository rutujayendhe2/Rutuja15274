package com.training.cakeapp;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.controller.CustomerController;
import com.training.cakeapp.dao.CustomerImplementDao;
import com.training.cakeapp.model.Customer;

public class CakeApp {

	public static void main(String[] args) {
		try {
			final CustomerController customerController=
					CustomerController.getCustomerController();
			System.out.println("1. Display all Customer");
			System.out.println("2. Account Details by customerId");
			System.out.println("3. Delete Customer by customerId");
			System.out.println("4. Update Balace by customerId");
			
			int choice=1;
			System.out.println("1. Display all Customers");
			mainOptions(customerController, choice);
			
			System.out.println("2. Account Details by customerId");
			choice=2;
			mainOptions(customerController, choice);
			
			System.out.println("3. Delete Customer by customerId");
			choice=3;
			mainOptions(customerController, choice);
			
			System.out.println("4. Update Address by customerId");
			mainOptions(customerController, choice);
			
			choice=5;
			System.out.println("5. Create Customers");
			mainOptions(customerController, choice);
		} catch (Exception e) {
			e.printStackTrace();
		}


}
	private static void mainOptions(final CustomerController customerController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
				List<Customer> list=customerController.findAll();
				for(Customer customer:list) {
					System.out.println(customer);
				}
				break;
		case 2: 
			final Customer customer=customerController.findOne(103);
			System.out.println(customer);
			break;
			
		case 3: 
			if(customerController.findOneAndDelete(102)) {
				System.out.println("Acc No: 3 Records Deleted");
			}
			break;
		case 4: 
			final Customer updateCustomer=customerController.findOne(103);
			updateCustomer.setAddress("Mumbai");
			if(customerController.findOneAndUpdate(103,updateCustomer)) {
				System.out.println("Customer Id: 102 Records Updated");
			}
			break;	
			
		case 5: 
			final Customer newCustomer=new Customer("Anuja","Dhas","anu@gmail.com","9023231267","Pune");
			if(customerController.createNew(newCustomer)) {
				System.out.println(newCustomer+ " Created in DB");
			}
			break;
			
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}
	
	private static void printProducts(CustomerImplementDao dao) throws SQLException {
		final List<Customer> list=dao.findAll();
		for(Customer a: list) {
			System.out.println(a);
		}
	}

}
	
