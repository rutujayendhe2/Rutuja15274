package com.training.cakeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.cakeapp.controller.ProductCollection;
import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.model.Product;

public class OrderItemImplementDao implements IDao<OrderItem> {

	private DbConnection db;
	private ProductImplementDao productImplementDao;
	private static OrderItemImplementDao orderItemImplementDao1;

	public OrderItemImplementDao() {
		super();
		productImplementDao = new ProductImplementDao();
		this.db = DbConnection.getDb();
	}

	public OrderItemImplementDao(DbConnection db) {
		super();
		this.db = db;
	}

	public static OrderItemImplementDao getOrderItemDao() {
		if (orderItemImplementDao1 == null) {
			synchronized (OrderItemImplementDao.class) {
				if (orderItemImplementDao1 == null) {
					orderItemImplementDao1 = new OrderItemImplementDao(DbConnection.getDb());
				}
			}
		}
		return orderItemImplementDao1;
	}

	public List<OrderItem> findAll() throws SQLException {
		final List<OrderItem> orderItems = new ArrayList<>();
		final String sql = "select itemid,productid,quantity,itemtotalprice from orderitem";
		final Connection connect = db.getConnection();
		final Statement statement = connect.createStatement();

		final ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			final int itemId = resultSet.getInt(1);
			final int productId = resultSet.getInt(2);
			
			final Product product = ProductImplementDao.getProductDao().findOne(productId);
			
			final int quantity = resultSet.getInt(3);

			final double itemTotalPrice = resultSet.getDouble(4);

			final OrderItem orderItem = new OrderItem(itemId, product, quantity, itemTotalPrice);
			orderItems.add(orderItem);

		}
		return orderItems;
	}

	public OrderItem findOne(int id) throws SQLException {
		Connection connect = db.getConnection();
		Statement statement = connect.createStatement();
		final String sql = "select itemid,productid,quantity,itemtotalprice from orderitem where itemid=" + id;
		ResultSet resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			int productId = resultSet.getInt("productid");
			Product product = ProductCollection.getProductCollection().findOne(productId);

			final OrderItem orderItem = new OrderItem(resultSet.getInt("itemid"), product, resultSet.getInt("quantity"),
					resultSet.getDouble("itemtotalprice"));

			return orderItem;
		}
		return null;
	}

	public boolean createNew(OrderItem orderItem) throws SQLException {
		Connection connect = db.getConnection();
		final String sql = "insert into orderItem values(?,?,?,?)";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, orderItem.getItemId());
		pStatement.setInt(2, orderItem.getProductId());
		pStatement.setInt(3, orderItem.getQuantity());
		pStatement.setDouble(4, ((double) orderItem.getItemTotalPrice()));

		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id) throws SQLException {
		final Connection connect = db.getConnection();
		final String sql = "delete from orderitem where itemid=?";
		final PreparedStatement pStatement = connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndUpdate(int id, OrderItem orderitem) throws SQLException {
		final Connection connect = db.getConnection();
		final String sql = "update orderitem set quantity=? where itemid=?";
		final PreparedStatement pStatement = connect.prepareStatement(sql);

		pStatement.setInt(1, orderitem.getQuantity());
		pStatement.setInt(2, (int) orderitem.getItemId());

		if (pStatement.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
}
