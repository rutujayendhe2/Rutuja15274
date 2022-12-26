package com.training.cakeapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.training.cakeapp.dao.DbConnection;

public class DbConnection {

	private static DbConnection db;
	private Connection connection;

	private DbConnection() {

	}

	public static DbConnection getDb() {
		if(db==null) {
			synchronized(DbConnection.class){
				if(db==null) {
					db=new DbConnection();
				}
			}
		}
		return db;
	}
	
	public Connection getConnection() throws SQLException  {
		final String url="jdbc:postgresql://localhost:5432/CakeApp_db";
		final String userName="postgres";
		final String password="root"; 
		connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}

}
