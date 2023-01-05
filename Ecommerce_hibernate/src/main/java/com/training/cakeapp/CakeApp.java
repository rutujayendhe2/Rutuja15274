package com.training.cakeapp;

import java.lang.StackWalker.Option;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.training.cakeapp.controller.CustomerController;
import com.training.cakeapp.controller.OrderController;
import com.training.cakeapp.controller.OrderItemController;
import com.training.cakeapp.controller.ProductController;

import com.training.cakeapp.model.Customer;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Orders;
import com.training.cakeapp.model.Product;

public class CakeApp {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		// Step1 : Display all product
		OrderItemController orderItemController = OrderItemController.getOrderItemController();
		ProductController productController = ProductController.getProductController();
		CustomerController customerController = CustomerController.getCustomerController();
		OrderController ordersController = OrderController.getOrderController();
		List<OrderItem> items = new ArrayList<>();
		try {
			Customer customer = customerController.findOne(2);

			productController.findAll().forEach(System.out::println);
			while (true) {
				System.out.println("Select the Product");
				final int productId = sc.nextInt();
				System.out.println("Select the Quantity");
				final int quantity = sc.nextInt();
				final Product product = productController.findOne(productId);
				final OrderItem orderItem = new OrderItem(product, quantity);
				final double orderItemTotalPrice = orderItem.getTotalPrice();

//				System.out.println("Product Total : "+ orderItem.getTotalPrice());

				items.add(orderItem);
				System.out.println("Do you want to add one more product y for Yes and n for No");
				String options = sc.next();
				if (options.equalsIgnoreCase("n")) {
					break;
				}

			}
			System.out.println("You have selected");

			items.forEach(System.out::println);
			for (OrderItem orderItem : items) {
				orderItemController.createNew(orderItem);
			}

			double totalOrderPrice = 0.0;
			for (OrderItem orderItem : items) {
				totalOrderPrice = totalOrderPrice + orderItem.getTotalPrice();
			}

			System.out.println("Your Total Products Price :" + totalOrderPrice);

			Orders orders = new Orders(new Date(), customer, items);
			System.out.println(orders);
			ordersController.createNew(orders);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
