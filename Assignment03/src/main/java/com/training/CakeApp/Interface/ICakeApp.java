package com.training.CakeApp.Interface;

import java.util.Set;

public interface ICakeApp<T> {

	abstract Set<T> getList();
	
	  String createNew(T entity);
	  String updateentityById(int entityId, T entity);
	  String deletebyId(int entityId);
	  T findById(int entityId);
	  	
}
