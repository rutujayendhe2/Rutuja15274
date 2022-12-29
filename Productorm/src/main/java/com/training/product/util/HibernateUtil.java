package com.training.product.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private SessionFactory factory;
	private static HibernateUtil hibernateUtil;

	private HibernateUtil() {
	}

	public static HibernateUtil getHibernateUtil() {
		if (hibernateUtil == null) {
			synchronized (HibernateUtil.class) {
				if (hibernateUtil == null) {
					hibernateUtil = new HibernateUtil();
				}

			}
		}
		return hibernateUtil;
	}
	
	public SessionFactory getSessionFactory() {
		if(factory==null) {
			StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
												        .configure("hibernate.cfg.xml")
												        .build();
			factory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		
		return factory;
	}
	

}
