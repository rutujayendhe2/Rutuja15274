package com.training.CakeApp;

import java.util.Date;

import com.training.CakeApp.modal.Order;
import com.training.CakeApp.modal.Product;

public class cakeApp {

	public static void main(String[] args) {
		Product product1=new Product("White Forest",200.0,"1Kg","WhiteFF.jpg",1);
		Product product2=new Product("Strawberry",400.0,"1.5Kg","Strawberry.jpg",1);
		System.out.println(product1);
		System.out.println(product2);
		Date date = new Date();
		Order order1 = new Order(1000,1001,"Strawberry",date,1,200.0);
		System.out.println(order1);
        }
	
}


