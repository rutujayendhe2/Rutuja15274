package com.training.cakeapp.dao;

import java.util.List;

import com.training.cakeapp.model.Orders;

public class OrdersDao implements IDao<Orders> {

	@Override
	public boolean create(Orders obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findOneandDelete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findOneandUpdate(int id, Orders newObj) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
