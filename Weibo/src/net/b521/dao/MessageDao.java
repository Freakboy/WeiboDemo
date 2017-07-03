package net.b521.dao;

import java.util.List;

import net.b521.pojo.Message;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class MessageDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void save(Message message) {
		getSession().save(message);
	}
	
	public List<Message> findAll() {
		String hql = "from Message order by id desc";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

}
