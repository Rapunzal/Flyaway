package DAO;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateUtil.HibernateUtil;
import persistence.Admin;
import persistence.Flight;

public class FlightDAOImpl {

	SessionFactory sessionFactoryObj = HibernateUtil.getSessionFactory();
	 Session sessionObj;
	 
	 public int addFlight(Flight flight) {
		 try {
				sessionObj = sessionFactoryObj.openSession();
				sessionObj.getTransaction().begin();
				sessionObj.saveOrUpdate(flight);
				sessionObj.getTransaction().commit();
			}
			catch(Exception ex) {
				if(sessionObj.getTransaction() != null) {
					sessionObj.getTransaction().rollback();
				}
				ex.printStackTrace();
				return 0;
			}
			finally {
				sessionObj.close();
			}
			
			return 1;
		}
	 
	
		public List<Flight> getFlight(String source,String Destination,String Date,int noOfPersons) {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			
			Query query= sessionObj.createQuery("FROM Flight A where A.source=:source and A.destination=:destination");
			query.setParameter("source", source);
			query.setParameter("destination", Destination);
			List<Flight> flight=(List<Flight>)query.list();
			return flight;
			
		}


		public List<Flight> getFlightList() {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			System.out.println("--------");
			Query query= sessionObj.createQuery("FROM Flight");
		
			List<Flight> flight=(List<Flight>)query.list();
			for(Flight f:flight)
			System.out.println("flight price======="+f.getPrice());
			return flight;
			
		}
}
