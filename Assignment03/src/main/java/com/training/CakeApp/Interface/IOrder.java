package com.training.CakeApp.Interface;

import java.util.Set;

public interface IOrder<T> {

	abstract Set<T> getList();
	
	  String createNeworder(T order);
	  String updateOrderNameById(int orderId, String productName);
	  T findByOrderId(int orderId);
	  	
}
