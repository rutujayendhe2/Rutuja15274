package com.training.CakeApp.modal;

public class ProductList {
	
	private static final Product [] PRODUCTS=new Product[5];
		
		static{
			PRODUCTS[0]=new FindProduct("Strawberry",1000,"1Kg","Strawberry.jpg");
			PRODUCTS[1]=new FindProduct("Black Forest",2000,"500gms","BlackFF.jpg");
			PRODUCTS[2]=new FindProduct("Rasmalai",3000,"500gms","Rasmalai.jpg");
			PRODUCTS[3]=new FindProduct("Pista",4000,"1Kg","Pista.jpg");
			PRODUCTS[4]=new FindProduct("Lava",5000,"1Kg","Lava.jpg");
			
		}
		public ProductList() {
			super();
		}
		public static Product[] getProducts() {
			return PRODUCTS;
		}

	

}


