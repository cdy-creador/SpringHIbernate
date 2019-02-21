package com.practice.SpringHibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.practice.SpringHibernate.model.User;

public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return userList;
	}

	
}
