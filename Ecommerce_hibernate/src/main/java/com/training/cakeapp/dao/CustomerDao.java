package com.training.cakeapp.dao;

import java.util.List;

import com.training.cakeapp.model.Customer;
import com.training.cakeapp.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CustomerDao implements IDao<Customer> {

	private Session session;
	private Transaction transaction;
	private Query query;
	
	private static CustomerDao customerDao;

    private CustomerDao() {
        super();
    }
    public static CustomerDao getCustomerDao() {
        if(customerDao==null) {
            synchronized(OrderDao.class) {
                if(customerDao==null) {
                	customerDao=new CustomerDao();
                }
            }
        }
        return customerDao;
    }
	
	public boolean createNew(Customer customer) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		if (session.save(customer) != null) {
			result = true;
		}
		transaction.commit();
		return result;
	}

	@Override
	public List<Customer> findAll() {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Customer");
		final List<Customer> customerList = query.list();
		transaction.commit();
		return customerList;
	}

	@Override
	public Customer findOne(int id) {
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("from Customer c where c.customerId=" + id);
		final Customer customer = (Customer) query.getSingleResult();
		transaction.commit();
		return customer;
	}

	@Override
	public boolean findOneandDelete(int customerId) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Delete from Customer c where c.customerId=:id");
		query.setParameter("id", customerId);
		final int statusDelete = query.executeUpdate();
		transaction.commit();
//		System.out.println("statusDeleted: "+statusDelete);
		if (statusDelete > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean findOneandUpdate(int id, Customer newObj) {
		boolean result = false;
		session = HibernateUtil.getHibernateUtil().getSessionFactory().openSession();
		transaction = session.beginTransaction();
		query = session.createQuery("Update Customer c set c.firstName=:firstName where customerId=:customerId");
		query.setParameter("firstName", newObj.getFirstName());

		query.setParameter("customerId", id);
		final int statusUpdate = query.executeUpdate();
		transaction.commit();
		if (statusUpdate > 0) {
			result = true;
		}
		return result;
	}
	
}
