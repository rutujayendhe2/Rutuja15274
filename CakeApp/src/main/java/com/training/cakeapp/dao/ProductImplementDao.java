package com.training.cakeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.cakeapp.model.Product;

public class ProductImplementDao implements IProductDao<Product> {
	
	private DbConnection db;
	private static ProductImplementDao productImplementDao;
	
	
	private ProductImplementDao() {
		super();
	}
	

	public ProductImplementDao(DbConnection db) {
		super();
		this.db = db;
	}
	
	public static ProductImplementDao getProductDao() {
		if(productImplementDao==null) {
			synchronized (ProductImplementDao.class) {
				if(productImplementDao==null) {
					productImplementDao=new ProductImplementDao(DbConnection.getDb());
				}
			}
		}
		return productImplementDao;
	}


	public List<Product> findAll() throws SQLException {
		final List<Product> list=new ArrayList<Product>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select productId,productName,price,weight,imageUrl,quantity from product";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6)));			
		}
		return list;
	}

	public Product findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select productId,productName,price,weight,imageUrl,quantity from product where productId="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Product product=new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
			return product;
		}
		return null;
	}

	public boolean createNew(Product product) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into product values(?,?,?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, product.getProductId());
		pStatement.setString(2, product.getProductName());
		pStatement.setDouble(3,((double)product.getPrice()));
		pStatement.setString(4, product.getWeight());
		pStatement.setString(5, product.getImageUrl());
		pStatement.setInt(6,((int) product.getQuantity()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from product where productId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update product set quantity=? where productId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, product.getProductId());

		pStatement.setInt(2, ((int)product.getQuantity()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

}
