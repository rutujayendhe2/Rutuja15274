package com.cakeapp.dao;

import com.cakeapp.model.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Long>{

}
