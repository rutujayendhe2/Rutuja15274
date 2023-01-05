package com.training.cakeapp.dao;

import java.util.List;

import com.training.cakeapp.model.OrderItem;
import com.training.cakeapp.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class OrderItemDao implements IDao<OrderItem> {
	
	private Session session;
	private Transaction transaction;
	private Query query;
	
	private static OrderItemDao orderItemDao;

    private OrderItemDao() {
        super();
    }
    public static OrderItemDao getOrderItemDao() {
        if(orderItemDao==null) {
            synchronized(OrderItemDao.class) {
                if(orderItemDao==null) {
                	orderItemDao=new OrderItemDao();
                }
            }
        }
        return orderItemDao;
    }
    
	public boolean createNew(OrderItem orderItem) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(orderItem) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	
	}

	public List<OrderItem> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from OrderItem");
		final List<OrderItem> orderItemList = query.list();
		transaction.commit();
		return orderItemList;
	}

	public OrderItem findOne(int itemId) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from OrderItem o where o.itemId=" + itemId);
		final OrderItem orderItem = (OrderItem) query.getSingleResult();
		transaction.commit();
		return orderItem;
	}	

	public boolean findOneandDelete(int itemId) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from OrderItem o where o.itemId=:id");
		query.setParameter("id", itemId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	public boolean findOneandUpdate(int id, OrderItem newObj) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update OrderItem o set o.quantity=:quantiy where itemId=:itemId");
		query.setParameter("quantity", newObj.getQuantity());

		query.setParameter("itemId", id);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
	
	

}
