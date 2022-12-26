package com.training.cakeapp;

import java.sql.SQLException;
import java.util.List;


import com.training.cakeapp.controller.ProductController;
import com.training.cakeapp.dao.ProductImplementDao;
import com.training.cakeapp.model.Product;

public class CakeApp {

	public static void main(String[] args) {
		try {
			final ProductController productController=
					ProductController.getProductController();
			System.out.println("1. Display all Products");
			System.out.println("2. Account Details by productId");
			System.out.println("3. Delete Product by productId");
			System.out.println("4. Update Balace by productId");
			
			int choice=1;
			System.out.println("1. Display all Products");
			mainOptions(productController, choice);
			
			System.out.println("2. Account Details by productId");
			choice=2;
			mainOptions(productController, choice);
			
			System.out.println("3. Delete Product by productId");
			choice=3;
			mainOptions(productController, choice);
			
			System.out.println("4. Update Balace by productId");
			choice=4;
			mainOptions(productController, choice);
			
			choice=5;
			System.out.println("5. Create Products");
			mainOptions(productController, choice);
		} catch (Exception e) {
			e.printStackTrace();
		}


}
	private static void mainOptions(final ProductController productController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
				List<Product> list=productController.findAll();
				for(Product product:list) {
					System.out.println(product);
				}
				break;
		case 2: 
			final Product product=productController.findOne(104);
			System.out.println(product);
			break;
			
		case 3: 
			if(productController.findOneAndDelete(0)) {
				System.out.println("Acc No: 3 Records Deleted");
			}
			break;
		case 4: 
			final Product updateProduct=productController.findOne(101);
			updateProduct.setQuantity(2);
			if(productController.findOneAndUpdate(101,updateProduct)) {
				System.out.println("Product Id: 2 Records Updated");
			}
			break;	
		case 5: 
			final Product newProduct=new Product("Fruit Cake",542.0,"1Kg","Fruit.jpg",1);
			if(productController.createNew(newProduct)) {
				System.out.println(newProduct+ " Created in DB");
			}
			break;
			
		default:
			System.out.println("Please select between 1 to 5 options");
			break;
		}
	}
	
	private static void printProducts(ProductImplementDao dao) throws SQLException {
		final List<Product> list=dao.findAll();
		for(Product a: list) {
			System.out.println(a);
		}
	}

}
	
