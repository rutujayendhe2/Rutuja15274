package com.training.cakeapp.dao;

import java.util.List;

import com.training.cakeapp.model.Orders;
import com.training.cakeapp.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class OrderDao implements IDao<Orders> {
	private Session session;
	private Transaction transaction;
	private Query query;
	
	private static OrderDao orderDao;

    private OrderDao() {
        super();
    }
    public static OrderDao getOrderDao() {
        if(orderDao==null) {
            synchronized(OrderDao.class) {
                if(orderDao==null) {
                    orderDao=new OrderDao();
                }
            }
        }
        return orderDao;
    }
    
    
	public boolean createNew(Orders orders) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(orders) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	
	}
	public List<Orders> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Orders");
		final List<Orders> ordersList = query.list();
		transaction.commit();
		return ordersList;
	}
	public Orders findOne(int orderId) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Orders o where o.orderId=" + orderId);
		final Orders orders = (Orders) query.getSingleResult();
		transaction.commit();
		return orders;
	}
	public boolean findOneandDelete(int orderId) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Orders o where o.orderId=:id");
		query.setParameter("id", orderId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}
	public boolean findOneandUpdate(int id, Orders orders) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Orders o set o.date=:date where orderId=:orderId");
		query.setParameter("date", orders.getDate());

		query.setParameter("orderId", id);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
}
