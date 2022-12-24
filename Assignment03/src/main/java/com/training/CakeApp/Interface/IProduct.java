package com.training.CakeApp.Interface;

import java.util.Set;

public interface IProduct<T> {

	abstract Set<T> getList();
	
	  String createNewProduct(T product);
	  String updateProductNameById(int productId, String productName);
	  T findByProductId(int productId);

}
