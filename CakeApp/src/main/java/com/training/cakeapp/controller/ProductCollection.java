package com.training.cakeapp.controller;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.dao.ProductImplementDao;
import com.training.cakeapp.model.Product;


public class ProductCollection implements IProductCollection<Product> {
	

	private static ProductCollection collection;
	private ProductImplementDao dao;
	private List<Product> productList;
	
//	private ProductCollection() throws SQLException {
//		this.dao=ProductImplementDao.getProductDao();
//		this.accountList=dao.findAll();
//	}

	private ProductCollection() {
		this.dao=ProductImplementDao.getProductDao();
	}

	public static ProductCollection getProductCollection() {
		if(collection==null) {
			synchronized (ProductCollection.class) {
				if(collection==null) {
					collection=new ProductCollection();
				}
				
			}
		}
		return collection;
	}

	public List<Product> findAll() throws SQLException {
		productList=dao.findAll();
		return productList;
	}

	public Product findOne(int id) throws SQLException {
		Product product=dao.findOne(id);
		return product;
	}
	

	public boolean createNew(Product product) throws SQLException {
		return dao.createNew(product);
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		return dao.findOneAndDelete(id);
	}

	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		return dao.findOneAndUpdate(id, product);
	}

}
