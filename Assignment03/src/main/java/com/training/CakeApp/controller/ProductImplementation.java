package com.training.CakeApp.controller;

import java.util.Set;

import com.training.CakeApp.modal.Order;
import com.training.CakeApp.modal.Product;

public class ProductImplementation extends CakeAppCollection<Product> {

	private static ProductImplementation productImplement;
	
	public static ProductImplementation getProductObj(){
		if (productImplement == null ) {
			synchronized (ProductImplementation.class) {
				if (productImplement == null ) {
					productImplement = new ProductImplementation();
				}
			}
		}
		
			return productImplement;
	}
	
	{
		collection.add(new Product(101,"White Forest",213.0,"1Kg","WhiteFF.jpg",1));
		collection.add(new Product(102,"Strawberry",400.0,"1.5Kg","Strawberry.jpg",1));
		collection.add(new Product(103,"Almond Cake",595.0,"1.5Kg","AlmondCake.jpg",2));
		collection.add(new Product(104,"Red velvet",849.0,"1Kg","Red velvet.jpg",2));

	}
	
	
	private ProductImplementation() {
		super();
	}


	@Override
	public Set<Product> getList() {
		return collection;
	}

	
	@Override
	//add productDetails
		
	public String createNew(Product product) {
		
		if (collection.add(product)) {
			return "Created new product" + product;
		}
		else {
			return "error while creating new product";
		}
	}

	@Override
	public Product findById(int productId) {

		for(Product product:collection) {
			if(product.getProductId()==productId) {
				return product;
			}
		}
		return null;
	}

	@Override
	public String updateentityById(int entityId, Product entity) {
		for(Product product : collection) {
			if(product.getProductId()== entityId) {
				product.setProductName(entity.getProductName());
				product.setPrice(entity.getPrice());
				product.setWeight(entity.getWeight());
				product.setImageUrl(entity.getImageUrl());
				product.setQuantity(entity.getQuantity());

				
				return "Product updated Successfully";
			}	
		}
		return null;
	}
	
	
	@Override
	public String deletebyId(int entityId) {
		for(Product product: collection) {
			if(product.getProductId()== entityId) {
				collection.remove(product);
				return "Product Deleted";
			}
		}
		return "Product Not Found";
	}
	

	
	
}
