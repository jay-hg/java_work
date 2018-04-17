package com.summer.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.summer.DAO.DAO;
import com.summer.model.User;

public class UserService implements Service {

	private DAO dao;
	
	public DAO getDao() {
		return dao;
	}

	@Resource(name="dao")
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public void add(Object o) {
		dao.add((User)o);
	}
	
	
}
