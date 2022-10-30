package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateUtil.HibernateUtil;
import persistence.Admin;
import persistence.Passenger;

public class SaveRegistrationDAO {

	SessionFactory sessionFactoryObj=HibernateUtil.getSessionFactory();
	Session sessionObj;
	
	public int addPassengerC(Passenger pass) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.save(pass);
			sessionObj.getTransaction().commit();
		}catch(Exception e) {
			if(sessionObj.getTransaction()!=null) {
				sessionObj.getTransaction().rollback();
			}
			e.printStackTrace();
			return 0;
		}finally {
			sessionObj.close();
		}
		return 1;
	}
	
	public int getPassengerId(String emailId) {
		System.out.println("in validate=====");
		try {
		sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();
		
		Passenger pass=(Passenger) sessionObj.createQuery("FROM Passenger A where A.emailId=:emailid").setParameter("emailid", emailId).uniqueResult();
		if(pass!=null) {
			return pass.getPassengerId();
		}
		
		sessionObj.getTransaction().commit();
		}catch(Exception e) {
			if(sessionObj.getTransaction()!=null) {
				sessionObj.getTransaction().rollback();
			}
			e.printStackTrace();
			return 0;
		}finally {
			sessionObj.close();
		}
		return 0;
	}
	
}
