package com.keylesson.test;

import java.util.Date;

import com.keylesson.persistence.Employee;
import org.hibernate.Session;

import com.keylesson.persistence.Customer;
import com.keylesson.persistence.Duty;
import com.keylesson.util.HibernateUtil;

public class Tester {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			Employee employee = new Employee("kowalski","Jan");


			Duty duty1 = new Duty(2,"styczeń",10,19,2008);
			Duty duty2 = new Duty(3,"luty",10,19,2008);


			employee.getDuty().add(duty1);
			employee.getDuty().add(duty2);

			duty1.setEmployee(employee);
			duty2.setEmployee(employee);


			session.save(employee);

			
			session.save(employee);
			session.save(employee);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error :" + e);
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}

}
