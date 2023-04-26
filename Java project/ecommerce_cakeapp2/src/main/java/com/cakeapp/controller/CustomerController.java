package com.cakeapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.cakeapp.dto.CustomerData;
import com.cakeapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(path = "/customers", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/findAll")
	public List<CustomerData> findAll() {
		return customerService.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public CustomerData findById(@PathVariable Long id) {
		return customerService.findById(id);
	}

	@PostMapping("/customer")
	public CustomerData create(@Valid @RequestBody CustomerData customerData) {
		return customerService.create(customerData);
		//return new ResponseEntity<Customer>(customerData, HttpStatus.CREATED);
	}

	@DeleteMapping("/customer/{id}")
	public boolean delete(@PathVariable Long id) {
		return customerService.delete(id);
	}
	
	@PutMapping("/customer/{id}")
		public boolean update(@PathVariable Long id, @RequestBody CustomerData customerData) {
		return customerService.update(id, customerData);
	}
}
