package com.training.test.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.training.dto.ProductData;
import com.training.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	private ProductData productData;
	@BeforeEach()
	
	public void beforeEach() {
		productData=new ProductData();
		
		productData.setProductName("Cake1");
		productData.setPrice(450.0);
		productData.setWeight("1Kg");
		productData.setImageUrl("https://localhost:8080/resources/static/Cake1.jpg");
	}
	
	@Test
	public void testFindAllNotNull() {
		assertNotNull(productService.findAll());
	}
	
	@Test
	public void testCreateNew() {	
		assertNotNull(productService.create(productData));
	}
	
	
	@Test
	public void testFindOneNotNull() {
		Long id=2l;
		assertNotNull(productService.findById(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Long id=1l;
		assertTrue(productService.delete(id));
	}
	
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		Long id=1l;
		assertTrue(productService.update(id, productData));
	}

}

	

