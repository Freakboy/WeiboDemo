package net.b521.dao;

import java.util.List;

import net.b521.pojo.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class UserDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	  
	
	public List<User> findAll() {
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		return query.list();
		
	}
	
	public void save (User user) {
		getSession().save(user);
	}
	
	public User findByUserName(String userName) {
		String hql = "from User where username = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, userName);
		return (User) query.uniqueResult();
		
	}

}
