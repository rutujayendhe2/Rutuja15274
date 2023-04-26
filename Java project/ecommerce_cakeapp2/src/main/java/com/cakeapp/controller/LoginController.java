package com.cakeapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.cakeapp.dto.CustomerData;
import com.cakeapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/authenticate", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private CustomerService customerService;
	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	
	@PostMapping("/login")
	public CustomerData create(@RequestBody CustomerData customerData) {
		
		List<CustomerData> list = new ArrayList<>();
		list = customerService.findAll();
		for(CustomerData customerData1 : list) {
			if(customerData.getEmailAdd().equals(customerData1.getEmailAdd()) && 
					bcrypt.matches(customerData.getPassword(), customerData1.getPassword())) {
				System.out.println(customerData1);
				return customerData1;
			}
		}
		return null;
	}
}