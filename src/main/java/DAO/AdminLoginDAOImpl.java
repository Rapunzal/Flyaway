package DAO;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateUtil.HibernateUtil;
import persistence.Admin;

public class AdminLoginDAOImpl {

	SessionFactory sessionFactoryObj=HibernateUtil.getSessionFactory();
	Session sessionObj;
	
	public int addAdminClass(Admin admin) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.save(admin);
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
	public boolean validate(String userName,String password) {
		System.out.println("in validate=====");
		try {
		sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();
		
		Admin admin=(Admin) sessionObj.createQuery("FROM Admin A where A.name=:userName").setParameter("userName", userName).uniqueResult();
		if(admin!=null && admin.getPassword().equals(password)) {
			return true;
		}
		
		sessionObj.getTransaction().commit();
		}catch(Exception e) {
			if(sessionObj.getTransaction()!=null) {
				sessionObj.getTransaction().rollback();
			}
			e.printStackTrace();
			return false;
		}finally {
			sessionObj.close();
		}
		return false;
	}
	
	public boolean changePassword(String userName,String password) 
	{
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			
			String hql ="update Admin A set A.password=:password where A.name=:userName";
			Query query = sessionObj.createQuery(hql);
			query.setParameter("password", password);
			query.setParameter("userName", userName);
			int count= query.executeUpdate();
			System.out.println(count+" rows updated");
			
			sessionObj.getTransaction().commit();
			return true;
			}catch(Exception e) {
				if(sessionObj.getTransaction()!=null) {
					sessionObj.getTransaction().rollback();
				}
				e.printStackTrace();
				return false;
			}finally {
				sessionObj.close();
			}
	}
}
