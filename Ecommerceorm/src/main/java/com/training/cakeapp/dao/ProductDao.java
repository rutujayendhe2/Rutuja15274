package com.training.cakeapp.dao;

import java.util.List;

import com.training.cakeapp.model.Product;
import com.training.cakeapp.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductDao implements IDao<Product> {

	private Session session;
	private Transaction transaction;
	private Query query;
	
	public boolean create(Product product) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(product) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}
	public List<Product> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product");
		final List<Product> productList = query.list();
		transaction.commit();
		return productList;
	}
	public Product findOne(int id) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Product p where p.productId=" + id);
		final Product product = (Product) query.getSingleResult();
		transaction.commit();
		return product;
	}
	public boolean findOneandDelete(int productId) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Product p where p.productId=:id");
		query.setParameter("id", productId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	
	}
	
	public boolean findOneandUpdate(int id, Product newObj) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Product p set p.productName=:productName where productId=:productId");
		query.setParameter("productName", newObj.getProductName());

		query.setParameter("productId", id);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
}