package com.training.test.service;

import java.util.ArrayList;
import java.util.List;

import com.training.dto.ProductData;
import com.training.service.ProductService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@MockBean
	private ProductService productService;
	private ProductData productData;
	List<ProductData> list = new ArrayList<ProductData>();

	@BeforeEach()

	public void beforeEach() {
		productData = new ProductData();
		productData.setProductId(1L);
		productData.setProductName("Cake1");
		productData.setPrice(450.0);
		productData.setWeight("1Kg");
		productData.setImageUrl("https://localhost:8080/resources/static/Cake1.jpg");

	}

	@Test
	public void testFindAllNotNull() {
		List<ProductData> list = new ArrayList<ProductData>();
		ProductData product1 = new ProductData(1, "cake2", 400.0, "2Kg", "p1.jpg");
		ProductData product2 = new ProductData(2, "cake3", 500.0, "2Kg", "p2.jpg");
		list.add(product1);
		list.add(product2);
		Mockito.when(productService.findAll()).thenReturn(list);

		List<ProductData> productlist = productService.findAll();
		Assertions.assertEquals(2, productlist.size());

	}

	@Test
	public void testCreateNew() {

		ProductData product3 = new ProductData(4, "cake2", 400.0, "2Kg", "p1.jpg");

		Mockito.when(productService.create(product3)).thenReturn(productData);
		Assertions.assertNotNull(productService.create(product3));
	}

	@Test
	public void testFindOneNotNull() {

		Mockito.when(productService.findById(2L)).thenReturn(productData);
		Assertions.assertEquals(productData, productService.findById(2L));

	}

	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Mockito.when(productService.delete(2L)).thenReturn(true);
		Assertions.assertTrue(productService.delete(2L));
	}

	@Test
	public void testFindOneAndUpdate() {

		Mockito.when(productService.update(1L, productData)).thenReturn(true);
		Assertions.assertTrue(productService.update(1L, productData));
	}

}
