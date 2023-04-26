package com.cakeapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.cakeapp.dao.IOrdersRepository;
import com.cakeapp.dto.OrdersData;
import com.cakeapp.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrdersService implements IOrderService {

//	DTO=>Entity
	private Orders getOrdersEntity(OrdersData ordersData) {
		Orders orders = new Orders();
		orders.setOrderId(ordersData.getOrderId());
		orders.setDate(ordersData.getDate());
		orders.setCustomer(ordersData.getCustomer());

		orders.setOrderItem(ordersData.getOrderItem());
		
		return orders;
	}

//	Entity=>DTO
	private OrdersData getOrdersData(Orders orders) {
		OrdersData ordersData = new OrdersData();
		ordersData.setOrderId(orders.getOrderId());
		ordersData.setDate(orders.getDate());
		ordersData.setCustomer(orders.getCustomer());

		ordersData.setOrderItem(orders.getOrderItem());

		return ordersData;
	}
	
	@Autowired
	private IOrdersRepository ordersRepository;
	
	@Override
	public List<OrdersData> findAll() {
		
			List<OrdersData> ordersDataList = new ArrayList<>();
			List<Orders> orders = ordersRepository.findAll();
			orders.forEach(order -> {
				ordersDataList.add(getOrdersData(order));
			});
			return ordersDataList;	
			}

	@Override
	public OrdersData findById(Long id) {
		Optional<Orders> ordersOptional = ordersRepository.findById(id);
		if (ordersOptional == null) {
			new EntityNotFoundException("Orders Not Found");
		}
		return getOrdersData(ordersOptional.get());
	}

	@Override
	public OrdersData create(OrdersData ordersData) {
		Orders orders=getOrdersEntity(ordersData);
		return getOrdersData(ordersRepository.save(orders));
	}

	@Override
	public boolean delete(Long id) {
		boolean test=findAll().remove(findById(id));
		ordersRepository.deleteById(id);		
		return test;
	}

	@Override
	public boolean update(Long id, OrdersData ordersData) {
		Orders orders = ordersRepository.findById(id).get();
		if (orders != null) {
			orders.setOrderId(ordersData.getOrderId());
			orders.setDate(ordersData.getDate());
			orders.setCustomer(ordersData.getCustomer());
			orders.setOrderItem(ordersData.getOrderItem());

			ordersRepository.save(orders);
			
			return true;
		}
		return false;
	}


}
