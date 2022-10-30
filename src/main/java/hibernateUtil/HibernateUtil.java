package hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactoryObj;
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configObj =new Configuration();
			configObj.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
			
			sessionFactoryObj = configObj.buildSessionFactory(serviceRegistry);
			
			
			
		}catch(Throwable e) {
			System.out.println("Session creation failed");
			e.printStackTrace();
		}
		return sessionFactoryObj;
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactoryObj ==null) {
			sessionFactoryObj=buildSessionFactory();
		}
		return sessionFactoryObj;
	}
	
}
