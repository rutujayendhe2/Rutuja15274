package com.training.CakeApp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.training.CakeApp.controller.CustomerImplementation;
import com.training.CakeApp.controller.OrderImplementation;
import com.training.CakeApp.controller.ProductImplementation;
import com.training.CakeApp.modal.Customer;
import com.training.CakeApp.modal.Order;
import com.training.CakeApp.modal.Product;

public class CakeApp {

	public static void main(String[] args) {
		
		System.out.println("***********************PRODUCT***********************");

		ProductImplementation productI = ProductImplementation.getProductObj();
		
		
		Set<Product> products =new HashSet<Product>();
		System.out.println("***********************************PRODUCT DISPLAY*******************************************");
		products= productI.getList();
		for(Product product:products) {
			System.out.println(product);
		}
		
		System.out.println("***********************************Create New Product*************************************************");
		Product product1=new Product("Pinata Cake",542.0,"1Kg","Pinata.jpg",1);
		Product product2=new Product("Choclate Truffle",695.0,"1.5Kg","Truffle.jpg",1);
		String msg1 = productI.createNew(product1);
		String msg2 =productI.createNew(product2);
		System.out.println(msg1);
		System.out.println(msg2);
		
		//Find Product

		int id = 0;
		Product product3=productI.findById(id);
		System.out.println("Product Found"+product3);
		
		
		//Delete Product by Id
		String deleteMessage=productI.deletebyId(4);
		System.out.println(deleteMessage);
		
		
		
		
		
		
		System.out.println("***********************ORDER************************");
		
		OrderImplementation orderI = OrderImplementation.getOrderObj();
		Set<Order> orders =new HashSet<Order>();
		System.out.println("***********************************ORDER DISPLAY*******************************************");
		orders= orderI.getList();
		for(Order order:orders) {
			System.out.println(order);
		}
		
		Date date = new Date();
		Order order1 = new Order(1000,1001,"Strawberry",date,1,200.0,200.0);
		Order order2 = new Order(2000,1002,"Black Forest",date,1,500.0,500.0);
		String msg3 = orderI.createNew(order1);
		String msg4 = orderI.createNew(order2);
		System.out.println(msg3);
		System.out.println(msg4);
		
	   //Find order

		
		Order order3=orderI.findById(102);
		System.out.println("order Found"+order3);
		
		
		//Delete order by Id
		String deleteMessage1=orderI.deletebyId(4);
		System.out.println(deleteMessage1);
		
		
	System.out.println("***********************CUSTOMER************************");
		
	CustomerImplementation customerI = CustomerImplementation.getustomerObj();
		Set<Customer> customers =new HashSet<Customer>();
		System.out.println("***********************************Customer DISPLAY*******************************************");
		customers= customerI.getList();
		for(Customer customer:customers) {
			System.out.println(customer);
		}
		
		System.out.println("***********************************Create Customer*******************************************");

		Customer customer1 = new Customer("Rutuja","Yendhe","rutu@gmail.com","9023231267","Pune");
		String msg5 = customerI.createNew(customer1);
		System.out.println(msg5);
		
	   //Find Customer

		System.out.println("***********************************find Customer*******************************************");

		Customer customer3=customerI.findById(102);
		System.out.println("Customer Found"+customer3);
		
		
		//Delete Customer by Id
		String deleteMessage11=customerI.deletebyId(4);
		System.out.println(deleteMessage11);

	}

}
