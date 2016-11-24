package com.keylesson.test;

import java.util.Date;

import org.hibernate.Session;

import com.keylesson.persistence.Customer;
import com.keylesson.persistence.Duty;
import com.keylesson.util.HibernateUtil;

public class Tester {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			// Create customer
			Customer customer = new Customer("Mlle", "Khadija");

			// Create two orders
			Duty order1 = new Duty("X111", new Float("150.13"), new Date());
			Duty order2 = new Duty("Y222", new Float("300.10"), new Date());

			// Set orders in customer
			customer.getOrders().add(order1);
			customer.getOrders().add(order2);
			// Set customer in orders
			order1.setCustomer(customer);
			order2.setCustomer(customer);

			// Save customer
			session.save(customer);
			// Save orders
			session.save(order1);
			session.save(order2);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error :" + e);
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}

}
