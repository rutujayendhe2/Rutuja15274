package com.training.CakeApp.controller;

import java.util.HashSet;
import java.util.Set;

import com.training.CakeApp.Interface.ICakeApp;

public abstract class CakeAppCollection<T> implements ICakeApp<T> {

	public Set<T> collection = new HashSet<>();
	
	public CakeAppCollection() {
		super();
	}

	
}

	