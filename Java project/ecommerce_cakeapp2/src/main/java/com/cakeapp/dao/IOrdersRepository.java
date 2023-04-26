package com.cakeapp.dao;

import com.cakeapp.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Orders, Long> {

}
