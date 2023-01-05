package com.training.cakeapp.collection;

import java.sql.SQLException;
import java.util.List;

import com.training.cakeapp.dao.ProductDao;

import com.training.cakeapp.model.Product;

public class ProductCollection implements ICollection<Product> {


	private static ProductCollection collection;
	private ProductDao dao;
	private List<Product> productList;
	


	private ProductCollection() {
		this.dao=ProductDao.getProductDao();
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
		return dao.findOneandDelete(id);
	}

	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		return dao.findOneandUpdate(id, product);
	}

}
