package com.training.CakeApp;

import com.training.CakeApp.modal.Product;
import com.training.CakeApp.modal.ProductList;
import com.training.CakeApp.util.FindByProductName;
import com.training.CakeApp.util.FindProductIdAndDelete;

public class cakeApp {

	public static void main(String[] args) {
		
			try {
				System.out.println("==========All Product=============");
				Product [] products=ProductList.getProducts();
				
				printProducts(products);
				
				System.out.println("==========Update price of productId 1000=============");
				final int productId=1000;
				Product product=findByProductNo(products,productId);
				if(product!=null) {
					System.out.println("before updated :"+product);
					final double productPrice=product.getPrice()+500;
					product.setPrice(productPrice);
					System.out.println(" after updated :"+product);
				}
				
				//delete product
				final String msg=findByProductIdAndDelete(products,productId);
				
				//
				
				//find by product Name
				String productName="Strawberry";
				String pName=findByProductName(products,productName);
				if(pName!=null) {
					
					System.out.println(" find:"+productName+ ":");
					System.out.println(" ::::::"+pName);
				}
				
			}
			
			catch(Exception e) {}
			finally {}

		}

		private static String findByProductName(Product[] products, String productName)throws Exception {
			for(int i=0;i<products.length;i++ ) {
				if(products[i].getproductName()==productName) {
					
					return products[i].toString();
				}
				else {
					throw new FindByProductName("ProductName is not present");
				}
				
			}
			return "product is not available";
		}

		private static String findByProductIdAndDelete(Product[] products, int productId)throws Exception {
			for(int i=0;i<products.length;i++ ) {
				if(products[i].getproductId()==productId) {
					products[i]=null;
					return productId+"record deleted";
				}
				else {
					throw new FindProductIdAndDelete("Product Id is not present");
				}
			}
			return "product is not available";
		}

		private static Product  findByProductNo(Product[] products,final int productId) {
			for(Product product:products ) {
				if(product.getproductId()==productId) {
					
					return product;
				}
			}
			return null;
		}

		private static void printProducts(Product[] products) {
			for(Product product:products ) {
				System.out.println(product);
			}
		}

	}
