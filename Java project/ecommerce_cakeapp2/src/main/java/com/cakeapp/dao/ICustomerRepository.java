package com.cakeapp.dao;

import com.cakeapp.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	
}
