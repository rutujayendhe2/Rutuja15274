package com.cakeapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.cakeapp.dao.IOrderItemRepository;
import com.cakeapp.dto.OrderItemData;
import com.cakeapp.model.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderItemService implements IOrderItemService {

//	DTO=>Entity
	private OrderItem getOrderItemEntity(OrderItemData orderItemData) {
		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(orderItemData.getItemId());
		orderItem.setProduct(orderItemData.getProduct());
		orderItem.setQuantity(orderItemData.getQuantity());
		
		return orderItem;
	}

//	Entity=>DTO
	private OrderItemData getOrderItemData(OrderItem orderItem) {
		OrderItemData orderItemData = new OrderItemData();
		orderItemData.setItemId(orderItem.getItemId());
		orderItemData.setProduct(orderItem.getProduct());
		orderItemData.setQuantity(orderItem.getQuantity());
		return orderItemData;
	}
	
	@Autowired
	private IOrderItemRepository orderItemRepository;
	
	@Override
	public List<OrderItemData> findAll() {
		List<OrderItemData> orderItemDataList = new ArrayList<>();
		List<OrderItem> orderItems = orderItemRepository.findAll();
		orderItems.forEach(orderItem -> {
			orderItemDataList.add(getOrderItemData(orderItem));
		});
		return orderItemDataList;
		}

	@Override
	public OrderItemData findById(Long id) {
		Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
		if (orderItemOptional == null) {
			new EntityNotFoundException("OrderItem Not Found");
		}
		return getOrderItemData(orderItemOptional.get());

	}
	
	@Override
	public OrderItemData create(OrderItemData orderItemData) {
		OrderItem orderItem=getOrderItemEntity(orderItemData);
		return getOrderItemData(orderItemRepository.save(orderItem));
	}

	@Override
	public boolean delete(Long id) {
		boolean test=findAll().remove(findById(id));
		orderItemRepository.deleteById(id);		
		return test;
	}

	@Override
	public boolean update(Long id, OrderItemData orderItemData) {
		OrderItem orderItem = orderItemRepository.findById(id).get();
		if (orderItem != null) {
			orderItem.setProduct(orderItemData.getProduct());
			orderItem.setQuantity(orderItemData.getQuantity());
			orderItemRepository.save(orderItem);
			
			return true;
		}
		return false;
	}

}
