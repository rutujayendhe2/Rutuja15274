package com.cakeapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.cakeapp.dto.OrdersData;
import com.cakeapp.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping("/findAll")
	public List<OrdersData> findAll() {
		return ordersService.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public OrdersData findById(@PathVariable Long id) {
		return ordersService.findById(id);
	}

	@PostMapping("/order")
	public OrdersData create(@Valid @RequestBody OrdersData ordersData) {
		return ordersService.create(ordersData);
	}

	@DeleteMapping("/orders/{id}")
	public boolean delete(@PathVariable Long id) {
		return ordersService.delete(id);
	}
	
	@PutMapping("/orders/{id}")
		public boolean update(@PathVariable Long id, @RequestBody OrdersData ordersData) {
		return ordersService.update(id, ordersData);
	}


}
