package com.cakeapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.cakeapp.dao.IProductRepository;
import com.cakeapp.dto.ProductData;
import com.cakeapp.exception.ItemNotFoundException;
import com.cakeapp.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {


//	DTO=>Entity
	private Product getProductEntity(ProductData productData) {
		Product product = new Product();
		product.setProductId(productData.getProductId());
		product.setProductName(productData.getProductName());
		product.setPrice(productData.getPrice());
		product.setWeight(productData.getWeight());
		product.setImageUrl(productData.getImageUrl());
		return product;
	}
	
//	Entity=>DTO
	private ProductData getProductData(Product product) {
		ProductData productData = new ProductData();
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setPrice(product.getPrice());
		productData.setWeight(product.getWeight());
		productData.setImageUrl(product.getImageUrl());
	
		return productData;
	}
	
	
	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public List<ProductData> findAll() {
		List<ProductData> productDataList=new ArrayList<>();
		List<Product> products=productRepository.findAll();
		products.forEach(product->{productDataList.add(getProductData(product));});
		return productDataList;
	}

	@Override
	public ProductData findById(Long id) {
		Product product = productRepository.findById(id).orElse(null);
		if (product == null) {
			throw new ItemNotFoundException("Product Not Found"+id);
		}
		return getProductData(product);
	}

	@Override
	public ProductData create(ProductData productData) {
		Product product=getProductEntity(productData);
		Product saveProduct= productRepository.save(product);
		if (product != null) {
			
			return getProductData(product);		
			
		}else {
			throw new ItemNotFoundException("Product Not created");
		}
	}

	@Override
	public boolean delete(Long id) {
		boolean test=findAll().remove(findById(id));
		productRepository.deleteById(id);		
		return test;
	}

	@Override
	public boolean update(Long id, ProductData productData) {
		Product product = productRepository.findById(id).get();
		if (product != null) {
			product.setProductName(productData.getProductName());
			product.setWeight(productData.getWeight());
			product.setPrice(productData.getPrice());
			product.setImageUrl(productData.getImageUrl());
			productRepository.save(product);
			
			return true;
		} 
		else {
			throw new ItemNotFoundException("Product Not updated");
		}
	
	
	
	}
}
