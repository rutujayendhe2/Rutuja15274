package com.cakeapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.cakeapp.dto.ProductData;
import com.cakeapp.exception.ItemNotFoundException;
import com.cakeapp.service.ProductService;

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
@RequestMapping(path = "/products", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/findAll")
	public List<ProductData> findAll() {
		return productService.findAll();
	}

	@GetMapping("/product/{id}")
	public ProductData findById(@PathVariable Long id) throws ItemNotFoundException {
		return productService.findById(id);
	}

	@PostMapping("/product")
	public ProductData create(@Valid @RequestBody ProductData productData) throws ItemNotFoundException {
		return productService.create(productData);
	}

	@DeleteMapping("/product/{id}")
	public boolean delete(@PathVariable Long id) {
		return productService.delete(id);
	}

	@PutMapping("/product/{id}")
	public boolean update(@PathVariable Long id, @RequestBody ProductData productData) throws ItemNotFoundException {
		return productService.update(id, productData);
	}
}
