package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.UserInfo;
import com.niit.dao.UserDao;
@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{
	 @Autowired
	 SessionFactory sessionFactory;
	
	
	 
	@Override
	@Transactional
	public void insertRow(UserInfo userinfo) {
		Session session = sessionFactory.getCurrentSession();	

	session.save(userinfo);
	
	
	}
	
		


	
	
}



