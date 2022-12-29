package com.trainning.cakeapp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.training.cakeapp.controller.OrderItemController;
import com.training.cakeapp.controller.ProductController;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Product;


public class CakeApp {

	public static void main(String[] args) {
		try {
			final OrderItemController orderItemController=
					OrderItemController.getOrderItemController();
			final ProductController productController =
					ProductController.getProductController();
			Scanner sc = new Scanner(System.in);
			int choice=0;
			do {
				 System.out.println("----MENU----");
	                System.out.println("1. Show orderItems");
	                System.out.println("2. Searchh by orderItem Id");
	                System.out.println("3. Delete by orderItem Id");
	                System.out.println("4. Update Quantity by orderItem Id");
	                System.out.println("5. Create new orderItem");
	                System.out.println("6. Exit program");
	                System.out.print("Enter your selection : ");
	                
	                choice=sc.nextInt();
	                //System.out.println("1. Show customers");
	                mainOptions(orderItemController, choice);

	                //System.out.println("2. Search by Customer Id");
	                choice=sc.nextInt();
	                mainOptions(orderItemController, choice);

	                //System.out.println("3. Delete by Customer Id");
	                choice=sc.nextInt();
	                mainOptions(orderItemController, choice);

	                //System.out.println("4. Update City by Customer Id");
	                choice=sc.nextInt();
	                mainOptions(orderItemController, choice);
	                choice=sc.nextInt();
	                //System.out.println("5. Create new customer");
	                mainOptions(orderItemController, choice);
			}while(choice!=7);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void mainOptions(OrderItemController orderItemController, int choice) {
		try {
		Scanner sc = new Scanner(System.in);
		switch(choice) {
		case 1: 
				List<OrderItem> list=orderItemController.findAll();
				for(OrderItem orderItem:list) {
					System.out.println(orderItem);
				}
				break;
		case 2: 
			System.out.print("Enter OrderItem Id ? ");
			int id = sc.nextInt();
			final OrderItem orderItem=orderItemController.findOne(id);
			System.out.println(orderItem);
			break;
			
		case 3: 
			System.out.print("Enter the Id of OrderItem for  delete record :");
            int id1 = sc.nextInt();
			if(orderItemController.findOneAndDelete(id1)) {
				System.out.println("OrderItem Id: "+id1+"Records Deleted :");
			}
			break;
			
		case 4: 
			
			
			System.out.print("Enter the Id of OrderItem for update record :");
            int id2 = sc.nextInt();
            System.out.print("Enter the quantity for update :");
            final OrderItem updateOrderItem=orderItemController.findOne(id2);
            int quantity=3;
            updateOrderItem.setQuantity(quantity);
            if(orderItemController.findOneAndUpdate(id2,updateOrderItem)) {
			System.out.println("OrderItem Id: "+ id2 +" Records updated");
		}
        break;	
			
		case 5: 
				System.out.println("Enter product:");
	            int product= sc.nextInt();
	          
	            System.out.println("Enter quantity:");
	            int quantity1= sc.nextInt();
	            
	            System.out.println("Enter itemTotalPrice:");
	            double itemTotalPrice= sc.nextDouble();
	            
	        
	            System.out.println("Record Updated");
			final OrderItem newOrderItem=new OrderItem((new Product("Lava Cake",230.0,"1Kg","Lava.jpg",2)),quantity1,itemTotalPrice);
			if(orderItemController.createNew(newOrderItem)) {
				System.out.println(newOrderItem+ " Created in DB");
			}
			break;
			
		 case 6:
	            System.out.println("\nThank you for using the program. Goodbye!\n");
	                System.exit(0);
	            break;
		default:
			System.out.println("Please select between 1 to 6 options");
			break;
		}
		}catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
		
	

}