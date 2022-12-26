package com.training.cakeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.cakeapp.model.Customer;

public class CustomerImplementDao implements IDao<Customer> {
	
	private DbConnection db;
	private static CustomerImplementDao customerImplementDao;
	
	
	private CustomerImplementDao() {
		super();
	}
	

	public CustomerImplementDao(DbConnection db) {
		super();
		this.db = db;
	}
	
	public static CustomerImplementDao getCustomerDao() {
		if(customerImplementDao==null) {
			synchronized (CustomerImplementDao.class) {
				if(customerImplementDao==null) {
					customerImplementDao=new CustomerImplementDao(DbConnection.getDb());
				}
			}
		}
		return customerImplementDao;
	}

	public List<Customer> findAll() throws SQLException {
		final List<Customer> list=new ArrayList<Customer>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select customerId,firstName,lastName,emailAdd,phoneNo,address from customer";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));			
		}
		return list;
	}


	public Customer findOne(int id) throws SQLException {
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select customerId,firstName,lastName,emailAdd,phoneNo,address from customer where customerId="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Customer customer=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));	
			return customer;
		}
		return null;
	}

	public boolean createNew(Customer customer) throws SQLException {
		Connection connect=db.getConnection();		
		final String sql="insert into customer values(?,?,?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, customer.getCustomerId());
		pStatement.setString(2, customer.getFirstName());
		pStatement.setString(3, customer.getLastName());
		pStatement.setString(4, customer.getEmailAdd());
		pStatement.setString(5, customer.getPhoneNo());
		pStatement.setString(6, customer.getAddress());
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="delete from customer where customerId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	
	}

	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update product set Address=? where customerId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, customer.getCustomerId());
		pStatement.setString(2, customer.getAddress());
		
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}




	}


