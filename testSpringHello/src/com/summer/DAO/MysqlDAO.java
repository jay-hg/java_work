package com.summer.DAO;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.summer.model.User;

@Component("dao")
public class MysqlDAO implements DAO {
	private SessionFactory sessionFactory;
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(User u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		System.out.println("add to mysql");
	}
	
}
